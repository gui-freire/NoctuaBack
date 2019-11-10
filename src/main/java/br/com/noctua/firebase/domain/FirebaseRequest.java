package br.com.noctua.firebase.domain;

public class FirebaseRequest {

	private String to; // destinat�rio(Firebase token)

	private Notification notification;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
