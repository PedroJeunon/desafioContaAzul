package br.com.desafio.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.domain.Boleto;
import br.com.desafio.domain.BoletoDetalhe;
import br.com.desafio.domain.BoletoRepository;
import br.com.desafio.domain.MensagensRespostaEnum;
import br.com.desafio.domain.StatusEnum;
import br.com.desafio.utils.Utils;

@Service
public class DesafioServiceImpl implements DesafioService {

	@Autowired
	private BoletoRepository repository;

	public MensagensRespostaEnum criarBoleto(Boleto boleto) {
		try {
			// Metodo para geração do ID randomico
			String uuid = UUID.randomUUID().toString();
			boleto.setId(uuid);
			repository.save(boleto);
			return MensagensRespostaEnum.RET_CREATED_SUCCESS;
		} catch (Exception e) {
			return MensagensRespostaEnum.RET_CREATED_INVALID;
		}

	}

	public Boleto recuperarBoleto(String id) throws Exception {
		Optional<Boleto> boleto = repository.findById(id);

		if (!Utils.UUIDvalido(id)) {
			throw new Exception(MensagensRespostaEnum.RET_FIND_INVALID_ID.getResposta());
		}

		if (!boleto.isPresent()) {
			throw new Exception(MensagensRespostaEnum.RET_FIND_NOT_FOUND.getResposta());
		}

		if (StatusEnum.PENDING.equals(boleto.get().getStatus())) {
			LocalDate dataBoleto = boleto.get().getDue_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period p = Period.between(dataBoleto, LocalDate.now());

			double calculo;
			if (p.getMonths() > 0 || p.getYears() > 0) {
				calculo = (double) (boleto.get().getTotal_in_cents() * 0.01);
				boleto.get().setFine(calculo);
			} else {
				if (p.getDays() > 10) {
					calculo = (double) (boleto.get().getTotal_in_cents() * 0.01);
					boleto.get().setFine(calculo);
				} else if (p.getDays() > 0) {
					calculo = (double) (boleto.get().getTotal_in_cents() * 0.005);
					boleto.get().setFine(calculo);
				}
			}
		}

		return boleto.get();
	}

	public List<BoletoDetalhe> listarBoletos() {
		List<Boleto> boletos = repository.findAll();

		List<BoletoDetalhe> boletosModificados = new ArrayList<BoletoDetalhe>();
		for (Boleto bol : boletos) {
			BoletoDetalhe boletoDetalhe = new BoletoDetalhe(bol.getId(), bol.getDue_date(), bol.getTotal_in_cents(),
					bol.getCustomer());
			boletosModificados.add(boletoDetalhe);
		}

		return boletosModificados;
	}

	public MensagensRespostaEnum alterarStatusBoleto(String id, Boleto boletoEntrada) {

		if (!Utils.UUIDvalido(id)) {
			return MensagensRespostaEnum.RET_FIND_INVALID_ID;
		}

		Optional<Boleto> boleto = repository.findById(id);

		if (!boleto.isPresent()) {
			return MensagensRespostaEnum.RET_FIND_NOT_FOUND;
		}

		if (boleto.get().getStatus().equals(boletoEntrada.getStatus())
				|| !boleto.get().getId().equals(boletoEntrada.getId())
				|| !StatusEnum.existeStatus(boletoEntrada.getStatus())) {
			return MensagensRespostaEnum.RET_UPDATE_INVALID;

		} else {
			boleto.get().setStatus(boletoEntrada.getStatus());
			repository.save(boleto.get());
			if (boleto.get().getStatus().equals(StatusEnum.CANCELLED)) {
				return MensagensRespostaEnum.RET_UPDATE_SUCCESS_CANCELLED;
			} else {
				return MensagensRespostaEnum.RET_UPDATE_SUCCESS_PAID;
			}
		}
	}

}
