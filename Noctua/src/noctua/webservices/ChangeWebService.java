package noctua.webservices;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;
import noctua.impl.service.ChangeServiceImpl;
import noctua.service.ChangeService;

@Path("/mudar")
public class ChangeWebService {

	private ChangeService service = new ChangeServiceImpl();
	private Logger LOG;

	@POST
	@Path("/mudarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeUser(UserDTO user) {
		if (user == null) {
			LOG.info("Usuário vazio");
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
			LOG.info("Responsável vazio");
		}
		int ret = 0;
		service.changeResponsible(responsible);
		return "{\"key\": 200}";
	}
	
}
