package Noctua.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import Noctua.dto.Notification;

public class Firebase {

	private static final String URL_FIREBASE_SERVICE = "https://fcm.googleapis.com/fcm/send";
	private static final String SCOPES = "https://www.googleapis.com/auth/firebase.messaging";
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

	private static String getAccessToken() throws IOException {
		GoogleCredential googleCredential = GoogleCredential.fromStream
				(new FileInputStream("C:/Users/gui-f/Downloads/noctua2-5489b-firebase-adminsdk-uwukt-5d21fbc44d.json"))
				.createScoped(Arrays.asList(SCOPES));
		googleCredential.refreshToken();
		System.out.print(googleCredential.getAccessToken());
		return googleCredential.getAccessToken();
	}

	public static void accessToken() {
		try {
			startFirebase();
			String whatever = getAccessToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private HttpURLConnection getConnection() {
	// URL url = new URL(BASE_URL + FCM_SEND_ENDPOINT);
	// HttpURLConnection httpURLConnection = (HttpURLConnection)
	// url.openConnection();
	// httpURLConnection.setRequestProperty("Authorization", "Bearer " +
	// getAccessToken());
	// httpURLConnection.setRequestProperty("Content-Type", "application/json;
	// UTF-8");
	// return httpURLConnection;
	// }
	
	private static void startFirebase() throws IOException {
		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream(
					"C:/Users/gui-f/Downloads/noctua2-5489b-firebase-adminsdk-uwukt-5d21fbc44d.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://noctua2-5489b.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
