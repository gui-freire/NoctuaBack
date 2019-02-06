package br.com.noctua.service;

import br.com.noctua.domain.ResponsibleDTO;
import br.com.noctua.domain.UserDTO;

public interface ChangeService {

	public void changeUser(UserDTO dto);

	public void changeResponsible(ResponsibleDTO dto);
}
