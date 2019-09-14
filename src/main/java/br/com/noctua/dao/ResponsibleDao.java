package br.com.noctua.dao;

import javax.persistence.EntityManager;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.entity.ResponsibleEntity;

public interface ResponsibleDao {
	
	public void createResponsible(ResponsibleEntity resp);
	
	public ResponsibleDTO searchResponsible(String email);
	
	public void updateResponsible(ResponsibleEntity resp);
	
	public void setEntityManager(EntityManager em);

}
