package br.com.noctua.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import br.com.noctua.entity.ResponsibleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponsibleDTO {

	@Getter
	@Setter
	@JsonProperty("name")
	private String name;

	@Getter
	@Setter
	@JsonProperty("surname")
	private String surname;

	@Getter
	@Setter
	@JsonProperty("email")
	private String email;
	
	public ResponsibleDTO(ResponsibleEntity responsible) {
		this.name = responsible.getName();
		this.surname = responsible.getSurname();
		this.email = responsible.getEmail();
	}
}
