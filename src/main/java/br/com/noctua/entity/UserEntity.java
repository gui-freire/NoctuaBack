package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;

@Entity
@Table(name="USUARIO_NOVO")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2328410092665646738L;

	@Id
	@Column(name="id_user")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pass")
	private String password;
	
	@Column(name="firebaseId")
	private String firebaseId;
	
	@Column(name="resp")
	private boolean resp;
	
	@Column(name="nameResp")
	private String nomeResp;
	
	@Column(name="surnameResp")
	private String surnameResp;
	
	@Column(name="emailResp")
	private String emailResp;
	
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(UserDTO user) {
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firebaseId = user.getFirebaseId();
		this.resp = user.isResp();
		this.nomeResp = user.getNomeResp();
		this.surnameResp = user.getSurnameResp();
		this.emailResp = user.getEmailResp();
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

	public String getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}

	public boolean isResp() {
		return resp;
	}

	public void setResp(boolean resp) {
		this.resp = resp;
	}

	public int getId() {
		return id;
	}

	public String getNomeResp() {
		return nomeResp;
	}

	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

	public String getSurnameResp() {
		return surnameResp;
	}

	public void setSurnameResp(String surnameResp) {
		this.surnameResp = surnameResp;
	}

	public String getEmailResp() {
		return emailResp;
	}

	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
	}
	
}
