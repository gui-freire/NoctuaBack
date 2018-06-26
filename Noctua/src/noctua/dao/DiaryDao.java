package noctua.dao;

import javax.persistence.EntityManager;

import noctua.dto.Diary;
import noctua.entity.DiaryEntity;

public interface DiaryDao {

	public void sendDiary(DiaryEntity diary);
	
	public Diary searchDiary(DiaryEntity diary);
	
	public void setEntityManager(EntityManager em);
}
