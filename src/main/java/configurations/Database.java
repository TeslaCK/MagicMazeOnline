package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


/**
 * @author C.K
 */
public class Database {
	private static final Database instance = new Database();

	private static final String PRIVATEKEYLOCATION = "C:/Users/tessa/Documents/MagicMazeOnline/src/main/java/configurations/magicmaze-74bf0-firebase-adminsdk-0igqh-0b042ffbf0.json";
	private static final String DATABASEURL = "https://magicmaze-74bf0.firebaseio.com";
	private Firestore db;
	

	public Database() {
		try {
			InputStream serviceAccount = new FileInputStream(PRIVATEKEYLOCATION);
	        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
	        FirebaseOptions options = new FirebaseOptions.Builder()
	            .setCredentials(credentials)
	            .build();
	        
	        FirebaseApp.initializeApp(options);
	        this.db = FirestoreClient.getFirestore();
	        
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Database getInstance() {
		return instance;
	}
	

	public Firestore getFirestoreDatabase() {
		return this.db;
	}
}
