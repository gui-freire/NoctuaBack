package br.com.noctua.dao;

import javax.persistence.EntityManager;

import br.com.noctua.domain.Diary;
import br.com.noctua.entity.DiaryEntity;

public interface DiaryDao {

	public void sendDiary(DiaryEntity diary);
	
	public Diary searchDiary(DiaryEntity diary);
	
	public void setEntityManager(EntityManager em);
}
