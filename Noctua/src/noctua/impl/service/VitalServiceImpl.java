package noctua.impl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public Vital searchLast(int id) {
		if (id == 0) {
			LOG.info("Usuário vazio");
			return null;
		}
		try {
			VitalEntity entity = dao.searchLast(id);
			Vital vital = new Vital();
			if (entity != null) {
				vital = new Vital(entity);
			}
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchDaily(int id, int day, int month) {
		if (id == 0) {
			LOG.info("Usuário vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.searchDaily(id, day, month);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vitalList.add(new Vital(list.get(i)));
				}
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchWeekly(int id, int week, int month) {
		if (id == 0) {
			LOG.info("id vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.searchWeekly(id, week, month);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vitalList.add(new Vital(list.get(i)));
				}
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchMonthly(int id, int month) {
		if (id == 0) {
			LOG.info("id vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.searchMonthly(id, month);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vitalList.add(new Vital(list.get(i)));
				}
			}
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void receiveData(Vital vital) {
		if (vital == null) {
			LOG.info("Dados enviados vazios");
		}
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			VitalEntity entity = new VitalEntity(vital);
			entity.setDay(date.getDate());
			entity.setMonth(date.getMonth());
			entity.setYear(date.getYear());

			dao.receiveData(entity);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao enviar dados para a base. " + e.getMessage());
		}
	}

}
