package br.com.desafio.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, String> {

	Boleto findByCustomer(String customer);
}
