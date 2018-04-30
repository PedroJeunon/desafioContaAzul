package br.com.desafio.utils;

import java.util.UUID;

public abstract class Utils {

	public static Boolean UUIDvalido(String uuidBody) {
		try {
			UUID.fromString(uuidBody);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
