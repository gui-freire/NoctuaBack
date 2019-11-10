package br.com.noctua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noctua.entity.UserResponsibleEntity;

public interface UserResponsibleDao extends JpaRepository<UserResponsibleEntity, Long>{
	
	public List<UserResponsibleEntity> findAllByUserId(long userId);
	
	public List<UserResponsibleEntity> findAllByResponsibleId(long userId);
	
	public void saveUserResponsible(UserResponsibleEntity entity);
	
}
