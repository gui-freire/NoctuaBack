package noctua.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

import noctua.dao.UserDao;
import noctua.dao.VitalDao;
import noctua.dto.Vital;
import noctua.entity.UserEntity;
import noctua.entity.VitalEntity;
import noctua.impl.dao.UserDaoImpl;
import noctua.impl.dao.VitalDaoImpl;
import noctua.service.VitalService;

public class VitalServiceImpl implements VitalService {

	private Logger LOG;

	private List<Vital> vitalList = new ArrayList<Vital>();
	
	private VitalDao dao = new VitalDaoImpl();
	
	private UserDao userDao = new UserDaoImpl();
	
	public VitalServiceImpl() {
		Configuration configure = new Configuration();
		configure.configure();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Noctua");
		EntityManager em = factory.createEntityManager();
		dao.setEntityManager(em);
		userDao.setEntityManager(em);
	}

	@Override
	public Vital searchLast(String email) {
		if (email.isEmpty() || email == null) {
			LOG.info("Usuário vazio");
			return null;
		}
		try {
			UserEntity user = userDao.searchUser(email).get(0);
			VitalEntity entity = dao.searchLast(user.getId());
			Vital vital = new Vital(entity);
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchDaily(String email, int day, int month) {
		if (email.isEmpty() || email == null) {
			LOG.info("Usuário vazio");
			return null;
		}
		try {
			UserEntity user = userDao.searchUser(email).get(0);
			List<VitalEntity> list = dao.searchDaily(user.getId(), day, month);
			for(int i = 0; i < list.size(); i++) {
				vitalList.add(new Vital(list.get(i)));
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchWeekly(String email, int week, int month) {
		if (email == null || email.isEmpty()) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			UserEntity user = userDao.searchUser(email).get(0);
			List<VitalEntity> list = dao.searchWeekly(user.getId(), week, month);
			for(int i = 0; i < list.size(); i++) {
				vitalList.add(new Vital(list.get(i)));
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchMonthly(String email, int month) {
		if (email.isEmpty() || email == null) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			UserEntity user = userDao.searchUser(email).get(0);
			List<VitalEntity> list = dao.searchMonthly(user.getId(), month);
			for(int i = 0; i < list.size(); i++) {
				vitalList.add(new Vital(list.get(i)));
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void receiveData(Vital vital) {
		if(vital == null) {
			LOG.info("Dados enviados vazios");
		}
		try {
			VitalEntity entity = new VitalEntity(vital);
			dao.receiveData(entity);
		} catch(Exception e) {
			LOG.info("Algo deu errado ao enviar dados para a base. " + e.getMessage());
		}
	}

}
