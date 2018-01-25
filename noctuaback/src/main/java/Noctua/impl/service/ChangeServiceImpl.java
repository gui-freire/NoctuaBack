package Noctua.impl.service;

import java.util.logging.Logger;

import Noctua.dto.ResponsibleDTO;
import Noctua.dto.UserDTO;
import Noctua.service.ChangeService;

public class ChangeServiceImpl implements ChangeService {
	
	private Logger LOG;

	public int changeUser(UserDTO dto) {
		if(dto == null) {
			LOG.info("Usuário vazio");
			return 400;
		}
		
		try {
			LOG.info("Alterando usuário");
			//TODO: update no banco
			return 200;
		} catch(Exception e) {
			LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
			return 500;
		}
	}

	public int changeResponsible(ResponsibleDTO dto) {
		if(dto == null) {
		LOG.info("Usuário vazio");
		return 400;
	}
	
	try {
		LOG.info("Alterando usuário");
		//TODO: update no banco
		return 200;
	} catch(Exception e) {
		LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
		return 500;
	}
	}

}
