package noctua.impl.service;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

import noctua.dao.ResponsibleDao;
import noctua.dao.UserDao;
import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;
import noctua.entity.ResponsibleEntity;
import noctua.entity.UserEntity;
import noctua.impl.dao.ResponsibleDaoImpl;
import noctua.impl.dao.UserDaoImpl;
import noctua.service.ChangeService;

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
			LOG.info("Usuário vazio");
		}

		try {
			LOG.info("Alterando usuário");
			UserEntity user = new UserEntity(dto);
			userDao.updateUser(user);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
		}
	}

	@Override
	public void changeResponsible(ResponsibleDTO dto) {
		if (dto == null) {
			LOG.info("Usuário vazio");
		}

		try {
			LOG.info("Alterando usuário");
			ResponsibleEntity responsible = new ResponsibleEntity(dto);
			responsibleDao.createResponsible(responsible);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
		}
	}

}
