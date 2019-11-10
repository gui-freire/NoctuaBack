package br.com.noctua.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptoUtils {
	
	private final Logger LOGGER = LoggerFactory.getLogger(CryptoUtils.class);

	public String saltPassword(String password) {
		if (password.isEmpty() || password == null || password.equals("")) {
			String msgError = "Senha informada vazia";
			LOGGER.error(msgError);
			throw new NullPointerException(msgError);
		}
		
		try {
			LOGGER.info("Iniciando criptografia");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder.encode(password);
		} catch (Exception e) {
			LOGGER.error("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}
	
	public boolean comparePasswords(String rawPassword, String hashPassword) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder.matches(rawPassword, hashPassword);
		} catch (Exception e) {
			String msgError = "Erro ao comparar senhas.";
			LOGGER.error(msgError);
			return false;
		}
	}
}
