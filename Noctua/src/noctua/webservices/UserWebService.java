package noctua.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import noctua.dto.UserDTO;
import noctua.impl.service.UserServiceImpl;
import noctua.service.UserService;

@Path("/usuario")
public class UserWebService {

	private UserService userService = new UserServiceImpl();
	
	private Logger LOG = LoggerFactory.logger(UserWebService.class);

	@POST
	@Path("/buscarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserDTO searchUser(UserDTO user) {
		UserDTO dto = new UserDTO();
		dto = userService.searchUser(user.getEmail(), user.getPassword(), user.getFirebaseId());
		return dto;
	}
	
	@POST
	@Path("/criarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createUser(UserDTO dto) {
		try {
			userService.createUser(dto);
			return "{\"key\": 200}";
		} catch (Exception e) {
			LOG.info("Algo deu errado! " + e.getMessage());
			return "{\"key\": 400}";
		}
	}
	
}
