package noctua.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import noctua.dto.Vital;
import noctua.service.VitalService;

public class VitalServiceImpl implements VitalService {

	private Logger LOG;

	private List<Vital> vitalList = new ArrayList<Vital>();

	@Override
	public Vital searchLast(String email) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			Vital vital = new Vital();
			// TODO: consulta em banco de dados
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchDaily(String email, int day, int month) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			// TODO: consulta em banco de dados
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchWeekly(String email, int week, int month) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			// TODO: consulta em banco de dados
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Vital> searchMonthly(String email, int month) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email vazio");
			return null;
		}
		try {
			// TODO: consulta em banco de dados
			return vitalList;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

}