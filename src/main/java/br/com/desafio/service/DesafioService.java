package br.com.desafio.service;

import java.util.List;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoDetalhe;
import br.com.desafio.domain.MensagensRespostaEnum;

public interface DesafioService {

	MensagensRespostaEnum criarBoleto(Boleto boleto);

	Boleto recuperarBoleto(String id) throws Exception;

	List<BoletoDetalhe> listarBoletos();

	MensagensRespostaEnum alterarStatusBoleto(String id, Boleto boletoEntrada);

}
