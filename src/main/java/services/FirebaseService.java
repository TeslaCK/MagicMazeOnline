package services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.database.annotations.Nullable;

import configurations.Database;
import controllers.Controller;
import javafx.application.Platform;


/**
 *
 * @author C.K
 */
public class FirebaseService {
	static public Firestore firestore;
	private static final String GAMES_PATH = "games";
	private CollectionReference colRef;
	
	

	public FirebaseService() {
		Database db = Database.getInstance();
		
		this.firestore = db.getFirestoreDatabase();
		
		this.colRef = this.firestore.collection(GAMES_PATH);
		
		//working methods
		// firebaseService.get("game1").get("name"); // get (document - snapshot)
		// firebaseService.get("game1").toObject(TestModel.class); // get (document - Object)
		// firebaseService.set("games/game1/game1", "player1", player); // set
		// firebaseService.update("game1", "name", testObject.getName()); //update (document - Object)
	}
	

	public void listen(String pathToCollection, String documentId, final Controller controller) {
		CollectionReference colRef = firestore.collection(pathToCollection);
		DocumentReference docRef = colRef.document(documentId);
		
		docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {

		  public void onEvent(@Nullable DocumentSnapshot snapshot,
		                      @Nullable FirestoreException e) {
		    if (e != null) {
		      System.err.println("Listen failed: " + e);
		      return;
		    }
		  
		    if (snapshot != null && snapshot.exists()) {
		    	

		    	controller.update(snapshot);
		    	
		    	System.out.println("Current data: " + snapshot.getData());
		    } else {
		      System.out.print("Current data: null");
		    }
		  }
		});
	}



	public void set(String pathToCollection, String documentId, Object docData) {
		CollectionReference colRef = firestore.collection(pathToCollection);
		ApiFuture<WriteResult> future = colRef.document(documentId).set(docData);

		try {
			System.out.println("Update time : " + future.get().getUpdateTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}



	public void update(String documentId, String theKey, Object docData) {
		// update als Object
		// DocumentReference objectRef = this.firestore.collection(collection).document(document);
		// objectRef.update("name", testObject.getClass());

		Map<String, Object> updates = new HashMap<>();
		updates.put(theKey, docData);
		
		ApiFuture<WriteResult> future = this.colRef.document(documentId).update(updates);
		

		try {
			System.out.println("Update time : " + future.get().getUpdateTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	

	public DocumentSnapshot get(String pathToCollection, String documentId) {
		CollectionReference colRef = firestore.collection(pathToCollection);
		ApiFuture<DocumentSnapshot> docRef = colRef.document(documentId).get();
		DocumentSnapshot document;
		
		try {
			document = docRef.get();
			
			if (document.exists()) {
			  return document;
			} else {
				
			  System.out.println("No such document!");
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		} 
		return null;
	}
	
<<<<<<< HEAD
=======
	
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9

	public void delete(String documentId) {
		ApiFuture<WriteResult> writeResult = this.colRef.document(documentId).delete();
	}
}
