package noctua.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="RESPONSAVEL")
public class ResponsibleDTO {

	@Id
	@Column(name="ID_RESP")
	private long id;

	@Column(name="name")
	@JsonProperty("name")
	private String name;

	@Column(name="surname")
	@JsonProperty("surname")
	private String surname;

	@Column(name="email")
	@JsonProperty("email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
