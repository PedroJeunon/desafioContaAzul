package br.com.desafio.utils;

import java.util.Date;
import java.util.UUID;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.MensagensRespostaEnum;

public abstract class Utils {

	public static Boolean validarDataValida(Date data) {
		return true;
	}

	public static Boolean UUIDvalido(String uuidBody) {
		try {
			UUID.fromString(uuidBody);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica se pelo menos um campo está vazio e retorna.
	 * 
	 * @param boleto
	 * @return
	 */
	public static Boolean existeCamposVazios(Boleto boleto) {
		if (boleto.getCustomer() == null) {
			return true;
		}

		if (boleto.getDue_date() == null) {
			return true;
		}

		if (boleto.getStatus() == null) {
			return true;
		}

		return false;
	}
}
