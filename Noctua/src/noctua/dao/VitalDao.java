package noctua.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dto.Vital;
import noctua.entity.VitalEntity;

public interface VitalDao {

	public VitalEntity searchLast(int id);
	
	public List<VitalEntity> searchDaily(int id, int day, int month);
	
	public List<VitalEntity> searchWeekly(int id, int week, int month);
	
	public List<VitalEntity> searchMonthly(int id, int month);
	
	public void receiveData(VitalEntity vital);
	
	public void setEntityManager(EntityManager em);
}
