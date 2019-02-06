package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.domain.Vital;

/**
 * Entity implementation class for Entity: VitalEntity
 *
 */
@Entity
@Table(name="VITAL")
public class VitalEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vital")
	private long id;

	@Column(name="heartbeat")
	private String heartbeat;

	@Column(name="pression")
	private String pression;

	@Column(name="oxigenation")
	private String oxig;
	
	@Column(name="id_user")
	private int idUsuario;
	
	@Column(name="day")
	private int day;
	
	@Column(name="week")
	private int week;
	
	@Column(name="month")
	private int month;
	
	@Column(name="year")
	private int year;
	
	public VitalEntity() {
		super();
	}
	
	public VitalEntity(Vital vital) {
		this.heartbeat = vital.getHeartbeat();
		this.pression = vital.getPression();
		this.oxig = vital.getOxig();
		this.idUsuario = vital.getIdUsuario();
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getId() {
		return id;
	}
	
	
   
}
