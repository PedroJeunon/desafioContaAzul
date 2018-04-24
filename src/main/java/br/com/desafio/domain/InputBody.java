package br.com.desafio.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe de entrada para o microserviço de liberação de unidades agregadas.
 * 
 * @author LuizTadF
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body", propOrder = { "numeroContratoUnidade", "tipoOperacao" })
public class InputBody {

	private String numeroContratoUnidade;
	private String tipoOperacao;

	public String getNumeroContratoUnidade() {
		return numeroContratoUnidade;
	}

	public void setNumeroContratoUnidade(String numeroContratoUnidade) {
		this.numeroContratoUnidade = numeroContratoUnidade;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String value) {
		this.tipoOperacao = value;
	}

}
