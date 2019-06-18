package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import controllers.SceneManager;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.LobbyModel;


/**
 *
 * @author C.K
 */
public class JoinLobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
	private SceneManager sceneManager;	
	

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
        Scene scene = new Scene(this.createMainPane(), 1920, 1080);
        
        primaryStage.setTitle("join a lobby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        return primaryStage;
	}
	

	BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
		
		bPane.setCenter(this.createJoinLobby());
		
		return bPane;
	}
	

	private Pane createJoinLobby() {
		Pane pane = new Pane();
		Label labelLobbyID = new Label("Lobby id:");
        TextField textFieldLobbyID = new TextField();
		Button joinButton = new Button("join");
		Button backButton = new Button("back");
		
		joinButton.setOnAction(e -> {
			String valueOfTextField = textFieldLobbyID.getText();
			this.lobbyController.joinLobby(this.primaryStage, valueOfTextField);
			});
		
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
		
		
		pane.getChildren().addAll(labelLobbyID, textFieldLobbyID, joinButton, backButton);
		
		return pane;
	}
	

	public void eventJoinLobby() {
		
	}
}
