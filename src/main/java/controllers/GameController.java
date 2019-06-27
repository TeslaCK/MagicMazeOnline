package controllers;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.stage.Stage;
import models.Model;
import services.FirebaseService;
import models.GameModel;
import shared.Observable;
import views.GameView;
import views.JoinLobbyView;
import views.View;

/**
 *
 * @author C.K
 */
public class GameController implements Controller {
	private Model gameModel;
	private Stage primaryStage;
	public GameController() {
		this.gameModel = new GameModel();	
	}	

	public void update(DocumentSnapshot ds) {
		// Deze update wordt getriggerd na het wijzigen van de db.
		System.out.println("update gekregen");
	}

	public void registerObserver(View v) {
		 gameModel.registerObserver(v);
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
}
