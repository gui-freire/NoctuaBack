package noctua.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dto.UserDTO;

public interface UserDao {
	
	public void setEntityManager(EntityManager em);
	
	public List<UserDTO> searchUser(String email, String password, String firebase);
	
	public void createUser(UserDTO user);
	
	public void updateUser(UserDTO user);	
}
