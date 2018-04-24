package br.com.desafio.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Output body.
 * 
 * @author LuizTadF
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body", propOrder = {
    "indicadorResultado",
    "descricaoResultado"
})
public class OutputBody {

	private Integer indicadorResultado;
	private String descricaoResultado;

	public Integer getIndicadorResultado() {
		return indicadorResultado;
	}

	public void setIndicadorResultado(Integer value) {
		this.indicadorResultado = value;
	}

	public String getDescricaoResultado() {
		return descricaoResultado;
	}

	public void setDescricaoResultado(String value) {
		this.descricaoResultado = value;
	}

}
