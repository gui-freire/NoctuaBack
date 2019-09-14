package br.com.noctua.service;

import br.com.noctua.dto.UserDTO;

public interface UserService {

	public UserDTO searchUser(String email, String password, String firebase);

	public void createUser(UserDTO user);

}
