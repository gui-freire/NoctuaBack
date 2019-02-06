package br.com.noctua.domain;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.DiaryEntity;

public class Diary {

	@JsonProperty("sentimento")
	private String feeling;
	
	@JsonProperty("diario")
	private String diary;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("user")
	private int user;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}
	
	public Diary(DiaryEntity diary) {
		this.feeling = diary.getFeeling();
		this.diary = diary.getDiary();
		this.data = diary.getData();
		this.user = diary.getUser();
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

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

}
