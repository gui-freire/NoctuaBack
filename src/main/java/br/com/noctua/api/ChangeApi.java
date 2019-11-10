package br.com.noctua.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.service.ChangeService;

@RestController
@RequestMapping("/mudar")
public class ChangeApi {

	private Logger LOG = LoggerFactory.getLogger(ChangeApi.class);

	@Autowired
	private ChangeService service;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponsibleDTO> changeResponsible(ResponsibleDTO responsible) {
		ResponsibleDTO dto = new ResponsibleDTO();
		if (responsible.getEmail() == null) {
			LOG.warn("Informado responsável com e-mail inválido");
			return new ResponseEntity<ResponsibleDTO>(dto, HttpStatus.BAD_REQUEST);
		}
		dto = service.changeResponsible(responsible);
		
		if(dto == null) {
			return new ResponseEntity<ResponsibleDTO>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ResponsibleDTO>(dto, HttpStatus.OK);
		}
		
	}

}
