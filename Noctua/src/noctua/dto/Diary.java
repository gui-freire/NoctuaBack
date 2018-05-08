package noctua.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="DIARIO")
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="feeling")
	@JsonProperty("sentimento")
	private String feeling;
	
	@Column(name="diary")
	@JsonProperty("diario")
	private String diary;
	
	@Column(name="data_dia_mes")
	@JsonProperty("data")
	private Date data;

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

	public long getId() {
		return id;
	}
	
	

}
