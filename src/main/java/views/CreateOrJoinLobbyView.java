package views;

import com.google.cloud.firestore.DocumentSnapshot;

import configurations.Database;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.LobbyModel;

/**
 *
 * @author C.K
 */
public class CreateOrJoinLobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
	private SceneManager sceneManager;
	

	public CreateOrJoinLobbyView(Stage primaryStage) {
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
        
        primaryStage.setTitle("Create or join a lobby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        return primaryStage;
	}

	BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
		
		bPane.setCenter(this.createOrJoinLobby());
		
		return bPane;
	}

	private VBox createOrJoinLobby() {
		Button joinButton = new Button("join");
		Button createButton = new Button("create");
		VBox vBox = new VBox();
        
		joinButton.setOnAction(e -> this.sceneManager.switchToJoinLobbyView(this.getPrimaryStage()));
		createButton.setOnAction(e -> this.lobbyController.createLobby(this.primaryStage));
		
		joinButton.setPrefSize(100, 25);
		createButton.setPrefSize(100, 25);
		vBox.setMaxSize(750, 500);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(50);
		vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		
		ObservableList list = vBox.getChildren();
		list.addAll(joinButton, createButton);
		
		return vBox;
	}
}
