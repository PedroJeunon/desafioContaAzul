package br.com.desafio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.desafio.exception.DesafioException;

/**
 * Advice.
 * @author LuizTadF
 *
 */
@ControllerAdvice
public class DesafioControllerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(DesafioControllerAdvice.class);

	@ResponseBody
	@ExceptionHandler(DesafioException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ResponseEntity<?> internalErrorExceptionHandler(DesafioException ex) {
		return null;
//		Output servicoRetorno = new Output();
//
//		LOG.error(ex.getMessage());
//
//		OutputBody bodyRetorno = new OutputBody();
//
//		bodyRetorno.setIndicadorResultado(IndicadorRetornoEnum.ERRO_FATAL.getCodigo());
//		bodyRetorno.setDescricaoResultado("Ocorreu um erro de infraestrutura!");
//
//		servicoRetorno.setBody(bodyRetorno);
//
//		return ResponseEntity.ok().body(servicoRetorno);
	}

}
