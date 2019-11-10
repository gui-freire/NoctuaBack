package br.com.noctua.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserResponsibleEntity {
	
	@Getter
	@Setter
	private long id;
	
	@Getter
	@Setter
	private long userId;
	
	@Getter
	@Setter
	private long responsibleId;
	
	

}
