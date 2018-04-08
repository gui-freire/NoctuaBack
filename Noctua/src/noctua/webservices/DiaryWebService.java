package noctua.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import noctua.service.DiaryService;

@Path("/diario")
public class DiaryWebService {

	private DiaryService service;

	@POST
	@Path("/enviarDiario")
	@Consumes(MediaType.APPLICATION_JSON)
	public int sendDiary(@PathParam("email") String email, 
			@PathParam("diario") String diary,
			@PathParam("sentimento") String feel,
			@PathParam("dia") int day,
			@PathParam("mes") int month) {
		int ret;
		ret = service.sendDiary(email, diary, feel, day, month);
		return ret;
	}
}
