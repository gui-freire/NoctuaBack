package noctua.impl.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import noctua.dao.DiaryDao;
import noctua.dto.Diary;

public class DiaryDaoImpl implements DiaryDao {

	private EntityManager em;
	
	private Diary dto;
	
	public DiaryDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void sendDiary(String email, String diary, String feel, Date date) {
		dto.setData(date);
		dto.setDiary(diary);
		dto.setFeeling(feel);
		
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}

	@Override
	public Diary searchDiary(String email, int day, int month) {
		// TODO Auto-generated method stub
		return null;
	}

}
