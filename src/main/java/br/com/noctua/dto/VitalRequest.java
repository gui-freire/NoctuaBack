package br.com.noctua.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class VitalRequest {

	@Getter
	@Setter
	@JsonProperty("id")
	private int id;
	
	@Getter
	@Setter
	@JsonProperty("day")
	private int day;
	
	@Getter
	@Setter
	@JsonProperty("week")
	private int week;
	
	@Getter
	@Setter
	@JsonProperty("mes")
	private int mes;
	
	@Getter
	@Setter
	@JsonProperty("email")
	private String email;
}
