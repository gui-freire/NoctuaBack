package noctua.dao;

import noctua.entity.Diary;

public interface DiaryDao {

	public void sendDiary(String email, String diary, String feel, int day, int month);
	
	public Diary searchDiary(String email, int day, int month);
}
