package noctua.dto;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

import noctua.entity.VitalEntity;

public class Vital {

	@JsonProperty("bpm")
	private String heartbeat;

	@Column(name="pression")
	private String pression;

	@JsonProperty("oxigenacao")
	private String oxig;
	
	@JsonProperty("usuario")
	private UserDTO idUsuario;
	
	@JsonProperty("data")
	private Date data;
	
	public Vital() {
		// TODO Auto-generated constructor stub
	}
	
	public Vital(VitalEntity vital) {
		this.heartbeat = vital.getHeartbeat();
		this.pression = vital.getPression();
		this.oxig = vital.getOxig();
		this.idUsuario = new UserDTO(vital.getIdUsuario());
		
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

	public UserDTO getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UserDTO idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}
