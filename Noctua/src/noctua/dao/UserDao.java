package noctua.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dto.UserDTO;
import noctua.entity.UserEntity;

public interface UserDao {
	
	public void setEntityManager(EntityManager em);
	
	public List<UserEntity> searchUser(String email);
	
	public void createUser(UserEntity user);
	
	public void updateUser(UserEntity user);	
}
