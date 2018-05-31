package noctua.impl.service;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import noctua.service.PasswordService;

public class PasswordServiceImpl implements PasswordService {

	private SecureRandom salt = new SecureRandom();

	private byte[] newPassword = {};

	private String cripted = new String();

	private Logger LOG = LoggerFactory.getLogger(PasswordServiceImpl.class);
	
	private static final byte BYTES[] = new byte[20];

	@Override
	public String saltPassword(String password) {
		if (password.isEmpty() || password == null || password.equals("")) {
			LOG.info("Senha vazia");
			return null;
		}
		
		try {
			LOG.info("Iniciando criptografia");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			newPassword = digest.digest(password.getBytes());
			salt.nextBytes(BYTES);
			String saltGenerated = SecureRandom.getSeed(20).toString();
			cripted = newPassword.toString() + saltGenerated;

			cripted.concat("||").concat(saltGenerated);
			return cripted;
		} catch (Exception e) {
			LOG.info("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}

	@Override
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
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			password.concat(salt);
			newPassword = digest.digest(password.getBytes());

			return newPassword.toString();
		} catch (Exception e) {
			LOG.info("Algo deu errado na criptografia: " + e.getMessage());
			return null;
		}
	}

}
