package noctua.service;

public interface DiaryService {

	public int sendDiary(String email, String diary, String feel, int day, int month);
}
