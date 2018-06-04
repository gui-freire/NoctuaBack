package noctua.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import noctua.entity.ResponsibleEntity;
import noctua.entity.UserEntity;

public class UserDTO {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("firebaseId")
	private long firebaseId;
	
	@JsonProperty("resp")
	private boolean resp;
	
	@JsonProperty("responsible")
	private ResponsibleDTO dto;
	
	@JsonProperty("vital")
	private Vital vital;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(UserEntity user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firebaseId = user.getFirebaseId();
		this.resp = user.isResp();
		this.dto = new ResponsibleDTO(user.getResponsavel());
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

}
