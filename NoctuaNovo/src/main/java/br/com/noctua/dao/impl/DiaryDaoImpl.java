package br.com.noctua.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.noctua.dao.DiaryDao;
import br.com.noctua.domain.Diary;
import br.com.noctua.entity.DiaryEntity;

public class DiaryDaoImpl implements DiaryDao {

	private EntityManager em;
	
	public DiaryDaoImpl() {
	}
	
	@Override
	public void sendDiary(DiaryEntity diary) {
		em.getTransaction().begin();
		em.persist(diary);
		em.getTransaction().commit();
	}

	@Override
	public Diary searchDiary(DiaryEntity diary) {
		List<Diary> list = this.em.createQuery("SELECT D FROM DIARY C WHERE D.ID = " + diary.getId()).getResultList();
		return list.get(0);
	}
	
	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
