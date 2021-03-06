package views;

import com.google.cloud.firestore.DocumentSnapshot;

import configurations.Database;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.LobbyModel;

import java.io.File;

/**
 *
 * @author C.K
 */
public class CreateOrJoinLobbyView implements View {
	private LobbyController lobbyController;
	private Stage primaryStage;
	private SceneManager sceneManager;

	int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
	int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

	Image image = new Image("/images/logo.png");


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
        Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);

        primaryStage.setTitle("Create or join");
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

		bPane.setCenter(this.createOrJoinLobby());
		bPane.setLeft(imageViewleft);
		bPane.setRight(imageViewright);
		
		return bPane;
	}

	private VBox createOrJoinLobby() {

		Button joinButton = new Button("join");
		Button createButton = new Button("create");
		joinButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
		createButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

		ImageView iv2 = new ImageView();

		VBox vBox = new VBox();

		joinButton.setOnAction(e -> this.sceneManager.switchToJoinLobbyView(this.getPrimaryStage()));
		createButton.setOnAction(e -> this.lobbyController.createLobby(this.primaryStage));

		joinButton.setPrefSize(200, 50);
		createButton.setPrefSize(200, 50);

		iv2.setImage(image);
		iv2.setFitWidth(500);
		iv2.setPreserveRatio(true);
		iv2.setSmooth(true);
		iv2.setCache(false);//todo tmp off

		vBox.setMaxSize(screenWidth, screenHeight);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(50);
		//vBox.setStyle("-fx-background-color: #FFFFFF;");

		ObservableList list = vBox.getChildren();
		list.addAll(iv2, joinButton, createButton);

		return vBox;
	}
}
