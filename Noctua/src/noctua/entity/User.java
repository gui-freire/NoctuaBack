package noctua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class User {

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

	public long getId_resp() {
		return id_resp;
	}

	public void setId_resp(long id_resp) {
		this.id_resp = id_resp;
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

	public long getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(long firebaseId) {
		this.firebaseId = firebaseId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
