package br.com.noctua.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.noctua.domain.Vital;
import br.com.noctua.domain.VitalRequest;
import br.com.noctua.service.VitalService;

@Path("/dadosVitais")
public class VitalWebService {

	VitalService vitalService;

	List<Vital> vitalList = new ArrayList<Vital>();
	
	private Vital vital = new Vital();

	@POST
	@Path("/ultimo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchLast(VitalRequest request) {
		vital = new Vital();
		vital = vitalService.searchLast(request.getId());
		return vital;
	}

	@POST
	@Path("/diario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchDaily(VitalRequest request) {
		vital = vitalService.searchDaily(request.getId(), request.getDay(), request.getMes());
		return vital;
	}

	@POST
	@Path("/semanal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchWeekly(VitalRequest request) {
		vital = vitalService.searchWeekly(request.getId(), request.getWeek(), request.getMes());
		return vital;
	}

	@POST
	@Path("/mensal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchMonthly(VitalRequest request) {
		vital = vitalService.searchMonthly(request.getId(), request.getMes());
		return vital;
	}

}