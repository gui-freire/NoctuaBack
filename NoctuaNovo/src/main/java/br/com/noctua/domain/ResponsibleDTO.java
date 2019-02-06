package br.com.noctua.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.ResponsibleEntity;


public class ResponsibleDTO {

	@JsonProperty("name")
	private String name;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("email")
	private String email;
	
	public ResponsibleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponsibleDTO(ResponsibleEntity responsible) {
		this.name = responsible.getName();
		this.surname = responsible.getSurname();
		this.email = responsible.getEmail();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
