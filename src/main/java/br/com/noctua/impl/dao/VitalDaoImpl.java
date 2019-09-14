package br.com.noctua.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.noctua.dao.VitalDao;
import br.com.noctua.dto.Vital;
import br.com.noctua.entity.VitalEntity;

public class VitalDaoImpl implements VitalDao {

	private EntityManager em;

	private Vital dto;

	public VitalDaoImpl() {
	}

	@Override
	public VitalEntity searchLast(int id) {
		try {
			List<VitalEntity> list = this.em.createQuery("SELECT V FROM VitalEntity V WHERE V.idUsuario = " + id
					+ " ORDER BY V.day ASC, V.month DESC, V.year DESC").getResultList();
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<VitalEntity> searchDaily(int id, int day, int month) {
		try {
			return this.em
					.createQuery("SELECT V FROM VitalEntity V WHERE V.idUsuario = " + id + " AND V.day = " + day
							+ " AND V.month = " + month + " ORDER BY V.day ASC, V.month DESC, V.year DESC")
					.getResultList();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<VitalEntity> searchWeekly(int id, int week, int month) {
		try {
			return this.em
					.createQuery("SELECT V FROM VitalEntity V WHERE V.idUsuario = " + id + " AND V.week = " + week
							+ " AND V.month = " + month + " ORDER BY V.day ASC, V.month DESC, V.year DESC")
					.getResultList();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<VitalEntity> searchMonthly(int id, int month) {
		try {
			return this.em.createQuery("SELECT V FROM VitalEntity V WHERE V.idUsuario = " + id + " AND V.month = "
					+ month + " ORDER BY V.day ASC, V.month DESC, V.year DESC").getResultList();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
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
