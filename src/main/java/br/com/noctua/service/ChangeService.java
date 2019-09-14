package br.com.noctua.service;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;

public interface ChangeService {

	public void changeUser(UserDTO dto);

	public void changeResponsible(ResponsibleDTO dto);
}
