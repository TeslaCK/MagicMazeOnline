
package models;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import shared.Observable;
import views.View;

/**
 *
 * @author C.K
 */

public class PlayerModel implements Observable, Model {
	public List<View> observers = new ArrayList<View>();
	public int id, score = 0;
	public String username, password;

	public PlayerModel() {

	}
	
	public PlayerModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

	public void rest() {
		
	}
	

	public void play(GameModel game,PlayerModel player) {
		
	}
	

	public void buy(GameModel game, PlayerModel player) {
		game.changeTurn();
	}
	

	public void upgrade(GameModel game) {
		game.changeTurn();
	}
	
	

	public void renderPlayer() {
		
	}
	

	public void updatePlayer() {
		
	}

	public void registerObserver(View v) {
		this.observers.add(v);
	}

	
	public void unregisterObserver(View v) {
		this.observers.remove(v);
	}

	
	public void notifyObservers(DocumentSnapshot ds) {
//		for (View o : observers) {
//			o.update();
//		}
	}
	
	

	
	
	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
}

