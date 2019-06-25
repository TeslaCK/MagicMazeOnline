package controllers;

import javafx.stage.Stage;
import models.LobbyModel;
import views.CreateOrJoinLobbyView;
import views.GameView;
import views.JoinLobbyView;
import views.LobbyView;
<<<<<<< HEAD
=======

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
//import views.PlayCardXTimesView;


/**
 *
 * @author C.K
 */
public class SceneManager {

	
	public SceneManager() {
	}



	public Stage switchToGameView(Stage primaryStage) {
		GameView gameView = new GameView(primaryStage);
		gameView.loadPrimaryStageWithPane(primaryStage);
		
		return primaryStage;
	}
	

	public Stage switchToLobbyView(Stage primaryStage, LobbyModel lobby, String lobbyDocumentId) {
		LobbyView lobbyView = new LobbyView(primaryStage, lobby, lobbyDocumentId);
		lobbyView.loadPrimaryStageWithPane(primaryStage);
		
		return primaryStage;
	}
	
	

	public Stage switchToJoinLobbyView(Stage primaryStage) {
		JoinLobbyView joinLobbyView = new JoinLobbyView(primaryStage);
		joinLobbyView.loadPrimaryStageWithPane(primaryStage);
		
		return primaryStage;
	}
	
	

<<<<<<< HEAD
	public Stage switchToCreateOrJoinLobbyView(Stage primaryStage) {
=======
	public Stage switchToCreateOrJoinLobbyView(Stage primaryStage) throws FileNotFoundException, MalformedURLException {
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		CreateOrJoinLobbyView createOrJoinLobbyView = new CreateOrJoinLobbyView(primaryStage);
		createOrJoinLobbyView.loadPrimaryStageWithPane(primaryStage);
		
		return primaryStage;
	}
	
	


	
}
