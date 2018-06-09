package noctua.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class VitalRequest {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("day")
	private int day;
	
	@JsonProperty("week")
	private int week;
	
	@JsonProperty("month")
	private int mes;
	
	@JsonProperty("email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
