package Noctua.service;

import java.util.List;

import Noctua.dto.Vital;

public interface VitalService {

	public Vital searchLast(String email);
	
	public List<Vital> searchDaily(String email, int day, int month);
	
	public List<Vital> searchWeekly(String email, int week, int month);
	
	public List<Vital> searchMonthly(String email, int month);
}
