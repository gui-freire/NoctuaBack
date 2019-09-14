package br.com.noctua.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.noctua.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@JsonInclude
public class UserDTO {
	
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String surname;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private String firebaseId;
	
	@Getter
	@Setter
	private boolean resp;
	
	@Getter
	@Setter
	private String nomeResp;
	
	@Getter
	@Setter
	private String surnameResp;
	
	@Getter
	@Setter
	private String emailResp;
	
	@Getter
	@Setter
	private Vital vital;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(UserEntity user) {
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
}
