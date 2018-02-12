package Noctua.noctuaback;

import Noctua.firebase.Firebase;

/**
 * Hello world!
 *
 */
public class App {
	Firebase firebase = new Firebase();
	
	public static void main(String[] args) {
		Firebase.accessToken();
	}
}
