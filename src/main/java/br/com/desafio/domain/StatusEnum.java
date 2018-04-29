package br.com.desafio.domain;

public enum StatusEnum {
	PENDING, PAID, CANCELLED;

	public static Boolean existeStatus(StatusEnum statusNovo) {
		for (StatusEnum status : StatusEnum.values()) {
			if (status.equals(statusNovo)) {
				return true;
			}
		}
		return false;
	}
}
