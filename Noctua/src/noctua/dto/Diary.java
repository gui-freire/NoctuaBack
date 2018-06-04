package noctua.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

import noctua.entity.DiaryEntity;
import noctua.entity.UserEntity;

public class Diary {

	@JsonProperty("sentimento")
	private String feeling;
	
	@JsonProperty("diario")
	private String diary;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("user")
	private UserDTO user;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}
	
	public Diary(DiaryEntity diary) {
		this.feeling = diary.getFeeling();
		this.diary = diary.getDiary();
		this.data = diary.getData();
		this.user = new UserDTO(diary.getUser());
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
