package br.com.desafio.utils;

import java.util.Date;

import br.com.desafio.domain.Boleto;

public abstract class Utils {

	public static Boolean validarDataValida(Date data) {
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
