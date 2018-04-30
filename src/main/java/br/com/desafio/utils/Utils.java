package br.com.desafio.utils;

import java.util.UUID;

public abstract class Utils {

	/**
	 * Validador de id no formato UUID.
	 * 
	 * @param uuidBody
	 * @return <true> valido e <false> invalido
	 */
	public static Boolean UUIDvalido(String uuidBody) {
		try {
			UUID.fromString(uuidBody);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
