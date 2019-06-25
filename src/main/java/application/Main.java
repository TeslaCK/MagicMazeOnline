package application;


import javafx.application.Application;
import javafx.stage.Stage;
import views.CreateOrJoinLobbyView;
import views.LobbyView;
<<<<<<< HEAD
=======
import views.LoginAndRegisterView;
import views.LoginOrRegisterView;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9

import java.io.IOException;
import java.util.concurrent.ExecutionException;


<<<<<<< HEAD
public class Main extends Application {
    //	JoinLobbyView joinLobbyView = new JoinLobbyView();
    LobbyView lobbyView;
//	GameView gameView = new GameView();

//	LoginAndRegisterView lobbyView = new LoginAndRegisterView();


    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException, ExecutionException, NullPointerException {
        try {
//			PlayerModel player = new PlayerModel("gogeta", "lambo");
//			firebaseService.get("games/game1/game1", "lobby", lobby);


            CreateOrJoinLobbyView createOrJoinLobbyView = new CreateOrJoinLobbyView(primaryStage);
            createOrJoinLobbyView.loadPrimaryStageWithPane(primaryStage);
=======
public class Main extends Application
{    
//	JoinLobbyView joinLobbyView = new JoinLobbyView();
	LobbyView lobbyView;
//	GameView gameView = new GameView();

//	LoginAndRegisterView lobbyView = new LoginAndRegisterView();
	
	
    @Override
	public void start(Stage primaryStage) throws IOException, InterruptedException, ExecutionException, NullPointerException {
		try {
//			PlayerModel player = new PlayerModel("gogeta", "lambo");
//			firebaseService.get("games/game1/game1", "lobby", lobby);
			

			//CreateOrJoinLobbyView createOrJoinLobbyView = new CreateOrJoinLobbyView(primaryStage);
			//createOrJoinLobbyView.loadPrimaryStageWithPane(primaryStage);

			LoginAndRegisterView loginAndRegisterView = new LoginAndRegisterView(primaryStage);
			loginAndRegisterView.loadPrimaryStageWithPane(primaryStage);

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
//			joinLobbyView.loadPrimaryStageWithPane(primaryStage);
//			this.lobbyView = new LobbyView(primaryStage);
//			this.lobbyView.loadPrimaryStageWithPane(primaryStage);
//			gameView.loadPrimaryStageWithPane(primaryStage);
//			removeCrystalsFromCaravanView.loadPrimaryStageWithPane(primaryStage);
//			upgradeCrysalView.loadPrimaryStageWithPane(primaryStage);
<<<<<<< HEAD
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
=======
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
		launch(args);
	}
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
}
