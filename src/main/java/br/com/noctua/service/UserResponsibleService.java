package br.com.noctua.service;

import java.util.List;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;
import br.com.noctua.entity.UserResponsibleEntity;

public interface UserResponsibleService {

	public List<ResponsibleDTO> findResponsibles(long userId);
	
	public List<UserDTO> findUsers(long responsibleId);
	
	public UserResponsibleEntity save(long userId, long responsibleId);
}
