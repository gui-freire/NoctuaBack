package noctua.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import noctua.dto.UserDTO;
import noctua.service.UserService;

@Path("/usuario")
public class UserWebService {

	private UserService userService;

	@GET
	@Path("/buscarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO searchUser(@PathParam("email") String email,
			@PathParam("senha") String password,
			@PathParam("chave") String firebaseKey) {
		UserDTO dto = new UserDTO();
		dto = userService.searchUser(email, password, firebaseKey);
		return dto;
	}
	
	@POST
	@Path("/criarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public int createUser(UserDTO dto) {
		int result;
		result = userService.createUser(dto);
		return result;
	}
	
}
