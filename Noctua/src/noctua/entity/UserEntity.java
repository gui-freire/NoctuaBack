package noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import noctua.dto.ResponsibleDTO;
import noctua.dto.UserDTO;

@Entity
@Table(name="USUARIO_NOVO")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2328410092665646738L;

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_user")
	private long id;
	
	@Column(name="nome")
	private String name;
	
	@Column(name="id_resp")
	private long id_resp;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pass")
	private String password;
	
	@Column(name="firebaseId")
	private long firebaseId;
	
	@Column(name="sal")
	private String salt;
	
	@Column(name="resp")
	private boolean resp;
	
//	@OneToOne
//	@JoinColumn(
//	    	name="RESPONSAVEL_ID", unique=true, nullable=false, updatable=false)
//	private ResponsibleDTO responsavel;
	
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(UserDTO user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firebaseId = user.getFirebaseId();
		this.salt = user.getSalt();
		this.resp = user.isResp();
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

	public boolean isResp() {
		return resp;
	}

	public void setResp(boolean resp) {
		this.resp = resp;
	}

	public long getId() {
		return id;
	}
	
//	@JsonProperty("responsible")
//	@Nullable
//	private ResponsibleDTO dto;
	
//	private Vital vital;
	
	
}
