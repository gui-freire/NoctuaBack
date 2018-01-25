package Noctua.webservice;

import Noctua.service.DiaryService;

public class DiaryWebService {

	private DiaryService service;
	
	public int sendDiary(String email, String diary, String feel) {
		int ret;
		ret = service.sendDiary(email, diary, feel);
		return ret;
	}
	
}
