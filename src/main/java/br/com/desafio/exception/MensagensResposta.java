package br.com.desafio.exception;

/**
 * Mensagens de retorno.
 * 
 * @author CruzPH
 *
 */
public class MensagensResposta {

	private String resposta;

	public MensagensResposta() {
	}

	public MensagensResposta(String resposta) {
		this.resposta = resposta;
	}

	/**
	 * @return the mensagem
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * @param mensagem
	 *            the mensagem to set
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
