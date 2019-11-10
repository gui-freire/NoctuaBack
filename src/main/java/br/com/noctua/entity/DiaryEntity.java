package br.com.noctua.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.dto.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity implementation class for Entity: DiaryEntity
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DIARIO")
public class DiaryEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@Column(name="id")
	private long id;
	
	@Getter
	@Setter
	@Column(name="feeling")
	private String feeling;
	
	@Getter
	@Setter
	@Column(name="diary")
	private String diary;
	
	@Getter
	@Setter
	@Column(name="data_dia_mes")
	private Date data;
	
	@Getter
	@Setter
	@Column(name="id_user")
	private long user;

	public DiaryEntity(Diary diary) {
		this.feeling = diary.getFeeling();
		this.diary = diary.getDiary();
		this.data = diary.getData();
		this.user = diary.getUser();
	}
}
