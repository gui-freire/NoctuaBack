package br.com.noctua.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.VitalEntity;

public class Vital {

	@JsonProperty("heartbeat")
	private String heartbeat;

	@Column(name="pression")
	private String pression;

	@JsonProperty("oxig")
	private String oxig;
	
	@JsonProperty("idUsuario")
	private int idUsuario;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("vital")
	private List<Vital> vital;
	
	public Vital() {
		// TODO Auto-generated constructor stub
	}
	
	public Vital(VitalEntity vital) {
		this.heartbeat = vital.getHeartbeat();
		this.pression = vital.getPression();
		this.oxig = vital.getOxig();
		this.idUsuario = vital.getIdUsuario();
		
		Calendar cal = Calendar.getInstance();
		cal.set(vital.getYear(), vital.getMonth(), vital.getDay());
		this.data = cal.getTime();
	}

	public String getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}

	public String getPression() {
		return pression;
	}

	public void setPression(String pression) {
		this.pression = pression;
	}

	public String getOxig() {
		return oxig;
	}

	public void setOxig(String oxig) {
		this.oxig = oxig;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Vital> getVital() {
		return vital;
	}

	public void setVital(List<Vital> vital) {
		this.vital = vital;
	}

	
}
