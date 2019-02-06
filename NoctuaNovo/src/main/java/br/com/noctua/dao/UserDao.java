package br.com.noctua.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.noctua.entity.UserEntity;

public interface UserDao {
	
	public void setEntityManager(EntityManager em);
	
	public List<UserEntity> searchUser(String email);
	
	public void createUser(UserEntity user);
	
	public void updateUser(UserEntity user);	
}
