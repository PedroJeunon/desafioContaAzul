package br.com.desafio.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.Boleto;

/**
 * Controller.
 * 
 * @author CruzPH
 *
 */
@RestController
@RequestMapping(path = "/rest")
public class DesafioController {

	// @Autowired
	// private DesafioService desafioService;

	@RequestMapping(path = "/bankslips", method = RequestMethod.POST)
	public ResponseEntity<?> criarBoleto(@RequestBody Boleto boleto) {
		System.out.print("Recebend boleto");
		System.out.print(boleto);
		return new ResponseEntity<Boleto>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "/bankslips", method = RequestMethod.GET)
	public ResponseEntity<Boleto> listarBoletos() {
		System.out.print("Listando boletos");
		Boleto bol = new Boleto("1", "1000", "1000", "1000", "1000");
		return new ResponseEntity<Boleto>(bol, HttpStatus.OK);
	}

	@RequestMapping(path = "/bankslips/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boleto> detalharBoleto(@PathVariable("id") String id) {
		System.out.print("Buscando Detalhe Boleto");
		Boleto bol = new Boleto(id, "1000", "1000", "1000", "1000");
		return new ResponseEntity<Boleto>(bol, HttpStatus.ALREADY_REPORTED);
	}

	@RequestMapping(path = "/bankslips/{id}/pay", method = RequestMethod.PUT)
	public ResponseEntity<Boleto> pagarBoleto(@PathVariable("id") String id) {
		System.out.print("Pagando Boleto");
		Boleto bol = new Boleto(id, "1000", "1000", "1000", "1000");
		return new ResponseEntity<Boleto>(bol, HttpStatus.BAD_GATEWAY);
	}

	@RequestMapping(path = "/bankslips/{id}/cancel", method = RequestMethod.DELETE)
	public ResponseEntity<Boleto> cancelarBoleto(@PathVariable("id") String id) {
		System.out.print("Cancelando Boleto");
		Boleto bol = new Boleto(id, "1000", "1000", "1000", "1000");
		return new ResponseEntity<Boleto>(bol, HttpStatus.CHECKPOINT);
	}

}
