package br.com.noctua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noctua.entity.ResponsibleEntity;

public interface ResponsibleDao extends JpaRepository<ResponsibleEntity, Long>{
	
	public ResponsibleEntity save(ResponsibleEntity responsible);
	
	public ResponsibleEntity findByEmail(String email);
	
	public List<ResponsibleEntity> findAll();
}
