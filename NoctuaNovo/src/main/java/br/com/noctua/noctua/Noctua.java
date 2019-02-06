package br.com.noctua.noctua;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Noctua {
	
	private static final Logger LOGGER = LoggerFactory.logger(Noctua.class);
	private static final String ERROR_MESSAGE = "Erro ao iniciar aplicação. \n Erro: %s";

	public static void main(String[] args) {
		try {
			SpringApplication.main(args);
		} catch (Exception e) {
			LOGGER.error(String.format(ERROR_MESSAGE, e.getMessage()));
		}

	}

}
