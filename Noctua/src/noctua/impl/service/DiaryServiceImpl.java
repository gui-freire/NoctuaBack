package noctua.impl.service;

import java.util.logging.Logger;

import noctua.dto.Diary;
import noctua.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {

	private Logger LOG;

	@Override
	public int sendDiary(Diary diary) {
		if (diary.getId() == 0 || diary == null) {
			LOG.info("Email vazio");
			return 400;
		}

		try {
			// TODO: inserção no banco
			return 200;
		} catch (Exception e) {
			LOG.info("Algo deu errado: " + e.getMessage());
			return 500;
		}
	}

}
