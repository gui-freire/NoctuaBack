package br.com.noctua.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.dto.Diary;

/**
 * Entity implementation class for Entity: DiaryEntity
 *
 */
@Entity
@Table(name="DIARIO")
public class DiaryEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="feeling")
	private String feeling;
	
	@Column(name="diary")
	private String diary;
	
	@Column(name="data_dia_mes")
	private Date data;
	
	@Column(name="id_user")
	private int user;

	public DiaryEntity() {
		super();
	}
	
	public DiaryEntity(Diary diary) {
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

	public long getId() {
		return id;
	}
	
	
   
}
