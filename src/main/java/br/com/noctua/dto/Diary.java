package br.com.noctua.dto;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.DiaryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Diary {

	@Getter
	@Setter
	@JsonProperty("sentimento")
	private String feeling;
	
	@Getter
	@Setter
	@JsonProperty("diario")
	private String diary;
	
	@Getter
	@Setter
	@JsonProperty("data")
	private Date data;
	
	@Getter
	@Setter
	@JsonProperty("user")
	private long user;
	
	public Diary(DiaryEntity diary) {
		this.feeling = diary.getFeeling();
		this.diary = diary.getDiary();
		this.data = diary.getData();
		this.user = diary.getUser();
	}
}
