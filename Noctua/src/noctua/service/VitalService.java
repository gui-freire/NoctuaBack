package noctua.service;

import java.util.List;

import noctua.dto.Vital;

public interface VitalService {

	public Vital searchLast(int id);

	public List<Vital> searchDaily(int id, int day, int month);

	public List<Vital> searchWeekly(int id, int week, int month);

	public List<Vital> searchMonthly(int id, int month);
	
	public void receiveData(Vital vital);

}
