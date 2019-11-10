package br.com.noctua.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.Vital;
import br.com.noctua.dto.VitalRequest;
import br.com.noctua.service.VitalService;

@RestController
@RequestMapping("/dadosVitais")
public class VitalApi {

	@Autowired
	private VitalService vitalService;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vital> searchLast(VitalRequest request) {
		Vital vital = new Vital();
		vital = vitalService.searchLast(request.getId());
		
		if (vital == null) {
			return new ResponseEntity<Vital>(vital, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (vital.getIdUsuario() == 0) {
			return new ResponseEntity<Vital>(vital, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Vital>(vital, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vital> searchDaily(VitalRequest request) {
		Vital vital = vitalService.searchDaily(request.getId(), request.getDay(), request.getMes());
		if (vital == null) {
			return new ResponseEntity<Vital>(vital, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (vital.getIdUsuario() == 0) {
			return new ResponseEntity<Vital>(vital, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Vital>(vital, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vital> searchWeekly(VitalRequest request) {
		Vital vital = vitalService.searchWeekly(request.getId(), request.getWeek(), request.getMes());
		if (vital == null) {
			return new ResponseEntity<Vital>(vital, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (vital.getIdUsuario() == 0) {
			return new ResponseEntity<Vital>(vital, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Vital>(vital, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vital> searchMonthly(VitalRequest request) {
		Vital vital = vitalService.searchMonthly(request.getId(), request.getMes());
		if (vital == null) {
			return new ResponseEntity<Vital>(vital, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (vital.getIdUsuario() == 0) {
			return new ResponseEntity<Vital>(vital, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Vital>(vital, HttpStatus.OK);
		}
	}

}
