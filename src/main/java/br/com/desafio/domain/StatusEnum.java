package br.com.desafio.domain;

public enum StatusEnum {
	PENDING("Bankslip pending"), PAID("Bankslip paid"), CANCELED("Bankslip canceled");

	private String texto;

	private StatusEnum(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 *            the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
