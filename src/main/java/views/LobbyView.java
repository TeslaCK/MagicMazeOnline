package views;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import controllers.SceneManager;
import javafx.application.Platform;
import javafx.collections.ObservableList;
<<<<<<< HEAD
=======
import javafx.geometry.Insets;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
=======
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;


/**
 *
 * @author C.K
 */
public class LobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
<<<<<<< HEAD
	private int buttonWidth = 100;
	private int buttonHeight = 25;
=======
	private int buttonWidth = 200;
	private int buttonHeight = 50;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
	private SceneManager sceneManager;
	LobbyModel lobby;
	PlayerModel currentPlayer;
	String lobbyDocumentId;
	Label labelLobbyID;
	GridPane gPane;
<<<<<<< HEAD
=======

	int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
	

	public LobbyView(Stage primaryStage, LobbyModel lobby, String lobbyDocumentId) {
		this.sceneManager = new SceneManager();
		this.primaryStage = primaryStage;
		this.lobby = lobby;
		this.lobbyDocumentId = lobbyDocumentId;
		this.lobbyController = new LobbyController();
		this.lobbyController.setLobbyModel(lobby);
		this.lobbyController.registerObserver(this);
	}
	

	@Override
	public void update() {	
		
		Platform.runLater(new Runnable(){
			
			@Override
			public void run() {
				gPane.getChildren().retainAll(gPane.getChildren().get(0));

				labelLobbyID.setText(lobby.id.toString());
				
				int y = 0;
				
				for (PlayerModel player: lobby.players) {
					Label label = new Label(player.getUsername());
					Button readyButton = new Button("ready-new");
<<<<<<< HEAD
=======

					label.setStyle("-fx-font-size: 20;");
					readyButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
					int x = 0;
					gPane.add(label, x, y);
					x++;
					gPane.add(readyButton, x, y);
					y++;
					
<<<<<<< HEAD
					if (player.getUsername().equals("krillin")) {
=======
					if (player.getUsername().equals("CK")) {
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
						currentPlayer = player;
					}
				}
				
				gPane.setHgap(375);
				gPane.setVgap(15);
<<<<<<< HEAD
				gPane.setTranslateX(140);
				gPane.setTranslateY(100);
				gPane.setGridLinesVisible(false);
=======
				gPane.setTranslateX(360);
				gPane.setTranslateY(100);
				gPane.setGridLinesVisible(false);

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
			}
		});
	}


	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	

	public Stage loadPrimaryStageWithPane(Stage primaryStage) { 
		this.primaryStage = primaryStage;
<<<<<<< HEAD
		Scene scene = new Scene(this.createMainPane(), 1920, 1080);
=======
		Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
        
        primaryStage.setTitle("lobby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
		return primaryStage;
	}
	

	BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
<<<<<<< HEAD
		
		bPane.setCenter(this.Lobby());
		
=======


		ImageView imageViewleft = new ImageView();
		imageViewleft.setImage(new Image("/images/left.png"));

		ImageView imageViewright = new ImageView();
		imageViewright.setImage(new Image("/images/right.png"));

		imageViewleft.setFitHeight(screenHeight);
		imageViewright.setFitHeight(screenHeight);


		bPane.setLeft(imageViewleft);
		bPane.setCenter(this.Lobby());
		bPane.setRight(imageViewright);

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		return bPane;
	}
	

	private Pane Lobby() {
		Pane pane = new Pane();
		this.labelLobbyID = new Label("Lobby id: " + this.lobby.id);
		Button leaveButton = new Button("leave");
		Button startGameButton = new Button("start game");
		this.gPane = new GridPane();
<<<<<<< HEAD
		
		pane.setMaxSize(750, 500);
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		leaveButton.setPrefSize(buttonWidth, buttonHeight);
		startGameButton.setPrefSize(buttonWidth, buttonHeight);
=======



		pane.setMaxSize(screenWidth, screenHeight);
		//pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		//pane.setBackground(new Background(new BackgroundFill(Color.rgb(40, 40, 40), CornerRadii.EMPTY, Insets.EMPTY)));
		leaveButton.setPrefSize(buttonWidth, buttonHeight);
		startGameButton.setPrefSize(buttonWidth, buttonHeight);

		leaveButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
		startGameButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		
		int y = 0;
		
		for (PlayerModel player: this.lobby.players) {
<<<<<<< HEAD
			Label label = new Label(player.getUsername());
			Button readyButton = new Button("ready");
			int x = 0;
			this.gPane.add(label, x, y);
			x++;
			gPane.add(readyButton, x, y);
			y++;
			
			if (player.getUsername().equals("krillin")) {
=======

			//todo tmp comment
			//Label label = new Label(player.getUsername());
			Button readyButton = new Button("ready");
			readyButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
			int x = 0;
			//todo tmp comment
			//this.gPane.add(label, x, y);
			x++;
			gPane.add(readyButton, x, y);
			y++;

			if (player.getUsername().equals("CK")) {
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
				this.currentPlayer = player;
			}
		}
		
		startGameButton.setOnAction(e -> this.sceneManager.switchToGameView(this.primaryStage));

		leaveButton.setOnAction(e -> {
			this.lobbyController.leaveLobby(this.primaryStage, this.lobby.id.toString());
		});
<<<<<<< HEAD
		
		labelLobbyID.setTranslateX(600);
		labelLobbyID.setTranslateY(25);
		leaveButton.setTranslateX(120);
		leaveButton.setTranslateY(400);
		startGameButton.setTranslateX(555);
		startGameButton.setTranslateY(400);
=======

		int halfscreenheight = screenHeight / 6 * 4;

		labelLobbyID.setTranslateX(600);
		labelLobbyID.setTranslateY(25);
		leaveButton.setTranslateX(320);
		leaveButton.setTranslateY(halfscreenheight);
		startGameButton.setTranslateX(755);
		startGameButton.setTranslateY(halfscreenheight);
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		this.gPane.setHgap(375);
		this.gPane.setVgap(15);
		this.gPane.setTranslateX(140);
		this.gPane.setTranslateY(100);
		this.gPane.setGridLinesVisible(false);
		
		pane.getChildren().addAll(labelLobbyID, leaveButton, startGameButton, gPane);
		
		return pane;
	}
}
