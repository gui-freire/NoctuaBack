package br.com.noctua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.noctua.dto.ResponsibleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity implementation class for Entity: ResponsibleEntity
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RESPONSAVEL")
public class ResponsibleEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@Column(name="ID_RESP")
	private long id;

	@Getter
	@Setter
	@Column(name="name")
	private String name;

	@Getter
	@Setter
	@Column(name="surname")
	private String surname;

	@Getter
	@Setter
	@Column(name="email")
	private String email;

	public ResponsibleEntity(ResponsibleDTO responsible) {
		this.name = responsible.getName();
		this.surname = responsible.getSurname();
		this.email = responsible.getEmail();
	}
}
