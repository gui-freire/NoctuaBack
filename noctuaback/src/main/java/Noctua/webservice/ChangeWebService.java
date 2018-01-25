package Noctua.webservice;

import Noctua.dto.ResponsibleDTO;
import Noctua.dto.UserDTO;
import Noctua.service.ChangeService;

public class ChangeWebService {
	
	private ChangeService service;

	public int changeUser(UserDTO user) {
		int ret;
		ret = service.changeUser(user);
		return ret;
	}
	
	public int changeResponsible(ResponsibleDTO responsible) {
		int ret;
		ret = service.changeResponsible(responsible);
		return ret;
	}
}
