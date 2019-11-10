package br.com.noctua.firebase.domain;

import lombok.Getter;
import lombok.Setter;

public class Notification {

	@Getter
	@Setter
	private String title; // titulo da notifica��o

	@Getter
	@Setter
	private String body; // corpo da notifica��o

	@Getter
	@Setter
	private String token;
}
