package Noctua.request;

import java.util.Map;

import Noctua.dto.Notification;

//url: https://fcm.googleapis.com/fcm/send

public class FirebaseRequest {
	
	private String to; //destinatário(Firebase token)
	
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
