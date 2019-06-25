package views;

<<<<<<< HEAD
=======
import controllers.SceneManager;
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.LobbyModel;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.LobbyController;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author C.K
 */

public class LoginOrRegisterView implements View{
<<<<<<< HEAD
	private LobbyController lobbyController;
	private int buttonHeight=25;
	private int buttonWidth=100;
	
	
=======
	private int buttonHeight=25;
	private int buttonWidth=100;
	private LobbyController lobbyController;
	private Stage primaryStage;
	private SceneManager sceneManager;

	public LoginOrRegisterView(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.sceneManager = new SceneManager();
		this.lobbyController = new LobbyController();
	}


>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
	public void update() {
	}
	
	public Stage loadPrimaryStageWithPane(Stage primaryStage) {
	    Scene scene = new Scene(this.createMainPane(), 1920, 1080);
	    
	    primaryStage.setTitle("Create or join a lobby");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    return primaryStage;
	}
	
	private BorderPane createMainPane() {
		BorderPane bPane = new BorderPane();
		
		bPane.setCenter(this.createOrJoinLobby());
	//				bPane.setBottom();
		
		return bPane;
	}
	
	private VBox createOrJoinLobby() {
		Button JoinButton = new Button("Join");
		Button HostButton = new Button("Host");
		VBox vBox = new VBox();
	
		JoinButton.setPrefSize(buttonWidth, buttonHeight);
		HostButton.setPrefSize(buttonWidth, buttonHeight);
		vBox.setMaxSize(750, 500);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(50);
		vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
		
		ObservableList list = vBox.getChildren();
		list.addAll(JoinButton, HostButton);
		
		return vBox;
	}
}
	

