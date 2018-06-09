package noctua.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import noctua.dto.Vital;
import noctua.dto.VitalRequest;
import noctua.impl.service.VitalServiceImpl;
import noctua.service.VitalService;

@Path("/dadosVitais")
public class VitalWebService {

	VitalService vitalService = new VitalServiceImpl();

	List<Vital> vitalList = new ArrayList<Vital>();

	@POST
	@Path("/ultimo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchLast(VitalRequest request) {
		Vital vital = new Vital();
		vital = vitalService.searchLast(request.getId());
		return vital;
	}

	@POST
	@Path("/diario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchDaily(VitalRequest request) {
		vitalList = vitalService.searchDaily(request.getId(), request.getDay(), request.getMes());
		return vitalList;
	}

	@POST
	@Path("/semanal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchWeekly(VitalRequest request) {
		vitalList = vitalService.searchWeekly(request.getId(), request.getWeek(), request.getMes());
		return vitalList;
	}

	@POST
	@Path("/mensal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchMonthly(VitalRequest request) {
		vitalList = vitalService.searchMonthly(request.getId(), request.getMes());
		return vitalList;
	}

}
