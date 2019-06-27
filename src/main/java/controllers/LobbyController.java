package controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;
import views.CreateOrJoinLobbyView;
import views.JoinLobbyView;
import views.LobbyView;
import views.View;


/**
 *
 * @author C.K
 */
public class LobbyController implements Controller {
	private FirebaseService firebaseService;
	private Stage primaryStage;
	private SceneManager sceneManager;
	private LobbyModel lobbyModel;
	private String pathToCollection = "lobbies";
	private String documentId;
	
	

	public LobbyController() {
		firebaseService = new FirebaseService();
		this.sceneManager = new SceneManager();
	}
	

	public void setLobbyModel(LobbyModel lobbyModel) {
		this.lobbyModel = lobbyModel;
		firebaseService.listen(pathToCollection, this.lobbyModel.id.toString(), this);
	}


	@Override
	public void registerObserver(View v) {
		this.lobbyModel.registerObserver(v);
		System.out.println(v.toString());
	}
	

	public void update(DocumentSnapshot ds) {
		// Deze update wordt getriggerd na het wijzigen van de db.
		System.out.println("update gekregen");
		
		this.lobbyModel.notifyObservers(ds);
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
	

	public void leaveLobby(Stage primaryStage, String valueOfTextField) {
		//test with currentPlayer, gaat er later uit, moet dynamisch worden
		PlayerModel currentPlayer = new PlayerModel("CK_leaf", "ultra");
		
		this.lobbyModel.removePlayerFromLobby(currentPlayer);
		
		firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);
		
		this.sceneManager.switchToJoinLobbyView(primaryStage);
	}
	

	public void createLobby(Stage primaryStage) {
		this.lobbyModel = new LobbyModel();
		
		//test with currentPlayer, gaat er later uit, moet dynamisch worden
		PlayerModel currentPlayer = new PlayerModel("CK_create", "ultra");
		this.lobbyModel.addPlayerToLobby(currentPlayer);
		
		//later dynamisch
		String lobbyNumber = this.lobbyModel.id.toString();
		
		firebaseService.set(pathToCollection, lobbyNumber, this.lobbyModel);
		
		this.sceneManager.switchToLobbyView(primaryStage, this.lobbyModel, lobbyNumber);
	}
	

	public void joinLobby(Stage primaryStage, String valueOfTextField) {
		//test with currentPlayer, gaat er later uit, moet dynamisch worden
		PlayerModel currentPlayer = new PlayerModel("CK_join", "ultra");
		
		if(this.checkIfLobbyExists(valueOfTextField)) {
			this.documentId = valueOfTextField;
			this.lobbyModel = this.returnThisLobby(valueOfTextField);
			this.lobbyModel.addPlayerToLobby(currentPlayer);

			this.firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);
			this.sceneManager.switchToLobbyView(primaryStage, this.lobbyModel, this.documentId);
		} else {
			// hier moet een alert komen, lobby bestaat niet
			System.out.println("lobby not found");
		}
	}
	

	private LobbyModel returnThisLobby(String lobbyId) {
		return this.firebaseService.get("lobbies", lobbyId).toObject(LobbyModel.class);
	}
	

	private boolean checkIfLobbyExists(String valueOfTextField) {
		LobbyModel checkLobby = this.firebaseService.get("lobbies", valueOfTextField).toObject(LobbyModel.class);
		
		if(checkLobby.id.toString().equals(valueOfTextField)) {
			System.out.println("lobby found");
			return true;
		}
		
		System.out.println("lobby not found");
		
		return false;
	}
}
