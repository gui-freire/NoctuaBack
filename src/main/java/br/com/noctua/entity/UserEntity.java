package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USUARIO_NOVO")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2328410092665646738L;

	@Getter
	@Setter
	@Id
	@Column(name="id_user")
	private long id;
	
	@Getter
	@Setter
	@Column(name="name")
	private String name;
	
	@Getter
	@Setter
	@Column(name="surname")
	private String surname;
	
	@Getter
	@Setter
	@Column(name="email")
	private String email;
	
	@Getter
	@Setter
	@Column(name="pass")
	private String password;
	
	@Getter
	@Setter
	@Column(name="firebaseId")
	private String firebaseId;
	
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
	}
}
