package br.com.desafio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe de inicialização SpringBoot.
 * 
 * @author CruzPH
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "br.com.desafio", "br.com.desafio.application", "br.com.desafio.service" })
@EntityScan({ "br.com.desafio.domain" })
@EnableJpaRepositories("br.com.desafio.domain")
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	/**
	 * Metodo de inicialização padrão.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Iniciando API...");
		SpringApplication.run(Application.class, args);
		LOG.info("API iniciada!");
	}

}