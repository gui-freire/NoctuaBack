package noctua.impl.dao;

import java.sql.Date;
import java.text.DateFormat;

import javax.persistence.EntityManager;

import noctua.dao.DiaryDao;
import noctua.entity.Diary;

public class DiaryDaoImpl implements DiaryDao {

	private EntityManager em;
	
	private Diary diaryEntity = new Diary();
	
	public DiaryDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void sendDiary(String email, String diary, String feel, Date date) {
		diaryEntity.setData(date);
		diaryEntity.setDiary(diary);
		diaryEntity.setFeeling(feel);
		
		em.getTransaction().begin();
		em.persist(diaryEntity);
		em.getTransaction().commit();
	}

	@Override
	public Diary searchDiary(String email, int day, int month) {
		// TODO Auto-generated method stub
		return null;
	}

}
