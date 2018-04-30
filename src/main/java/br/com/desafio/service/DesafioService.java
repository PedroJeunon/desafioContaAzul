package br.com.desafio.service;

import java.util.List;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoDetalhe;
import br.com.desafio.domain.MensagensRespostaEnum;

public interface DesafioService {

	/**
	 * Service que cria o boleto no banco.
	 * 
	 * @param boleto
	 * @return {@link MensagensRespostaEnum}
	 */
	MensagensRespostaEnum criarBoleto(Boleto boleto);

	/**
	 * Metodo para recuperar um boleto baseado no id do boleto.
	 * 
	 * @param id
	 * @return Boleto
	 * @throws Exception
	 */
	Boleto recuperarBoleto(String id) throws Exception;

	/**
	 * Metodo que busca todos os boletos criados.
	 * 
	 * @return <List> BoletoDetalhe
	 */
	List<BoletoDetalhe> listarBoletos();

	/**
	 * Metodo que altera
	 * 
	 * @param id
	 * @param boletoEntrada
	 * @return
	 */
	MensagensRespostaEnum alterarStatusBoleto(String id, Boleto boletoEntrada);

	/**
	 * Metod que deleta todos os boletos da base.
	 */
	void deleteAll();

	/**
	 * Metodo criado para realizar testes unitarios. Busca um boleto por Customer.
	 * 
	 * @param customer
	 * @return
	 */
	Boleto findByCustomer(String customer);

}
