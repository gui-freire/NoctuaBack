package noctua.service;

import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;

public interface ChangeService {

	public void changeUser(UserDTO dto);

	public void changeResponsible(ResponsibleDTO dto);
}
