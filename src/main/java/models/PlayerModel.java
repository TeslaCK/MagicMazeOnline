
package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;

import controllers.GameController;

import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.annotation.Exclude;

import shared.Observable;
import services.FirebaseService;
import views.View;

/**
 * @author CK
 */
public class PlayerModel implements Observable, Model {
	@Exclude
	private List<View> observers = new ArrayList<View>();

	@Exclude
	private GameController gameController;

	@Exclude
	private static int nextID = 0;

	public Integer id;
	public int score = 0;
	public String username, password;
	public boolean isAtTurn = false;
	public boolean lobbyConfirmation = false;


	public PlayerModel() {
	}

	public PlayerModel(String username, String password) {
		this.username = username;
		this.password = password;

		try {
			int nextIdToInt = Integer.parseInt(this.whatIsTheHighestPlayerId());
			PlayerModel.nextID = nextIdToInt;
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

		this.id = PlayerModel.nextID++;
		this.id++;
	}

	public Integer getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	@Exclude
	public GameController getGameController() {
		return gameController;
	}

	@Exclude
	public boolean getLobbyConfirmation() {
		return lobbyConfirmation;
	}

	public void setLobbyConfirmation(boolean lobbyConfirmation) {
		this.lobbyConfirmation = lobbyConfirmation;
	}

	@Exclude
	public List<View> getObservers() {
		return observers;
	}

	@Exclude
	public void setObservers(List<View> observers) {
		this.observers = observers;
	}

	@Exclude
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void updatePlayer() {

	}


	public void registerObserver(View v) {
		this.observers.add(v);
	}

	public void unregisterObserver(View v) {
		this.observers.remove(v);
	}

	public void notifyObservers(DocumentSnapshot ds) {
		for (View o : observers) {
			o.update();
		}
	}


	// make new lobby
	public void makeNewLobby(int id) {
		// LobbyModel v = new LobbyModel(id);
		// this.lobbyModels.add(v);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String whatIsTheHighestPlayerId() throws InterruptedException, ExecutionException {
		CollectionReference collectionRef = FirebaseService.firestore.collection("newplayers");
		Query query = collectionRef.orderBy("id", Direction.DESCENDING).limit(1);

		Query queryy = collectionRef.orderBy("id");

		ApiFuture<QuerySnapshot> querySnapshot = queryy.get();

		String highestPlayerId = "test";

		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			highestPlayerId = document.getId();
		}

		return highestPlayerId;
	}
}
