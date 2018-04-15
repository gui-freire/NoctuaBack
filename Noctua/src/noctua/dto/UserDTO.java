package noctua.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UserDTO {

	@Id
	@Column(name="id_user")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="id_resp")
	private long id_resp;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firebaseId")
	private long firebaseId;
	
	@Column(name="salt")
	private String salt;

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

	public int getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(int firebaseId) {
		this.firebaseId = firebaseId;
	}

	public ResponsibleDTO getDto() {
		return dto;
	}

	public void setDto(ResponsibleDTO dto) {
		this.dto = dto;
	}

	public Vital getVital() {
		return vital;
	}

	public void setVital(Vital vital) {
		this.vital = vital;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
