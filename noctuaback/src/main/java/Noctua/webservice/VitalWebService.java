package Noctua.webservice;

import java.util.ArrayList;
import java.util.List;

import Noctua.dto.Vital;
import Noctua.service.VitalService;

public class VitalWebService {
	
	VitalService vitalService;
	
	List<Vital> vitalList = new ArrayList<Vital>();
	
	public Vital searchLast(String email) { //busca os últimos dados no banco
		Vital vital;
		vital = vitalService.searchLast(email);
		return vital;
	}
	
	public List<Vital> searchDaily(String email, int day, int month) {
		vitalList = vitalService.searchDaily(email, day, month);
		return vitalList;
	}
	
	public List<Vital> searchWeekly(String email, int week, int month) {
		vitalList = vitalService.searchWeekly(email, week, month);
		return vitalList;
	}
	
	public List<Vital> searchMonthly(String email, int month) {
		vitalList = vitalService.searchMonthly(email, month);
		return vitalList;
	}
}
