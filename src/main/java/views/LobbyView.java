package views;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import controllers.SceneManager;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
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
	private int buttonWidth = 200;
	private int buttonHeight = 50;
	private SceneManager sceneManager;
	LobbyModel lobby;
	PlayerModel currentPlayer;
	String lobbyDocumentId;
	Label labelLobbyID;
	GridPane gPane;

	int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();


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
					label.setStyle("-fx-font-size: 20;");
					readyButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
					int x = 0;
					gPane.add(label, x, y);
					x++;
					gPane.add(readyButton, x, y);
					y++;
					
					if (player.getUsername().equals("CK")) {
						currentPlayer = player;
					}
				}
				
				gPane.setHgap(375);
				gPane.setVgap(15);
				gPane.setTranslateX(360);
				gPane.setTranslateY(100);
				gPane.setGridLinesVisible(false);
			}
		});
	}


	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	

	public Stage loadPrimaryStageWithPane(Stage primaryStage) { 
		this.primaryStage = primaryStage;
		Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);
        primaryStage.setTitle("lobby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
		return primaryStage;
	}
	

	BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
		ImageView imageViewleft = new ImageView();
		imageViewleft.setImage(new Image("/images/left.png"));

		ImageView imageViewright = new ImageView();
		imageViewright.setImage(new Image("/images/right.png"));

		imageViewleft.setFitHeight(screenHeight);
		imageViewright.setFitHeight(screenHeight);

		bPane.setLeft(imageViewleft);
		bPane.setCenter(this.Lobby());
		bPane.setRight(imageViewright);
		return bPane;
	}
	

	private Pane Lobby() {
		Pane pane = new Pane();
		this.labelLobbyID = new Label("Lobby id: " + this.lobby.id);
		Button leaveButton = new Button("leave");
		Button startGameButton = new Button("start game");
		this.gPane = new GridPane();

		pane.setMaxSize(screenWidth, screenHeight);
		//pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		//pane.setBackground(new Background(new BackgroundFill(Color.rgb(40, 40, 40), CornerRadii.EMPTY, Insets.EMPTY)));
		leaveButton.setPrefSize(buttonWidth, buttonHeight);
		startGameButton.setPrefSize(buttonWidth, buttonHeight);

		leaveButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
		startGameButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

		int y = 0;
		
		for (PlayerModel player: this.lobby.players) {
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
				this.currentPlayer = player;
			}
		}
		
		startGameButton.setOnAction(e -> this.sceneManager.switchToGameView(this.primaryStage));

		leaveButton.setOnAction(e -> {
			this.lobbyController.leaveLobby(this.primaryStage, this.lobby.id.toString());
		});
		int halfscreenheight = screenHeight / 6 * 4;

		labelLobbyID.setTranslateX(600);
		labelLobbyID.setTranslateY(25);
		leaveButton.setTranslateX(320);
		leaveButton.setTranslateY(halfscreenheight);
		startGameButton.setTranslateX(755);
		startGameButton.setTranslateY(halfscreenheight);
		this.gPane.setHgap(375);
		this.gPane.setVgap(15);
		this.gPane.setTranslateX(140);
		this.gPane.setTranslateY(100);
		this.gPane.setGridLinesVisible(false);
		
		pane.getChildren().addAll(labelLobbyID, leaveButton, startGameButton, gPane);
		
		return pane;
	}
}
