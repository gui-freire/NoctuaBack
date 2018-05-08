package noctua.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="VITAL")
public class Vital {
	
	@Id
	@Column(name="id_vital")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="heartbeat")
	@JsonProperty("bpm")
	private String heartbeat;

	@Column(name="pression")
	private String pression;

	@Column(name="oxigenation")
	@JsonProperty("oxigenacao")
	private String oxig;
	
	@JsonProperty("usuario")
	private String idUsuario;
	
	@Column(name="DATA_HORA_PROC")
	private Timestamp data;

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

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}

	
}
