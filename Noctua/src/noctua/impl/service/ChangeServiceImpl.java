package noctua.impl.service;

import java.util.logging.Logger;

import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;
import noctua.service.ChangeService;

public class ChangeServiceImpl implements ChangeService {

	private Logger LOG;

	@Override
	public void changeUser(UserDTO dto) {
		if (dto == null) {
			LOG.info("Usu�rio vazio");
		}

		try {
			LOG.info("Alterando usu�rio");
			// TODO: update no banco
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usu�rio: " + e.getMessage());
		}
	}

	@Override
	public void changeResponsible(ResponsibleDTO dto) {
		if (dto == null) {
			LOG.info("Usu�rio vazio");
		}

		try {
			LOG.info("Alterando usu�rio");
			// TODO: update no banco
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usu�rio: " + e.getMessage());
		}
	}

}
