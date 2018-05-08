package noctua.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dao.VitalDao;
import noctua.dto.Vital;

public class VitalDaoImpl implements VitalDao {
	
	private EntityManager em;
	
	private Vital dto;

	public VitalDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Vital searchLast(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vital> searchDaily(String email, int day, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vital> searchWeekly(String email, int week, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vital> searchMonthly(String email, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receiveData(Vital vital) {
		em.getTransaction().begin();
		em.persist(vital);
		em.getTransaction().commit();
	}

}
