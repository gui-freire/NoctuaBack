package br.com.noctua.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.noctua.domain.Vital;
import br.com.noctua.service.VitalService;

@Path("/receber")
public class ReceiveDataWebService {

	private VitalService service;
	
	@POST
	@Path("/dados")
	@Consumes(MediaType.APPLICATION_JSON)
	public void receive(Vital vital) {
		service.receiveData(vital);
	}
}
