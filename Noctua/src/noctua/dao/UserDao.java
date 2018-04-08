package noctua.dao;

import noctua.dto.UserDTO;

public interface UserDao {

	public UserDTO searchUser(String email, String password, String firebase);
	
	public void createUser(UserDTO user);
	
	public void updateUser(UserDTO user);	
}
