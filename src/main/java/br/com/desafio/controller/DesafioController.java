package br.com.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.Input;
import br.com.desafio.domain.Output;
import br.com.desafio.exception.DesafioException;
import br.com.desafio.service.DesafioService;

/**
 * Controller.
 * 
 * @author LuizTadF
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/rs/liberacao", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DesafioController {

	@Autowired
	private DesafioService liberacaoService;

	@RequestMapping(path = "/v1/liberar/", method = RequestMethod.POST)
	public Output liberar(@RequestBody Input liberacao) throws DesafioException {
		return null;
	}
}
