package br.com.noctua.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noctua.dto.Diary;
import br.com.noctua.service.DiaryService;

@RestController
@RequestMapping("/diario")
public class DiaryApi {

	@Autowired
	private DiaryService service;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Diary> sendDiary(Diary diary) {
		Diary dto = new Diary();
		dto = service.sendDiary(diary);
		
		if(dto == null) {
			return new ResponseEntity<Diary>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if(dto.getUser() == 0) {
			return new ResponseEntity<Diary>(dto, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Diary>(dto, HttpStatus.OK);
		}
	}
}
