package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.annotation.Exclude;

import javafx.application.Platform;
import services.FirebaseService;
import shared.Observable;
import views.View;

/**
 *
 * @author C.K
 */
public class LobbyModel implements Observable, Model {
	@Exclude
	public List<View> observers = new ArrayList<View>();
	
	public Integer id;
	public static int nextID = 0;
	public boolean confirmation;
	public String state;
	public List<PlayerModel> players = new ArrayList<>();
	

	public LobbyModel() {
		try {
			int nextIdToInt = Integer.parseInt(this.whatIsTheHighestLobbyId());
			this.nextID = nextIdToInt;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.id = this.nextID++;
		this.id++;
	}
	

	public void registerObserver(View v) {
		this.observers.add(v);
	}
	

	public void unregisterObserver(View v) {
		this.observers.remove(v);
		
	}


	public void notifyObservers(DocumentSnapshot ds) {
		// Elke View waarschuwen dat er een wijziging is in de model is geweest
		LobbyModel newLobby = ds.toObject(LobbyModel.class);
		
		this.id = newLobby.id;
		this.players = newLobby.players;

		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).update();
		}
	}
	
	

	public void removePlayerFromLobby(PlayerModel player) {
		this.players.remove(player);
		
		int index = -1;
		int indexOfPlayerToBeRemoved = 0;
		
		for (PlayerModel playerToremove: this.players) {
			index++;
			
			if(playerToremove.getUsername().equals(player.getUsername())) {
				indexOfPlayerToBeRemoved = index;
			}
			
			System.out.println(playerToremove.getUsername() + " " + index);
		}
		
		this.players.remove(indexOfPlayerToBeRemoved);
	}
	
	

	public void addPlayerToLobby(PlayerModel player) {
		this.players.add(player);
	}
	
	

	public List<PlayerModel> retrievePlayersInLobby() {
		return this.players;
	}
	

	public String whatIsTheHighestLobbyId() throws InterruptedException, ExecutionException {
		CollectionReference collectionRef = FirebaseService.firestore.collection("lobbies");
		Query query = collectionRef.orderBy("id", Direction.DESCENDING).limit(1);
		
		Query queryy = collectionRef.orderBy("id");

		ApiFuture<QuerySnapshot> querySnapshot = queryy.get();
		
		String highestLobbyId = "";
		
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			highestLobbyId = document.getId();
		}
		
		return highestLobbyId;
	}
	

	public void initializeGame() {
		
	}
}
