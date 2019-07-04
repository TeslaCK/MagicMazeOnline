package controllers;

import models.LobbyModel;
import javafx.stage.Stage;
import views.*;
import views.LobbyManagerView;


/**
 * @author CK
 */
public class SceneManager {

	public SceneManager() {
	}


	public Stage changeToGameView(Stage primaryStage, GameController gameController) {
		GameView gameView = new GameView(primaryStage, gameController);
		gameView.loadPrimaryStageWithPane(primaryStage);

		return primaryStage;
	}


	public Stage changeToLobbyView(Stage primaryStage, LobbyModel lobby, String documentID, GameController gameController, LobbyController lobbyController) {
		LobbyView lobbyView = new LobbyView(primaryStage, lobby, documentID, gameController, lobbyController);
		lobbyView.loadPrimaryStageWithPane(primaryStage);

		return primaryStage;
	}


	public Stage changeToJoinLobbyView(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
		JoinLobbyView joinLobbyView = new JoinLobbyView(primaryStage, gameController, lobbyController);
		joinLobbyView.loadPrimaryStageWithPane(primaryStage);

		return primaryStage;
	}


	public Stage changeToCreateOrJoinLobbyView(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
		LobbyManagerView lobbyManagerView = new LobbyManagerView(primaryStage, gameController, lobbyController);
		lobbyManagerView.loadPrimaryStageWithPane(primaryStage);

		return primaryStage;
	}


	public Stage changeToLoginView(Stage primaryStage) {
		LoginView loginView = new LoginView(primaryStage);
		loginView.loadPrimaryStageWithPane(primaryStage);

		return primaryStage;
	}

}
