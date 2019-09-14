package br.com.noctua.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.noctua.dto.Diary;
import br.com.noctua.impl.service.DiaryServiceImpl;
import br.com.noctua.service.DiaryService;

@Path("/diario")
public class DiaryWebService {

	private DiaryService service = new DiaryServiceImpl();

	@POST
	@Path("/enviarDiario")
	@Consumes(MediaType.APPLICATION_JSON)
	public int sendDiary(Diary diary) {
		int ret = 0;
		ret = service.sendDiary(diary);
		return ret;
	}
}
