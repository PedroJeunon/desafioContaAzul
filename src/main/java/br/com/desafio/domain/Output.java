package br.com.desafio.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe de retorno do serviço.
 * 
 * @author LuizTadF
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "body" })
@XmlRootElement(name = "output")
public class Output {

	private OutputBody body;

	public OutputBody getBody() {
		return body;
	}

	public void setBody(OutputBody body) {
		this.body = body;
	}
}
