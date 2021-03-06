package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import controllers.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.LobbyModel;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


/**
 *
 * @author C.K
 */
public class JoinLobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
	private SceneManager sceneManager;

	int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

	Image image = new Image("/images/logo.png");
	

	public JoinLobbyView(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.sceneManager = new SceneManager();
		this.lobbyController = new LobbyController();
	}
	

	public void update() {
		
	}
	
	

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	

	public Stage loadPrimaryStageWithPane(Stage primaryStage) {
		this.primaryStage = primaryStage;
        Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);
        
        primaryStage.setTitle("join a lobby");
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

		bPane.setCenter(this.createJoinLobby());

		bPane.setLeft(imageViewleft);
		bPane.setRight(imageViewright);
		
		return bPane;
	}
	

	private Pane createJoinLobby() {
		Pane pane = new Pane();
		Label labelLobbyID = new Label("Lobby ID: ");
        TextField textFieldLobbyID = new TextField();
		Button joinButton = new Button("join");
		Button backButton = new Button("back");

		textFieldLobbyID.setStyle("-fx-text-fill: green; -fx-text-fill: black; -fx-font-size: 20;");
		labelLobbyID.setStyle("-fx-font-size: 20");

		
		joinButton.setOnAction(e -> {
			String valueOfTextField = textFieldLobbyID.getText();
			this.lobbyController.joinLobby(this.primaryStage, valueOfTextField);
			});
		
		backButton.setOnAction(e -> {
			try {
				this.sceneManager.switchToCreateOrJoinLobbyView(this.getPrimaryStage());
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
		});

		pane.setMaxSize(screenWidth, screenHeight);
		textFieldLobbyID.setMaxWidth(200);
		joinButton.setPrefSize(200, 50);
		backButton.setPrefSize(200, 50);

		joinButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
		backButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");


		labelLobbyID.setTranslateX(450);
		labelLobbyID.setTranslateY(400);
		textFieldLobbyID.setTranslateX(550);
		textFieldLobbyID.setTranslateY(397);
		backButton.setTranslateX(320);
		backButton.setTranslateY(550);
		joinButton.setTranslateX(755);
		joinButton.setTranslateY(550);
		
		
		pane.getChildren().addAll(labelLobbyID, textFieldLobbyID, joinButton, backButton);
		
		return pane;
	}
	

	public void eventJoinLobby() {
		
	}
}
