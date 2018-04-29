package br.com.desafio.application;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.desafio.domain.MensagensRespostaEnum;

/**
 * Controller de {@link Errors#}
 * 
 * @author CruzPH
 *
 */
@ControllerAdvice
public class DesafioControllerAdvice {

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Object> handleError(InvalidFormatException ex) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(MensagensRespostaEnum.RET_CREATED_INVALID.getResposta());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleError(HttpMessageNotReadableException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MensagensRespostaEnum.RET_CREATE_ERROR.getResposta());
	}

}
