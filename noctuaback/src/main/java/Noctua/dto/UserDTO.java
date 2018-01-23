package Noctua.dto;

public class UserDTO {
	
	private long id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	
	private boolean resp;
	
	private int firebaseId;
	
	private ResponsibleDTO dto;
	
	private Vital vital;

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

}
