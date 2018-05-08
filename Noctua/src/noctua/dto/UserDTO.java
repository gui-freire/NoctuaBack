package noctua.dto;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="USUARIO")
public class UserDTO {

	@Id
	@Column(name="id_user")
	private long id;
	
	@JsonProperty("name")
	@Column(name="name")
	private String name;
	
	@Column(name="id_resp")
	private long id_resp;
	
	@JsonProperty("surname")
	@Column(name="surname")
	private String surname;
	
	@JsonProperty("email")
	@Column(name="email")
	private String email;
	
	@JsonProperty("password")
	@Column(name="password")
	private String password;
	
	@JsonProperty("firebaseId")
	@Column(name="firebaseId")
	private long firebaseId;
	
	@Column(name="salt")
	private String salt;
	
	@JsonProperty("resp")
	private boolean resp;
	
//	@JsonProperty("responsible")
//	@Nullable
//	private ResponsibleDTO dto;
	
//	private Vital vital;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isResp() {
		return resp;
	}

	public void setResp(boolean resp) {
		this.resp = resp;
	}

	public long getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(long firebaseId) {
		this.firebaseId = firebaseId;
	}

//	public ResponsibleDTO getDto() {
//		return dto;
//	}
//
//	public void setDto(ResponsibleDTO dto) {
//		this.dto = dto;
//	}

//	public Vital getVital() {
//		return vital;
//	}
//
//	public void setVital(Vital vital) {
//		this.vital = vital;
//	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
