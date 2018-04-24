package br.com.desafio.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe de inicialização SpringBoot.
 * d
 * @author LuizTadF
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	/**
	 * Metodo de inicialização padrão.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Microservice Liberação Starting...");
		SpringApplication.run(Application.class, args);
		LOG.info("Microservice Liberação Started!");
	}

}