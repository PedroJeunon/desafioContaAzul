package br.com.desafio.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoRepository;

@Service
public class DesafioService {

	@Autowired
	private BoletoRepository repository;

	public Boleto criarBoleto(Boleto boleto) throws Exception {
		try {
			// Metodo para geração do ID randomico
			String uuid = UUID.randomUUID().toString();
			boleto.setId(uuid);
			return repository.save(boleto);
		} catch (Exception e) {
			throw new Exception("Bankslip not found with the specified id");
		}

	}

	public Boleto recuperarBoleto(String id) {
		return repository.findById(id).get();
	}

	public List<Boleto> listarBoletos() {
		return repository.findAll();
	}

	public Boleto alterarStatusBoleto(String id, Boleto boletoEntrada) throws Exception {
		try {
			Boleto boleto = repository.findById(id).get();
			if (boleto.getStatus().equals(boletoEntrada.getStatus()) || !boletoEntrada.getId().equals(id)) {
				throw new Exception("Bankslip not modified");
			} else {
				boleto.setStatus(boletoEntrada.getStatus());
				return repository.save(boleto);
			}
		} catch (Exception e) {
			throw new NoSuchFieldException("Bankslip not found with the specified id");
		}
	}

}
