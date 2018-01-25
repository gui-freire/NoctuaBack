package Noctua.impl.service;

import java.util.logging.Logger;

import Noctua.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {
	
	private Logger LOG;

	public int sendDiary(String email, String diary, String feel) {
		if(email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email vazio");
			return 400;
		}
		
		try {
			//TODO: inserção no banco
			return 200;
		} catch(Exception e) {
			LOG.info("Algo deu errado: " + e.getMessage());
			return 500;
		}
	}

}
