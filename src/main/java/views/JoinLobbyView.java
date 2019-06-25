package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import controllers.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
<<<<<<< HEAD
=======
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
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
<<<<<<< HEAD
import javafx.stage.Stage;
import models.LobbyModel;

=======
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.LobbyModel;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9

/**
 *
 * @author C.K
 */
public class JoinLobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
<<<<<<< HEAD
	private SceneManager sceneManager;	
=======
	private SceneManager sceneManager;

	int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

	Image image = new Image("/images/logo.png");
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
	

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
<<<<<<< HEAD
        Scene scene = new Scene(this.createMainPane(), 1920, 1080);
=======
        Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
        
        primaryStage.setTitle("join a lobby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        return primaryStage;
	}
	

	BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
<<<<<<< HEAD
		
		bPane.setCenter(this.createJoinLobby());
=======
		ImageView imageViewleft = new ImageView();
		imageViewleft.setImage(new Image("/images/left.png"));

		ImageView imageViewright = new ImageView();
		imageViewright.setImage(new Image("/images/right.png"));

		imageViewleft.setFitHeight(screenHeight);
		imageViewright.setFitHeight(screenHeight);

		bPane.setCenter(this.createJoinLobby());

		bPane.setLeft(imageViewleft);
		bPane.setRight(imageViewright);
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		
		return bPane;
	}
	

	private Pane createJoinLobby() {
		Pane pane = new Pane();
<<<<<<< HEAD
		Label labelLobbyID = new Label("Lobby id:");
        TextField textFieldLobbyID = new TextField();
		Button joinButton = new Button("join");
		Button backButton = new Button("back");
=======
		Label labelLobbyID = new Label("Lobby ID: ");
        TextField textFieldLobbyID = new TextField();
		Button joinButton = new Button("join");
		Button backButton = new Button("back");

		textFieldLobbyID.setStyle("-fx-text-fill: green; -fx-text-fill: black; -fx-font-size: 20;");
		labelLobbyID.setStyle("-fx-font-size: 20");

>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		
		joinButton.setOnAction(e -> {
			String valueOfTextField = textFieldLobbyID.getText();
			this.lobbyController.joinLobby(this.primaryStage, valueOfTextField);
			});
		
<<<<<<< HEAD
		backButton.setOnAction(e -> this.sceneManager.switchToCreateOrJoinLobbyView(this.getPrimaryStage()));

		pane.setMaxSize(750, 500);
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		textFieldLobbyID.setMaxWidth(200);
		joinButton.setPrefSize(100, 25);
		backButton.setPrefSize(100, 25);
		
		labelLobbyID.setTranslateX(250);
		labelLobbyID.setTranslateY(200);
		textFieldLobbyID.setTranslateX(350);
		textFieldLobbyID.setTranslateY(197);
		backButton.setTranslateX(120);
		backButton.setTranslateY(350);
		joinButton.setTranslateX(555);
		joinButton.setTranslateY(350);
=======
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
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
		
		
		pane.getChildren().addAll(labelLobbyID, textFieldLobbyID, joinButton, backButton);
		
		return pane;
	}
	

	public void eventJoinLobby() {
		
	}
}
