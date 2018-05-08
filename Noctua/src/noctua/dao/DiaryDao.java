package noctua.dao;

import java.sql.Date;

import noctua.dto.Diary;

public interface DiaryDao {

	public void sendDiary(String email, String diary, String feel, Date date);
	
	public Diary searchDiary(String email, int day, int month);
}
