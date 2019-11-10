package br.com.noctua.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noctua.dao.VitalDao;
import br.com.noctua.dto.Vital;
import br.com.noctua.entity.VitalEntity;
import br.com.noctua.service.VitalService;

@Service
public class VitalServiceImpl implements VitalService {

	private Logger LOG;

	private List<Vital> vitalList = new ArrayList<Vital>();
	
	private Vital vital = new Vital();

	@Autowired
	private VitalDao dao;

	@Override
	public Vital searchLast(int id) {
		if (id == 0) {
			LOG.info("Usu�rio vazio");
			return null;
		}
		try {
			VitalEntity entity = dao.findByIdUsuario(id);
			if (entity != null) {
				vital = new Vital(entity);
				if(vital.getHeartbeat() == null) {
					vital.setHeartbeat("-");
					vital.setOxig("-");
					vital.setPression("-");
				}
			} else {
				vital.setHeartbeat("-");
				vital.setOxig("-");
				vital.setPression("-");
			}
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Vital searchDaily(int id, int day, int month) {
		if (id == 0) {
			LOG.info("Usu�rio vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.retrieveByDay(id, day, month);
			if (list != null) {
				for (VitalEntity v: list) {
					vitalList.add(new Vital(v));
				}
				vital.setVital(vitalList);
			}
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Vital searchWeekly(int id, int week, int month) {
		if (id == 0) {
			LOG.info("id vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.retrieveByWeek(id, week, month);
			if (list != null) {
				for (VitalEntity v: list) {
					vitalList.add(new Vital(v));
				}
				vital.setVital(vitalList);
			}
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Vital searchMonthly(int id, int month) {
		if (id == 0) {
			LOG.info("id vazio");
			return null;
		}
		try {
			List<VitalEntity> list = dao.retrieveByMonth(id, month);
			if (list != null) {
				for (VitalEntity v: list) {
					vitalList.add(new Vital(v));
				}
				vital.setVital(vitalList);
			}
			return vital;
		} catch (Exception e) {
			LOG.info("Algo deu errado ao consultar dados vitais: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Vital receiveData(Vital vital) {
		if (vital == null) {
			LOG.info("Dados enviados vazios");
			return new Vital();
		}
		try {
			LocalDate date = LocalDate.now();
			VitalEntity entity = new VitalEntity(vital);
			entity.setDay(date.getDayOfMonth());
			entity.setMonth(date.getMonthValue());
			entity.setYear(date.getYear());
			entity = dao.save(entity);
			
			return new Vital(entity);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao enviar dados para a base. " + e.getMessage());
			return null;
		}
	}

}
