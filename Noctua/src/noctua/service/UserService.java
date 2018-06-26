package noctua.service;

import noctua.dto.UserDTO;

public interface UserService {

	public UserDTO searchUser(String email, String password, String firebase);

	public void createUser(UserDTO user);

}
