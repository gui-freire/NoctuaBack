package Noctua.webservice;

import Noctua.dto.ResponsibleDTO;
import Noctua.dto.UserDTO;
import Noctua.service.ChangeService;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.beans.ConstructorProperties;
import java.util.logging.Logger;

@WebService
public class ChangeWebService {
	
	private ChangeService service;
	private Logger LOG;

	@WebMethod
	public int changeUser(UserDTO user) {
		if(user == null) {
			LOG.info("Usuário vazio");
			return 0;
		}
		
		if(user.getEmail().isEmpty() || user.getEmail().equals("") 
				|| user.getEmail() == null) {
			LOG.info("Email vazio");
			return 0;
		}
		
		int ret;
		ret = service.changeUser(user);
		return ret;
	}
	
	@WebMethod
	public int changeResponsible(ResponsibleDTO responsible) {
		if(responsible == null) {
			LOG.info("Responsável vazio");
		}
		int ret;
		ret = service.changeResponsible(responsible);
		return ret;
	}
}
