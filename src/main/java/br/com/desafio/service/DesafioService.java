package br.com.desafio.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoRepository;
import br.com.desafio.domain.StatusEnum;
import br.com.desafio.utils.Utils;

@Service
public class DesafioService {

	@Autowired
	private BoletoRepository repository;

	public Boleto criarBoleto(Boleto boleto) throws Exception {
		/*
		 * if (Utils.existeCamposVazios(boleto)) { return null; }
		 */

		// Metodo para geração do ID randomico
		String uuid = UUID.randomUUID().toString();
		boleto.setId(uuid);

		return repository.save(boleto);
	}

	public Boleto recuperarBoleto(String id) {
		return repository.findById(id).get();
	}

	public List<Boleto> listarBoletos() {
		return repository.findAll();
	}

	// TODO Ver retorno de status
	public Boleto alterarStatusBoleto(String id, StatusEnum novo) throws Exception {
		Boleto boleto = repository.findById(id).get();
		if (boleto == null) {
			throw new Exception("Bankslip not found with the specified id");
		}

		if (boleto.getStatus().equals(novo)) {
			throw new Exception("Bankslip not modified");
		} else {
			boleto.setStatus(novo);
			return repository.save(boleto);
		}
	}

}
