package br.com.desafio.exception;

/**
 * Exception padrão.
 * 
 * @author LuizTadF
 *
 */
public class DesafioException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão.
	 * 
	 * @param exception
	 */
	public DesafioException() {
	}

	/**
	 * Construtor com mensagem.
	 * 
	 * @param message
	 */
	public DesafioException(String message) {
		super(message);
	}

	/**
	 * Construtor com mensagem e exception.
	 * 
	 * @param message
	 * @param e
	 */
	public DesafioException(String message, Exception e) {
		super(message, e);
	}

}
