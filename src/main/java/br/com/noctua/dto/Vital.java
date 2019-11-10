package br.com.noctua.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.VitalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Vital {

	@Getter
	@Setter
	@JsonProperty("heartbeat")
	private String heartbeat;

	@Getter
	@Setter
	@Column(name="pression")
	private String pression;

	@Getter
	@Setter
	@JsonProperty("oxig")
	private String oxig;
	
	@Getter
	@Setter
	@JsonProperty("idUsuario")
	private long idUsuario;
	
	@Getter
	@Setter
	@JsonProperty("data")
	private Date data;
	
	@Getter
	@Setter
	@JsonProperty("vital")
	private List<Vital> vital;
	
	public Vital(VitalEntity vital) {
		this.heartbeat = vital.getHeartbeat();
		this.pression = vital.getPression();
		this.oxig = vital.getOxig();
		this.idUsuario = vital.getIdUsuario();
		
		Calendar cal = Calendar.getInstance();
		cal.set(vital.getYear(), vital.getMonth(), vital.getDay());
		this.data = cal.getTime();
	}
}
