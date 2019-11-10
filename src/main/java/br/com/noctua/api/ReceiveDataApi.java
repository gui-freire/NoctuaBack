package br.com.noctua.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.Vital;
import br.com.noctua.service.VitalService;

@RestController
@RequestMapping("/receber")
public class ReceiveDataApi {

	@Autowired
	private VitalService service;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vital> receive(Vital vital) {
		Vital dto = service.receiveData(vital);
		
		if(dto == null) {
			return new ResponseEntity<Vital>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (dto.getIdUsuario() == 0) {
			return new ResponseEntity<Vital>(dto, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Vital>(dto, HttpStatus.OK);
		}
	}
}
