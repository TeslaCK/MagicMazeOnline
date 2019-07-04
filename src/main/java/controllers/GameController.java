package controllers;

import java.util.*;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.PlayerModel;
import services.FirebaseService;
import models.GameModel;
import views.AlertView;
import views.View;

/**
 * @author CK
 */
public class GameController implements Controller {
	private SceneManager sceneManager;
	private Stage primaryStage;
	public FirebaseService firebaseService;
	public GameModel gameModel;
	private PlayerController playerController;
	private String pathToPlayersCollection = "newplayers";

	private LobbyController lobbyController;
	private GameController gameController;


	public GameController() {
		this.firebaseService = new FirebaseService();
		this.gameModel = new GameModel();
		this.sceneManager = new SceneManager();
		this.playerController = new PlayerController();
	}

	public void update(DocumentSnapshot ds) {

		System.out.println("gameupdate");

		this.gameModel.notifyObservers(ds);

		readyGame(ds);
	}


	private void readyGame(DocumentSnapshot ds) {
		GameModel gameModel = ds.toObject(GameModel.class);

		if (gameModel.readyToStartGame == true) {
			System.out.println("ready player");
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					sceneManager.changeToGameView(primaryStage, gameController);
				}
			});
		}
	}

	public void startGame(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
		this.primaryStage = primaryStage;
		this.gameController = gameController;
		this.lobbyController = lobbyController;

		System.out.println("initializing the game");

		this.gameModel.playersInGame = this.lobbyController.lobbyModel.players;

		this.gameModel.setReadyToStartGame(true);

		this.firebaseService.set("newgames", this.gameModel.id.toString(), this.gameModel);
	}

	public void registerObserver(View v) {
		gameModel.registerObserver(v);
	}

	public FirebaseService getFirebaseService() {
		return this.firebaseService;
	}

	public void setFirebaseService() {
		this.firebaseService = new FirebaseService();
	}


	public Stage getPrimaryStage() {
		return this.primaryStage;
	}


	public GameController getGameController() {
		return this;
	}


	private boolean checkIfRegister(String username, String password) { //TODO move to gamemodel
		for (PlayerModel player : getPlayersCollection()) {
			if (player.getUsername().equals(username)) {
				return true;
			}
		}

		return false;
	}


	public List<PlayerModel> getPlayersCollection(){
		List<QueryDocumentSnapshot> queryDocumentSnapshot = this.firebaseService.getCollection(this.pathToPlayersCollection);
		List<PlayerModel> playersCollectionJavaObjects = new ArrayList<PlayerModel>();

		for(QueryDocumentSnapshot players : queryDocumentSnapshot) {
			playersCollectionJavaObjects.add(players.toObject(PlayerModel.class));
		}
		return playersCollectionJavaObjects;
	}


	public void manageLoginView(String username, String password, boolean check, Stage primaryStage,
								LobbyController lobbyController, GameController gameController) {

		this.gameController = gameController;
		this.lobbyController = lobbyController;
		this.primaryStage = primaryStage;

		if (username.isEmpty() || password.isEmpty()) {
			AlertView a = new AlertView();
			a.alert("empty fields");
		} else {
			if (check) {
				registerPlayer(username, password, primaryStage, lobbyController);
			} else {
				loginPlayer(username, password, primaryStage, getPlayersCollection(), this, lobbyController);
			}
		}
	}


	private void registerPlayer(String username, String password, Stage ps, LobbyController lc) {
		if (!this.checkIfRegister(username, password)) {
			PlayerModel newPlayer = new PlayerModel(username, password);

			this.gameModel.getPlayerModels().add(newPlayer);

			this.firebaseService.set(this.pathToPlayersCollection, Integer.toString(newPlayer.id), newPlayer);

			this.gameModel.setCurrentPlayer(newPlayer);

			this.sceneManager.changeToCreateOrJoinLobbyView(ps, this, lc);
		} else {
			AlertView a = new AlertView();
			a.alert("account exists");
		}
	}


	private void loginPlayer(String username, String password, Stage ps, List<PlayerModel> players, GameController gc, LobbyController lc) {
		for (PlayerModel player : players) {
			if (!((username.contentEquals(player.getUsername()) && password.contentEquals(player.getPassword())))) {
				continue;
			} else {
				sceneManager.changeToCreateOrJoinLobbyView(ps, gc, lc);
				return;
			}
		}
		AlertView a = new AlertView();
		a.alert("login failed");
	}


	public void createGame(Stage primaryStage, LobbyController lobbyController, GameController gameController) {
		this.primaryStage = primaryStage;
		this.gameController = gameController;
		this.lobbyController = lobbyController;

		int gameId = this.lobbyController.returnThisLobby().id;

		GameModel gameModelBeforeStartingGame = this.gameModel;
		this.gameModel = new GameModel();
		this.gameModel.setId(gameId);
		this.gameModel.setCurrentPlayer(gameModelBeforeStartingGame.getCurrentPlayer());

		this.firebaseService.set("newgames", this.gameModel.id.toString(), this.gameModel);

	}
}
