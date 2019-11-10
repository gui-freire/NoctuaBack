package br.com.noctua.service.impl;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noctua.dao.DiaryDao;
import br.com.noctua.dto.Diary;
import br.com.noctua.entity.DiaryEntity;
import br.com.noctua.service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {

	private Logger LOG = LoggerFactory.logger(DiaryServiceImpl.class);
	
	@Autowired
	private DiaryDao dao;
	
	@Override
	public Diary sendDiary(Diary diary) {
		if (diary.getUser() == 0 || diary == null) {
			LOG.info("Email vazio");
			return new Diary();
		}

		try {
			DiaryEntity entity = new DiaryEntity(diary);
			dao.save(entity);
			return new Diary(entity);
		} catch (Exception e) {
			LOG.info("Algo deu errado: " + e.getMessage());
			return null;
		}
	}

}
