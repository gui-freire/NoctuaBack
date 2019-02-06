package br.com.noctua.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.noctua.service.PasswordService;

public class PasswordServiceImpl implements PasswordService {

	private String cripted = new String();

	private Logger LOG = LoggerFactory.getLogger(PasswordServiceImpl.class);
	
	@Override
	public String saltPassword(String password) {
		if (password.isEmpty() || password == null || password.equals("")) {
			LOG.info("Senha vazia");
			return null;
		}
		
		try {
			LOG.info("Iniciando criptografia");
			cripted = BCrypt.hashpw(password, BCrypt.gensalt());
			return cripted;
		} catch (Exception e) {
			LOG.info("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}
}
