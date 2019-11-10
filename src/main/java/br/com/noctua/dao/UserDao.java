package br.com.noctua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noctua.dto.UserDTO;
import br.com.noctua.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByEmail(String email);
	
	public List<UserEntity> findAll();
	
	public UserEntity save(UserEntity user);
}
