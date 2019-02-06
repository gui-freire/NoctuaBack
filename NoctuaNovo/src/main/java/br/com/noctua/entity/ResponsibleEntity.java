package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.domain.ResponsibleDTO;

/**
 * Entity implementation class for Entity: ResponsibleEntity
 *
 */
@Entity
@Table(name="RESPONSAVEL")
public class ResponsibleEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_RESP")
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

	@Column(name="email")
	private String email;

	public ResponsibleEntity() {
		super();
	}
	
	public ResponsibleEntity(ResponsibleDTO responsible) {
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

	public long getId() {
		return id;
	}
	
}
