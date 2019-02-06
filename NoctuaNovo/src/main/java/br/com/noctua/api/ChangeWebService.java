package br.com.noctua.api;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.noctua.domain.ResponsibleDTO;
import br.com.noctua.domain.UserDTO;
import br.com.noctua.service.ChangeService;
import br.com.noctua.service.impl.ChangeServiceImpl;

@Path("/mudar")
public class ChangeWebService {

	private ChangeService service;
	private Logger LOG;

	@POST
	@Path("/mudarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeUser(UserDTO user) {
		if (user == null) {
			LOG.info("Usu�rio vazio");
			return "{\"key\": 400}";
		}

		if (user.getEmail().isEmpty() || user.getEmail().equals("") || user.getEmail() == null) {
			LOG.info("Email vazio");
			return "{\"key\": 400}";
		}

		service.changeUser(user);
		return "{\"key\": 200}";
	}

	@POST
	@Path("/mudarResponsavel")
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeResponsible(ResponsibleDTO responsible) {
		if (responsible == null) {
			LOG.info("Respons�vel vazio");
		}
		int ret = 0;
		service.changeResponsible(responsible);
		return "{\"key\": 200}";
	}
	
}
