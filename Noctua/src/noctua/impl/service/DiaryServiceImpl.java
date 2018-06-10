package noctua.impl.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import noctua.dao.DiaryDao;
import noctua.dto.Diary;
import noctua.entity.DiaryEntity;
import noctua.impl.dao.DiaryDaoImpl;
import noctua.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {

	private Logger LOG = LoggerFactory.logger(DiaryServiceImpl.class);
	
	private DiaryDao dao = new DiaryDaoImpl();
	
	public DiaryServiceImpl() {
		Configuration configure = new Configuration();
		configure.configure();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Noctua");
		EntityManager em = factory.createEntityManager();
		dao.setEntityManager(em);
	}

	@Override
	public int sendDiary(Diary diary) {
		if (diary.getUser() == 0 || diary == null) {
			LOG.info("Email vazio");
			return 400;
		}

		try {
			DiaryEntity entity = new DiaryEntity(diary);
			dao.sendDiary(entity);
			return 200;
		} catch (Exception e) {
			LOG.info("Algo deu errado: " + e.getMessage());
			return 500;
		}
	}

}
