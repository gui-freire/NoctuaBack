package noctua.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import noctua.entity.UserEntity;

public class UserDTO {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("firebaseId")
	private String firebaseId;
	
	@JsonProperty("resp")
	private boolean resp;
	
	@JsonProperty("nameResp")
	private String nomeResp;
	
	@JsonProperty("surnameResp")
	private String surnameResp;
	
	@JsonProperty("emailResp")
	private String emailResp;
	
	@JsonProperty("vital")
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

	public String getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
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

	public Vital getVital() {
		return vital;
	}

	public void setVital(Vital vital) {
		this.vital = vital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//	@JsonProperty("responsible")
//    private void unpackNested(Map<String,Object> brand) {
//        responsible.setName((String)brand.get("name"));
//        responsible.setSurname((String)brand.get("surname"));
//        responsible.setEmail((String)brand.get("surname"));
//    }

	
}
