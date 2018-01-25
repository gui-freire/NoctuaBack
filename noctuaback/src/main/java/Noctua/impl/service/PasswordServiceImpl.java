package Noctua.impl.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.logging.Logger;

import Noctua.service.PasswordService;

public class PasswordServiceImpl implements PasswordService {

	private SecureRandom salt = new SecureRandom();

	private MessageDigest digest;

	private byte[] newPassword;
	
	private String cripted;
	
	private Logger LOG;

	public String saltPassword(String password) {
		if (password.isEmpty() || password == null || password.equals("")) {
			LOG.info("Senha vazia");
			return null;
		}

		try {
			LOG.info("Iniciando criptografia");
			digest = MessageDigest.getInstance("SHA-256");
			newPassword = digest.digest(password.getBytes());
			cripted = newPassword.toString() + salt;
			
			cripted.concat("|" + salt); //separa o salt para ser armazenado no banco de dados
			return cripted;
		} catch (Exception e) {
			LOG.info("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}

	public String checkPassword(String password, String salt) {
		if (password.isEmpty() || password == null || password.equals("")) {
			LOG.info("Senha vazia");
			return null;
		}

		if (salt.isEmpty() || salt == null || salt.equals("")) {
			LOG.info("Salt vazio");
			return null;
		}
		
		try {			
			LOG.info("Inciando criptografia");
			digest = MessageDigest.getInstance("SHA-256");
			
			password.concat(salt);
			newPassword = digest.digest(password.getBytes());
			
			return newPassword.toString();
		} catch(Exception e) {
			LOG.info("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}

}
