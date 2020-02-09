package br.com.noctua.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.UserDTO;
import br.com.noctua.service.UserService;

@RestController
@RequestMapping("/usuario")
public class UserApi {

	@Autowired
	private UserService service;

	private final Logger LOG = LoggerFactory.getLogger(UserApi.class);

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> searchUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, @RequestParam(value = "firebase") String firebase) {
		LOG.info(String.format("Buscando usuário %s", email));
		UserDTO dto = new UserDTO();
		try {
			if (email.isBlank() || password.isBlank()) {
				String msgError = "Campo informado vazio.";
				LOG.error(msgError);
				return new ResponseEntity<UserDTO>(dto, HttpStatus.BAD_REQUEST);
			}
			dto = service.searchUser(email, password, firebase);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {
			String msgError = "Ocorreu um erro durante a busca do usuário.";
			LOG.error(msgError, e);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody UserDTO dto) {
		LOG.debug(String.format("Criando usuário", dto.toString()));
		try {
			service.createUser(dto);
			return new ResponseEntity<String>("Usuário criado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Algo deu errado! " + e.getMessage());
			return new ResponseEntity<String>("Erro ao criar usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> changeUser(@RequestBody UserDTO user) {
		LOG.debug(String.format("Alterando usuário %s", user.getEmail()));
		try {
			if (user.getEmail().isEmpty() || user.getEmail().equals("") || user.getEmail() == null) {
				String msgError = "Email de usuário vazio";
				LOG.info(msgError);
				return new ResponseEntity<String>(msgError, HttpStatus.BAD_REQUEST);
			}

			String msg = "Usuário alterado com sucesso.";
			service.changeUser(user);
			LOG.debug(msg);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			String msgError = "Ocorreu um erro durante a busca do usuário.";
			LOG.error(msgError, e);
			return new ResponseEntity<String>(msgError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
