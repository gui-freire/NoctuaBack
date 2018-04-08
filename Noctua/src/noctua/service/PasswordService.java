package noctua.service;

public interface PasswordService {
	
	public String saltPassword(String password);

	public String checkPassword(String password, String salt);
}
