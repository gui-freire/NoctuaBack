package br.com.noctua.firebase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import br.com.noctua.domain.Notification;

public class Firebase {

	private static final String URL_FIREBASE_SERVICE = "https://fcm.googleapis.com/v1/projects/noctua2-5489b/messages:send";
	private static final String SCOPES = "https://www.googleapis.com/auth/firebase.messaging";
	private Logger LOG;
	private HttpsURLConnection connection;
	private String jsonRequest;

	public String sendNotification(Notification notification) {
		try {
			URL firebaseService = new URL(URL_FIREBASE_SERVICE);
			String token = getAccessToken();
			jsonRequest = "{"
					+ "\"message\":{"
					+ "\"token\":\"" + notification.getToken() + "\","
					+ "\"notification\":{"
							+ "\"body\":\"" + notification.getBody() + "\","
							+ "\"title\":\"" + notification.getTitle() + "\""
							+ "}"
					+ "}"
				+ "}";
			
			connection = (HttpsURLConnection) firebaseService.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + token);
			connection.setRequestProperty("Content-Type", "application/json; UTF-8");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			final OutputStreamWriter os = new OutputStreamWriter(connection.getOutputStream());
			os.append(jsonRequest);
			os.close();
			
			final BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuilder response = new StringBuilder();
			String line;
			
			while((line = rd.readLine()) != null) {
				response.append(line);
			}
			
			return response.toString();
		} catch (Exception e) {
			LOG.info("Erro ao enviar notifica��o " + e.getMessage());
			return null;
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
