package noctua.impl.service;

import java.util.logging.Logger;

import noctua.dto.UserDTO;
import noctua.service.PasswordService;
import noctua.service.UserService;

public class UserServiceImpl implements UserService {

private Logger LOG;
	
	private PasswordService passwordService;

	@Override
	public UserDTO searchUser(String email, String password, String firebase) {
		if(email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email está vazio");
			return null;
		} else {
			try {
				UserDTO dto = new UserDTO();
				
				String userPassword;
				
				String cryptedPassword;
				
				String salt;
				
				//TODO: fazer busca em banco de dados
				//buscar apenas pelo e-mail
				
				salt = dto.getSalt();
				
				userPassword = dto.getPassword();
				
				cryptedPassword = passwordService.checkPassword(password, salt);
				
				if(userPassword.equals(cryptedPassword)) { //Verifica se a senha informada após a criptografia bate com a senha no banco
					return dto;
				} else {
					dto = new UserDTO();
					dto.setName("incorreto");
					return dto;
				}
			} catch(Exception e) {
				LOG.info("Algo deu errado ao consultar usuário: " + e.getMessage());
				return null;
			}
		}
	}

	@Override
	public int createUser(UserDTO user) {
		if(user == null) {
			LOG.info("Usuário está vazio");
			return 400;
		} else {
			try {
				String criptedPassword;
				String salt;
				int pos;
				
				criptedPassword = passwordService.saltPassword(user.getPassword());
				pos = criptedPassword.indexOf("|"); //Pega posição de onde a senha acaba
				salt = criptedPassword.substring(pos);
				criptedPassword = criptedPassword.substring(0, pos);
				
				user.setPassword(criptedPassword);
				//TODO: inserir cliente em banco de dados
				return 200;
			} catch(Exception e) {
				LOG.info("Algo deu errado ao criar cliente: " + e.getMessage());
				return 500;
			}
		}
	}

}
