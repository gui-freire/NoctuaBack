package Noctua.service;

import Noctua.dto.ResponsibleDTO;
import Noctua.dto.UserDTO;

public interface ChangeService {

	public int changeUser(UserDTO dto);
	
	public int changeResponsible(ResponsibleDTO dto);
}
