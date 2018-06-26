package noctua.request;

import noctua.dto.Notification;

public class FirebaseRequest {

	private String to; // destinatário(Firebase token)

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
