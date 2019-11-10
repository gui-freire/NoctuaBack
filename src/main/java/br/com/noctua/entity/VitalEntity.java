package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.dto.Vital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity implementation class for Entity: VitalEntity
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="VITAL")
public class VitalEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@Column(name="id_vital")
	private long id;

	@Getter
	@Setter
	@Column(name="heartbeat")
	private String heartbeat;

	@Getter
	@Setter
	@Column(name="pression")
	private String pression;

	@Getter
	@Setter
	@Column(name="oxigenation")
	private String oxig;
	
	@Getter
	@Setter
	@Column(name="id_user")
	private long idUsuario;
	
	@Getter
	@Setter
	@Column(name="day")
	private int day;
	
	@Getter
	@Setter
	@Column(name="week")
	private int week;
	
	@Getter
	@Setter
	@Column(name="month")
	private int month;
	
	@Getter
	@Setter
	@Column(name="year")
	private int year;
	
	public VitalEntity(Vital vital) {
		this.heartbeat = vital.getHeartbeat();
		this.pression = vital.getPression();
		this.oxig = vital.getOxig();
		this.idUsuario = vital.getIdUsuario();
	}
}
