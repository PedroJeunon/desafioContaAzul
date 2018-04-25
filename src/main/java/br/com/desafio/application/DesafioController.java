package br.com.desafio.application;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.StatusEnum;
import br.com.desafio.exception.MensagensResposta;
import br.com.desafio.service.DesafioService;

/**
 * Controller.
 * 
 * @author CruzPH
 *
 */
@RestController
@RequestMapping(path = "/rest")
public class DesafioController {

	@Autowired
	private DesafioService desafioService;

	@RequestMapping(path = "/bankslips", method = RequestMethod.POST)
	public ResponseEntity<Object> criarBoleto(@RequestBody Boleto boleto) {

		try {
			boleto = desafioService.criarBoleto(boleto);
		} catch (Exception e) {
			return new ResponseEntity<Object>(
					new MensagensResposta("Invalid bankslip provided.The possible reasons are:\r\n"
							+ "A field of the provided bankslip was null or with invalid values"),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<Object>(new MensagensResposta("Bankslip created"), HttpStatus.CREATED);

	}

	/**
	 * Metodo que busca todos os boletos na base.
	 * 
	 * @return List<Boleto>
	 */
	@RequestMapping(path = "/bankslips", method = RequestMethod.GET)
	public ResponseEntity<List<Boleto>> listarBoletos() {
		List<Boleto> boletos = desafioService.listarBoletos();
		if (boletos.isEmpty()) {
			return new ResponseEntity<List<Boleto>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Boleto>>(boletos, HttpStatus.OK);
	}

	@RequestMapping(path = "/bankslips/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boleto> detalharBoleto(@PathVariable("id") String id) {
		Boleto bol = desafioService.recuperarBoleto(id);
		return new ResponseEntity<Boleto>(bol, HttpStatus.ALREADY_REPORTED);
	}

	@RequestMapping(path = "/bankslips/{id}/pay", method = RequestMethod.PUT)
	public ResponseEntity<Object> pagarBoleto(@PathVariable("id") String id,
			@PathVariable("status") StatusEnum status) {
		return alterarStatus(id, status);
	}

	@RequestMapping(path = "/bankslips/{id}/cancel", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancelarBoleto(@PathVariable("id") String id,
			@PathVariable("status") StatusEnum status) {
		return alterarStatus(id, status);
	}

	private ResponseEntity<Object> alterarStatus(String id, StatusEnum status) {
		try {
			desafioService.alterarStatusBoleto(id, status);
		} catch (Exception e) {
			// Condição criada para verificar se o boleto ja foi cancelado
			if (e.equals("Bankslip not modified")) {
				return new ResponseEntity<Object>(new MensagensResposta(e.getMessage()), HttpStatus.NOT_MODIFIED);
			} else {

				return new ResponseEntity<Object>(new MensagensResposta(e.getMessage()), HttpStatus.NOT_FOUND);
			}
		}

		return new ResponseEntity<Object>(new MensagensResposta(status.getTexto()), HttpStatus.OK);
	}

}
