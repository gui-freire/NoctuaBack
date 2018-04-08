package noctua.dao;

import noctua.dto.ResponsibleDTO;

public interface ResponsibleDao {
	
	public void createResponsible(ResponsibleDTO resp);
	
	public ResponsibleDTO searchResponsible(String email);
	
	public void updateResponsible(ResponsibleDTO resp, String email);

}
