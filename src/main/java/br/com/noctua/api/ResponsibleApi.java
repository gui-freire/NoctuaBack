package br.com.noctua.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.ResponsibleDTO;

@RestController
@RequestMapping("/responsible")
public class ResponsibleApi {

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponsibleDTO> createResponsible(@RequestBody ResponsibleDTO responsible) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponsibleDTO> searchResponsible(@RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("firebaseId") String firebaseId) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponsibleDTO> updateResponsible(@RequestBody ResponsibleDTO responsible){
		return null;
	}

}
