package noctua.dao;

import javax.persistence.EntityManager;

import noctua.dto.ResponsibleDTO;
import noctua.entity.ResponsibleEntity;

public interface ResponsibleDao {
	
	public void createResponsible(ResponsibleEntity resp);
	
	public ResponsibleDTO searchResponsible(String email);
	
	public void updateResponsible(ResponsibleEntity resp);
	
	public void setEntityManager(EntityManager em);

}
