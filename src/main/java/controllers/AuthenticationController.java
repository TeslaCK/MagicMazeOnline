package controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;
import views.View;

public class AuthenticationController implements Controller {
    private FirebaseService firebaseService;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private LobbyModel lobbyModel;
    private String pathToCollection = "lobbies";
    private String documentId;


    public AuthenticationController() {
        firebaseService = new FirebaseService();
        this.sceneManager = new SceneManager();
    }

    public void CheckLogin(Stage primaryStage, String valueOfTextField) {
        PlayerModel currentPlayer = new PlayerModel("CK_join", "ultra");

        this.documentId = valueOfTextField;

        System.out.println(documentId);
        this.lobbyModel.addPlayerToLobby(currentPlayer);

        this.firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);
        this.sceneManager.switchToLobbyView(primaryStage, this.lobbyModel, this.documentId);
    }


    @Override
    public void update(DocumentSnapshot ds) {

    }


    @Override
    public void registerObserver(View v) {

    }
}
