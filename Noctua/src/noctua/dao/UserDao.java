package noctua.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dto.UserDTO;
import noctua.entity.UserEntity;

public interface UserDao {
	
	public void setEntityManager(EntityManager em);
	
	public List<UserDTO> searchUser(String email, String password, String firebase);
	
	public void createUser(UserEntity user);
	
	public void updateUser(UserEntity user);	
}
