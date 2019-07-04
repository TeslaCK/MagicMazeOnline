package controllers;

import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;
import views.AlertView;
import views.View;

/**
 * @author CK
 */
public class LobbyController implements Controller {

	private static LobbyController lobbyControllerCarl;
	private GameController gameController;
	private FirebaseService firebaseService;
	private Stage primaryStage;
	private SceneManager sceneManager;
	public LobbyModel lobbyModel;
	//namechange
	private String pathToCollection = "newlobbies";
	private String documentId;
	private LobbyController lobbyController;

	/**
	 * If you call LobbyController.getInstance() it guarantees there is only 1 instance.
	 * It gives you the existing lobbyController or else it makes a new one.
	 *
	 * @return The lobbyController.
	 * @author Carl Zee
	 */
	public static LobbyController getInstance() {
		if (lobbyControllerCarl == null) {
			new LobbyController();
		}
		return lobbyControllerCarl;
	}

	/**
	 * This return the id from the lobbyModel.
	 *
	 * @return The id of the lobbyModel.
	 */
	public int askLobbyModelID() {
		return this.lobbyModel.id;
	}


	public LobbyController() {
		this.firebaseService = new FirebaseService();
		this.sceneManager = new SceneManager();
	}

	public void update(DocumentSnapshot ds) {
		// Deze update wordt getriggerd na het wijzigen van de db.
		System.out.println("de lobby controller heeft een update gekregen");

		this.lobbyModel.notifyObservers(ds);
	}


	public void setLobbyModel(LobbyModel lobbyModel) {
		this.lobbyModel = lobbyModel;
		this.firebaseService.listen(pathToCollection, this.lobbyModel.id.toString(), this);
	}


	@Override
	public void registerObserver(View v) {
		this.lobbyModel.registerObserver(v);
		System.out.println(v.toString());
	}


	public Stage getPrimaryStage() {
		return this.primaryStage;
	}


	public List<PlayerModel> retrievePlayersInLobby() {
		return this.lobbyModel.retrievePlayersInLobby();
	}

	public LobbyModel returnThisLobby() {
		return this.lobbyModel;
	}

	public void leaveLobby(Stage primaryStage, String valueOfTextField, GameController gameController, LobbyController lobbyController) {
		this.gameController = gameController;
		this.lobbyController = lobbyController;

		PlayerModel currentPlayer = this.gameController.gameModel.getCurrentPlayer();

		this.lobbyModel.removePlayerFromLobby(currentPlayer);

		firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);

		this.sceneManager.changeToJoinLobbyView(primaryStage, this.gameController, this.lobbyController);
	}


	public void createLobby(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
		this.primaryStage = primaryStage;
		this.gameController = gameController;
		this.lobbyController = lobbyController;
		this.lobbyModel = new LobbyModel();

		PlayerModel currentPlayer = this.gameController.gameModel.getCurrentPlayer();
		this.lobbyModel.addPlayerToLobby(currentPlayer);
		this.lobbyModel.setHostPlayerId(currentPlayer.id);

		// later dynamisch
		String lobbyNumber = this.lobbyModel.id.toString();

		this.firebaseService.set(pathToCollection, lobbyNumber, this.lobbyModel);

		this.gameController.createGame(primaryStage, lobbyController, gameController);

		this.sceneManager.changeToLobbyView(primaryStage, this.lobbyModel, lobbyNumber, gameController, lobbyController);
	}


	public void joinLobby(Stage primaryStage, String valueOfTextField, GameController gameController, LobbyController lobbyController) {
		this.gameController = gameController;
		this.lobbyController = lobbyController;

		PlayerModel currentPlayer = this.gameController.gameModel.getCurrentPlayer();

		if (this.checkIfLobbyExists(valueOfTextField)) {
			this.documentId = valueOfTextField;
			this.lobbyModel = this.returnLobbyWithId(valueOfTextField);
			this.lobbyModel.addPlayerToLobby(currentPlayer);

			this.firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);
			this.sceneManager.changeToLobbyView(primaryStage, this.lobbyModel, this.documentId, gameController, lobbyController);
		} else {
			System.out.println("lobby not found");
		}

	}

	private LobbyModel returnLobbyWithId(String lobbyId) {
		return this.firebaseService.get("newlobbies", lobbyId).toObject(LobbyModel.class);
	}


	private boolean checkIfLobbyExists(String valueOfTextField) {
		try {
			LobbyModel checkLobby = this.firebaseService.get("newlobbies", valueOfTextField).toObject(LobbyModel.class);
			if (checkLobby.id.toString().equals(valueOfTextField)) {
				System.out.println("lobby found");
				return true;
			}
		} catch (NullPointerException npe) {
			AlertView a = new AlertView();
			a.alert("Lobby id not found! Try again please.");
		}

		return false;
	}

	public void aPlayerIsReady(Integer confirmationTeller, PlayerModel player) {
		if(confirmationTeller == 0) {
			this.lobbyModel.removePlayerFromLobby(player);
			player.setLobbyConfirmation(true);
			this.gameController.getFirebaseService().set("newplayers", Integer.toString(player.id), player);
			this.lobbyModel.addPlayerToLobby(player);

			int lobbyConfirmationTeller = this.gameController.firebaseService.get(pathToCollection, this.lobbyModel.id.toString()).toObject(LobbyModel.class).getConfirmationTeller();
			this.lobbyModel.setConfirmationTeller(lobbyConfirmationTeller + 1);
			this.gameController.firebaseService.set(pathToCollection, this.lobbyModel.id.toString(), this.lobbyModel);

			this.firebaseService.listen("newgames", lobbyModel.id.toString(), this.gameController);
		}

		if (this.lobbyModel.getConfirmationTeller() == this.lobbyModel.players.size()) {
			System.out.println("All lobby players are ready");
		}
	}


	public void initializeTheGame(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
		this.primaryStage = primaryStage;
		this.gameController = gameController;
		this.lobbyController = lobbyController;

		int lobbyConfirmationTeller = this.gameController.firebaseService.get(pathToCollection, this.lobbyModel.id.toString()).toObject(LobbyModel.class).getConfirmationTeller();

		if (lobbyConfirmationTeller == this.lobbyModel.players.size()) {
			if (this.lobbyModel.players.size() > 0) {
				System.out.println("Game is being initialized...");
				if(this.lobbyModel.getHostPlayerId() == this.gameController.gameModel.getCurrentPlayer().id) {
					gameController.startGame(primaryStage, gameController, lobbyController);
				} else {
					AlertView a = new AlertView();
					a.alert("You can't start the game. The host should.");
				}

			} else {
				AlertView a = new AlertView();
				a.alert("You can only play this game with at least 2 players. Wait for the others..");
			}
		} else {
			AlertView a = new AlertView();
			a.alert("You are not ready to start the game. Everyone should be ready first.");
		}
	}
}
