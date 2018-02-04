package Noctua.firebase;


import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import Noctua.dto.Notification;

public class Firebase {
	
	private static final String URL_FIREBASE_SERVICE = "https://fcm.googleapis.com/fcm/send";
	private Logger LOG;
	private HttpsURLConnection connection;
	
	public void sendNotification(Notification notification) {
		try {
		URL firebaseService = new URL(URL_FIREBASE_SERVICE);
		connection = (HttpsURLConnection) firebaseService.openConnection();
		InputStream content = connection.getInputStream();
		} catch (Exception e) {
			LOG.info("Erro ao enviar notificação " + e.getMessage());
		} finally {
			connection.disconnect();
		}
	}
	

}
