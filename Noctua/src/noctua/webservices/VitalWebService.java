package noctua.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import noctua.dto.Vital;
import noctua.impl.service.VitalServiceImpl;
import noctua.service.VitalService;

@Path("/dadosVitais")
public class VitalWebService {

	VitalService vitalService = new VitalServiceImpl();

	List<Vital> vitalList = new ArrayList<Vital>();

	@GET
	@Path("/ultimo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vital searchLast(@PathParam("email") String email) {
		Vital vital;
		vital = vitalService.searchLast(email);
		return vital;
	}

	@GET
	@Path("/diario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchDaily(@PathParam("email") String email,
			@PathParam("dia") int day,
			@PathParam("mes") int month) {
		vitalList = vitalService.searchDaily(email, day, month);
		return vitalList;
	}

	@GET
	@Path("/semanal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchWeekly(@PathParam("email") String email,
			@PathParam("semana") int week, 
			@PathParam("mes") int month) {
		vitalList = vitalService.searchWeekly(email, week, month);
		return vitalList;
	}

	@GET
	@Path("/mensal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vital> searchMonthly(@PathParam("email") String email, 
			@PathParam("mes") int month) {
		vitalList = vitalService.searchMonthly(email, month);
		return vitalList;
	}

}
