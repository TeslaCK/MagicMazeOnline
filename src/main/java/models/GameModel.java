package models;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import shared.Observable;
import shared.Observer;
import views.CreateOrJoinLobbyView;
import views.View;

/**
 *
 * @author C.K
 */
public class GameModel implements Observable, Model {
	private List<View> observers = new ArrayList<View>();
	private ArrayList<PlayerModel> playerModels =  new ArrayList<PlayerModel>();
	private PlayerModel currentPlayer = new PlayerModel("vegeto", "ultra");
	private int id;
	private String state;
	
	
	public GameModel() {
	}
	

	public void registerObserver(View v) {
		this.observers.add(v);
	}

	
	public void unregisterObserver(View v) {
		this.observers.remove(v);
		
	}

	
	public void notifyObservers(DocumentSnapshot ds) {
		// Notify views of model update
//		for (View o : observers) {
//			o.update();
//		}		
	}


	public void playerAtTurn() {
		
	}
	
	
	public PlayerModel getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(PlayerModel currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	public void handleLogin(String username, String password, Stage primaryStage) throws FileNotFoundException, MalformedURLException {
		if (username.isEmpty() || password.isEmpty()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Oops!");
    		alert.setHeaderText(null);
    		alert.setContentText("It seems you got incorrect credentials!");
    		alert.showAndWait();
    	} 
		else {
			for (int i = 0; i < playerModels.size(); i++) {
				String username1=playerModels.get(i).getUsername();
				String password1=playerModels.get(i).getPassword();
				if(username.equals(username1) == true) {
					if(password.equals(password1) == true) {
					  CreateOrJoinLobbyView createOrJoinLobbyView = new CreateOrJoinLobbyView(primaryStage);
						createOrJoinLobbyView.loadPrimaryStageWithPane(primaryStage);
					}
				  }
				  else {
					  Alert alert = new Alert(AlertType.INFORMATION);
			    		alert.setTitle("Oops!");
			    		alert.setHeaderText(null);
			    		alert.setContentText("It seems you got incorrect credentials!");
			    		alert.showAndWait();
			    		return; 
				  }
			}
		
		}
		
		
		}
		

	public void registerPlayer(String username, String password) {
		if (username.isEmpty() || password.isEmpty()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Oops!");
    		alert.setHeaderText(null);
    		alert.setContentText("It seems you didn't enter valid credentials!");
    		alert.showAndWait();
    	} 
		else {
			for (int i = 0; i < playerModels.size(); i++) {
				String username1=playerModels.get(i).getUsername();
				  if(username.equals(username1) == true) {
					  Alert alert = new Alert(AlertType.INFORMATION);
			    		alert.setTitle("Oops!");
			    		alert.setHeaderText(null);
			    		alert.setContentText("It seems that this username is already taken!");
			    		alert.showAndWait();
			    		return;
			    		}
				  PlayerModel v = new PlayerModel(username, password);		
					this.playerModels.add(v);
				  
					  
				  
				  }
		
			}
		}
	
	
	public void loginPlayer() {
		
	}
	
	
	public void loadGame() {
		
	}
	
	
	public void updateGame() {
		
	}
	
	
	public void endGame() {
		
	}
	
	
	public void changeTurn() {
		
	}
	
	
	public void getFirebaseService() {
		
	}
	
	
	public void setFirebaseService() {
		
	}

}
