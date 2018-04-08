package noctua.webservices;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;
import noctua.service.ChangeService;

@Path("/mudar")
public class ChangeWebService {

	private ChangeService service;
	private Logger LOG;

	@GET
	@Path("/teste")
	public String testar() {
		return "olar";
	}

	@POST
	@Path("/mudarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeUser(UserDTO user) {
		if (user == null) {
			LOG.info("Usuário vazio");
			return "FUNFOU VIADO";
		}

		if (user.getEmail().isEmpty() || user.getEmail().equals("") || user.getEmail() == null) {
			LOG.info("Email vazio");
			return "FUNFOU VIADO";
		}

		String ret = "FUNFOU VIADO";
		service.changeUser(user);
		return ret;
	}

	@POST
	@Path("/mudarResponsavel")
	@Consumes(MediaType.APPLICATION_JSON)
	public int changeResponsible(ResponsibleDTO responsible) {
		if (responsible == null) {
			LOG.info("Responsável vazio");
		}
		int ret = 0;
		service.changeResponsible(responsible);
		return ret;
	}
	
}
