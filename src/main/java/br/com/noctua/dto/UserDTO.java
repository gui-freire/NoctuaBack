package br.com.noctua.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.noctua.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class UserDTO {
	
	@Getter
	@Setter
	private long id;

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
	private List<ResponsibleDTO> responsible;
	
	public UserDTO(UserEntity user) {
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firebaseId = user.getFirebaseId();
	}
}
