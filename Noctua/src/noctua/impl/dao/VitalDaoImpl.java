package noctua.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dao.VitalDao;
import noctua.dto.Vital;
import noctua.entity.VitalEntity;

public class VitalDaoImpl implements VitalDao {
	
	private EntityManager em;
	
	private Vital dto;

	public VitalDaoImpl() {
	}
	
	@Override
	public VitalEntity searchLast(int id) {
		List<VitalEntity> list = this.em.createQuery("SELECT V FROM VITAL WHERE V.ID = " + id + " ORDER BY V.DIA AND V.MONTH AND V.YEAR").getResultList();
		return list.get(0);
	}

	@Override
	public List<VitalEntity> searchDaily(int id, int day, int month) {
		return this.em.createQuery("SELECT V FROM VITAL WHERE V.ID = " + id + " AND V.DIA = " + day + 
				" AND V.MES = " + month + " ORDER BY V.DIA AND V.MONTH AND V.YEAR").getResultList();
	}

	@Override
	public List<VitalEntity> searchWeekly(int id, int week, int month) {
		return this.em.createQuery("SELECT V FROM VITAL WHERE V.ID = " + id + " AND V.SEMANA = " + week + 
				" AND V.MES = " + month + " ORDER BY V.DIA AND V.MONTH AND V.YEAR").getResultList();
	}

	@Override
	public List<VitalEntity> searchMonthly(int id, int month) {
		return this.em.createQuery("SELECT V FROM VITAL WHERE V.ID = " + id + 
				" AND V.MES = " + month + " ORDER BY V.DIA AND V.MONTH AND V.YEAR").getResultList();
	}

	@Override
	public void receiveData(VitalEntity vital) {
		em.getTransaction().begin();
		em.persist(vital);
		em.getTransaction().commit();
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
