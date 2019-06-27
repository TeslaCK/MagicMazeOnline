package application;


import javafx.application.Application;
import javafx.stage.Stage;
import views.CreateOrJoinLobbyView;
import views.LobbyView;
import views.LoginAndRegisterView;
import views.LoginOrRegisterView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Main extends Application
{
    LobbyView lobbyView;

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException, ExecutionException, NullPointerException {
        try {

            LoginAndRegisterView loginAndRegisterView = new LoginAndRegisterView(primaryStage);
            loginAndRegisterView.loadPrimaryStageWithPane(primaryStage);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}