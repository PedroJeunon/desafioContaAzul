package br.com.desafio.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoDetalhe;
import br.com.desafio.domain.MensagensRespostaEnum;
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
		MensagensRespostaEnum retorno = desafioService.criarBoleto(boleto);
		return new ResponseEntity<Object>(retorno.getResposta(), retorno.getStatus());
	}

	/**
	 * Metodo que busca todos os boletos na base.
	 * 
	 * @return List<Boleto>
	 */
	@RequestMapping(path = "/bankslips", method = RequestMethod.GET)
	public ResponseEntity<Object> listarBoletos() {
		List<BoletoDetalhe> boletos = desafioService.listarBoletos();
		if (boletos.isEmpty()) {
			return new ResponseEntity<Object>(MensagensRespostaEnum.RET_FIND_NO_CONTENT.getStatus());
		}

		return new ResponseEntity<Object>(boletos, HttpStatus.OK);
	}

	@RequestMapping(path = "/bankslips/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boleto> detalharBoleto(@PathVariable("id") String id) throws Exception {
		Boleto boleto = desafioService.recuperarBoleto(id);
		return new ResponseEntity<Boleto>(boleto, HttpStatus.OK);
	}

	@RequestMapping(path = "/bankslips/{id}/pay", method = RequestMethod.PUT)
	public ResponseEntity<Object> pagarBoleto(@PathVariable("id") String id, @RequestBody Boleto boleto) {
		return alterarStatus(id, boleto);
	}

	@RequestMapping(path = "/bankslips/{id}/cancel", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancelarBoleto(@PathVariable("id") String id, @RequestBody Boleto boleto) {
		return alterarStatus(id, boleto);
	}

	private ResponseEntity<Object> alterarStatus(String id, Boleto boleto) {
		MensagensRespostaEnum retorno = desafioService.alterarStatusBoleto(id, boleto);
		return new ResponseEntity<Object>(retorno.getResposta(), retorno.getStatus());
	}

}
