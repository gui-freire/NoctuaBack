package br.com.noctua.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noctua.dao.ResponsibleDao;
import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.entity.ResponsibleEntity;
import br.com.noctua.service.ChangeService;

@Service
public class ChangeServiceImpl implements ChangeService {

	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ResponsibleDao responsibleDao;
	
	@Override
	public ResponsibleDTO changeResponsible(ResponsibleDTO dto) {
		if (dto == null) {
			LOG.info("Usuário vazio");
			return null;
		}

		try {
			LOG.info("Alterando usuário");
			ResponsibleEntity responsible = new ResponsibleEntity(dto);
			responsible = responsibleDao.save(responsible);
			return new ResponsibleDTO(responsible);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
			return null;
		}
	}
}
