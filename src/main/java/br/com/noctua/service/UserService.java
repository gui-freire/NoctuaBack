package br.com.noctua.service;

import br.com.noctua.dto.UserDTO;
import br.com.noctua.exceptions.IncorrectPasswordException;

public interface UserService {
	
	public UserDTO changeUser(UserDTO dto);

	public UserDTO searchUser(String email, String password, String firebase) throws IncorrectPasswordException;

	public UserDTO createUser(UserDTO user);

}
