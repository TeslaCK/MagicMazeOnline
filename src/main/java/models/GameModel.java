package models;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.annotation.Exclude;

import controllers.GameController;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.stage.Stage;
import shared.Observable;
import views.AlertView;
import views.View;

/**
 * @author CK
 */
public class GameModel implements Observable, Model {
	@Exclude
	private List<View> observers = new ArrayList<View>();

	@Exclude
	private SceneManager sceneManager = new SceneManager();

	@Exclude
	private PlayerModel currentPlayer;

	public Integer id;
	public List<PlayerModel> playersInGame = new ArrayList<>();
	public boolean readyToStartGame = false;

	public GameModel() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void registerObserver(View v) {
		this.observers.add(v);
	}

	public void unregisterObserver(View v) {
		this.observers.remove(v);

	}

	public void notifyObservers(DocumentSnapshot ds) {
		GameModel newGame = ds.toObject(GameModel.class);

		this.id = newGame.id;
		this.playersInGame = newGame.playersInGame;
		this.readyToStartGame = newGame.readyToStartGame;

		updateCurrentPlayer();

		for (View o : observers) {
			o.update();
		}
	}

	public boolean getReadyToStartGame() {
		return readyToStartGame;
	}

	public void setReadyToStartGame(boolean readyToStartGame) {
		this.readyToStartGame = readyToStartGame;
	}

	@Exclude
	public List<PlayerModel> getPlayerModels() {
		return this.playersInGame;
	}

	public void playerAtTurn() {

	}


	public void loginPlayer(String username, String password, Stage ps, List<PlayerModel> players, GameController gc, LobbyController lc) {
		for (PlayerModel player : players) {
			if (!((username.contentEquals(player.getUsername()) && password.contentEquals(player.getPassword())))) {
				continue;
			} else {

				sceneManager.changeToCreateOrJoinLobbyView(ps, null, null);
				return;
			}
		}
		AlertView a = new AlertView();
		a.alert("Could not find valid login!");
	}


	@Exclude
	public PlayerModel getCurrentPlayer() {
		return currentPlayer;
	}


	@Exclude
	public void setCurrentPlayer(PlayerModel currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	public void loadPlayersInTheGame(List<PlayerModel> listOfPlayersFromLobby) {
		this.playersInGame = listOfPlayersFromLobby;
	}


	public void removePlayerFromGame(PlayerModel player) {
		int index = -1;
		int indexOfPlayerToBeRemoved = 0;

		for (PlayerModel playerToremove : this.playersInGame) {
			index++;

			if (playerToremove.getUsername().equals(player.getUsername())) {
				indexOfPlayerToBeRemoved = index;
			}
		}

		this.playersInGame.remove(indexOfPlayerToBeRemoved);
	}

	public void addPlayerToGame(PlayerModel player) {

		this.playersInGame.add(player);
	}


	private void updateCurrentPlayer() {
		for (PlayerModel player : this.playersInGame) {
			if (this.currentPlayer.id == player.id) {
				this.currentPlayer.score = player.score;
			}
		}
	}


	public List<PlayerModel> filterOutCurrentPlayerFromPlayersInGame(List<PlayerModel> listOfPlayersInGame,
																	 PlayerModel player) {
		int index = -1;
		int indexOfPlayerToBeRemoved = 0;

		for (PlayerModel playerToremove : listOfPlayersInGame) {
			index++;

			if (playerToremove.id == player.id) {
				indexOfPlayerToBeRemoved = index;
			}
		}

		listOfPlayersInGame.remove(indexOfPlayerToBeRemoved);

		return listOfPlayersInGame;
	}


}
