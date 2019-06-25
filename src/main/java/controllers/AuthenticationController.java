package controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;
import views.View;

public class AuthenticationController implements Controller  {
    private FirebaseService firebaseService;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private LobbyModel lobbyModel;
    private String pathToCollection = "lobbies";
    private String documentId;



    public AuthenticationController() {
//		this.gameController = new GameController();
        firebaseService = new FirebaseService();
        this.sceneManager = new SceneManager();
    }

    public void CheckLogin(Stage primaryStage, String valueOfTextField) {
        //test with currentPlayer, gaat er later uit, moet dynamisch worden
        PlayerModel currentPlayer = new PlayerModel("CK_join", "ultra");

//        if(this.checkIfLobbyExists(valueOfTextField)) {
            this.documentId = valueOfTextField;

            System.out.println(documentId);
            //this.lobbyModel = this.returnThisLobby(valueOfTextField);
            this.lobbyModel.addPlayerToLobby(currentPlayer);

            this.firebaseService.set(pathToCollection, valueOfTextField, this.lobbyModel);
            this.sceneManager.switchToLobbyView(primaryStage, this.lobbyModel, this.documentId);
//        } else {
//            // hier moet een alert komen, lobby bestaat niet
//            System.out.println("lobby not found");
//        }
    }


    @Override
    public void update(DocumentSnapshot ds) {

    }



    @Override
    public void registerObserver(View v) {

    }


}
