package br.com.desafio.domain;

import org.springframework.http.HttpStatus;

/**
 * Mensagens de retorno.
 * 
 * @author CruzPH
 *
 */
public enum MensagensRespostaEnum {

	RET_CREATED_SUCCESS("Bankslip created", HttpStatus.CREATED), 
	RET_CREATED_INVALID(
			"Invalid bankslip provided.The possible reasons are: "
					+ "A field of the provided bankslip was null or with invalid values",
			HttpStatus.UNPROCESSABLE_ENTITY), 
	RET_CREATE_ERROR("Bankslip not provided in the request body",
					HttpStatus.BAD_REQUEST), 
	RET_FIND_NO_CONTENT("There no are bankslips",
							HttpStatus.NO_CONTENT), 
	RET_FIND_NOT_FOUND("Bankslip not found with the specified id",
									HttpStatus.NOT_FOUND), 
	RET_UPDATE_INVALID(
											"Bankslip not modified.The status is the same or ID of link does not corresponding the ID of body or Status was invalid",
											HttpStatus.FORBIDDEN), 
	RET_FIND_INVALID_ID(
													"Invalid id provided - it must be a valid UUID",
													HttpStatus.BAD_REQUEST), 
	RET_UPDATE_SUCCESS_CANCELLED(
															"Bankslips cancelled",
															HttpStatus.OK), 
	RET_UPDATE_SUCCESS_PAID("Bankslips paid",
																	HttpStatus.OK);

	private String resposta;
	private HttpStatus status;

	MensagensRespostaEnum(String resposta, HttpStatus status) {
		this.resposta = resposta;
		this.status = status;
	}

	/**
	 * @return the resposta
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * @param resposta
	 *            the resposta to set
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
