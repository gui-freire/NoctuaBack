package br.com.noctua.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;
import br.com.noctua.impl.service.ChangeServiceImpl;
import br.com.noctua.service.ChangeService;

@RestController
@RequestMapping("/mudar")
public class ChangeApi {

	private ChangeService service = new ChangeServiceImpl();
	
	private Logger LOG = LoggerFactory.getLogger(ChangeApi.class);

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, name = "/mudarUsuario")
	public ResponseEntity<String> changeUser(@RequestBody UserDTO user) {
		if (user == null) {
			String msgError = "Usuário vazio";
			LOG.info("Usuário vazio");
			return "{\"key\": 400}";
		}

		if (user.getEmail().isEmpty() || user.getEmail().equals("") || user.getEmail() == null) {
			LOG.info("Email de usuário vazio");
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
