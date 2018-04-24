package br.com.desafio.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe de entrada do microserviço de liberação de unidades agregadas.
 * 
 * @author LuizTadF
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "head", "body" })
@XmlRootElement(name = "input")
public class Input {

	private InputBody body;

	public InputBody getBody() {
		return body;
	}

	public void setBody(InputBody body) {
		this.body = body;
	}
}
