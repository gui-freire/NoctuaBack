package br.com.noctua.service;

import br.com.noctua.domain.Vital;

public interface VitalService {

	public Vital searchLast(int id);

	public Vital searchDaily(int id, int day, int month);

	public Vital searchWeekly(int id, int week, int month);

	public Vital searchMonthly(int id, int month);
	
	public void receiveData(Vital vital);

}
