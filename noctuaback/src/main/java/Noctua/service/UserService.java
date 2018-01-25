package Noctua.service;

import Noctua.dto.UserDTO;

public interface UserService {

	public UserDTO searchUser(String email, String password, String firebase);
	
	public int createUser(UserDTO user);
	
}
