package br.com.noctua.impl.service;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

import br.com.noctua.dao.ResponsibleDao;
import br.com.noctua.dao.UserDao;
import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;
import br.com.noctua.entity.ResponsibleEntity;
import br.com.noctua.entity.UserEntity;
import br.com.noctua.impl.dao.ResponsibleDaoImpl;
import br.com.noctua.impl.dao.UserDaoImpl;
import br.com.noctua.service.ChangeService;

public class ChangeServiceImpl implements ChangeService {

	private Logger LOG;
	
	private UserDao userDao = new UserDaoImpl();
	
	private ResponsibleDao responsibleDao = new ResponsibleDaoImpl();
	
	public ChangeServiceImpl() {
		Configuration configure = new Configuration();
		configure.configure();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Noctua");
		EntityManager em = factory.createEntityManager();
		userDao.setEntityManager(em);
		responsibleDao.setEntityManager(em);
	}

	@Override
	public void changeUser(UserDTO dto) {
		if (dto == null) {
			LOG.info("Usu�rio vazio");
		}

		try {
			LOG.info("Alterando usu�rio");
			UserEntity user = new UserEntity(dto);
			userDao.updateUser(user);
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
			ResponsibleEntity responsible = new ResponsibleEntity(dto);
			responsibleDao.createResponsible(responsible);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usu�rio: " + e.getMessage());
		}
	}

}
