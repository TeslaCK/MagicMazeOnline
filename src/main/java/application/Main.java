package application;


import javafx.application.Application;
import javafx.stage.Stage;
import views.LobbyView;
import views.LoginView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Main extends Application
{
    //	JoinLobbyView joinLobbyView = new JoinLobbyView();
    LobbyView lobbyView;
//	GameView gameView = new GameView();

//	LoginView lobbyView = new LoginView();


    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException, ExecutionException, NullPointerException {
        try {
//			PlayerModel player = new PlayerModel("gogeta", "lambo");
//			firebaseService.get("games/game1/game1", "lobby", lobby);


            //LobbyManagerView createOrJoinLobbyView = new LobbyManagerView(primaryStage);
            //createOrJoinLobbyView.loadPrimaryStageWithPane(primaryStage);

            LoginView loginView = new LoginView(primaryStage);
            loginView.loadPrimaryStageWithPane(primaryStage);

//			joinLobbyView.loadPrimaryStageWithPane(primaryStage);
//			this.lobbyView = new LobbyView(primaryStage);
//			this.lobbyView.loadPrimaryStageWithPane(primaryStage);
//			gameView.loadPrimaryStageWithPane(primaryStage);
//			removeCrystalsFromCaravanView.loadPrimaryStageWithPane(primaryStage);
//			upgradeCrysalView.loadPrimaryStageWithPane(primaryStage);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
