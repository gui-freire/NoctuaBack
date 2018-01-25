package Noctua.webservice;

import java.security.SecureRandom;

import Noctua.dto.UserDTO;
import Noctua.dto.Vital;
import Noctua.service.UserService;

public class UserWebService {
	
	private UserService userService;

	public UserDTO searchUser(String email, String password, String firebaseKey) {
		UserDTO dto = new UserDTO();
		dto = userService.searchUser(email, password, firebaseKey);
		return dto;
	}
	
	public int createUser(UserDTO dto) {
		int result;
		result = userService.createUser(dto);
		return result;
	}
	
}
