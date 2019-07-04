package views;

import controllers.GameController;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.LobbyModel;

/**
 * @author CK
 */
public class JoinLobbyView implements View {
    private LobbyController lobbyController;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private LobbyModel lobby;
    private GameController gameController;

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    Image image = new Image("/images/logo.png");

    public JoinLobbyView(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
        this.primaryStage = primaryStage;
        this.gameController = gameController;
        this.lobbyController = lobbyController;
        this.sceneManager = new SceneManager();

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


        bPane.setId("background");

        bPane.setCenter(this.createJoinLobby());

        bPane.setLeft(imageViewleft);
        bPane.setRight(imageViewright);

        return bPane;
    }


    private Pane createJoinLobby() {
        ImageView iv2 = new ImageView();
        Pane pane = new Pane();
        Label labelLobbyID = new Label("Lobby id:");
        labelLobbyID.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        TextField textFieldLobbyID = new TextField();
        Button joinButton = new Button("join");
        Button backButton = new Button("back");

        joinButton.setOnAction(e -> this.lobbyController.joinLobby(primaryStage, textFieldLobbyID.getText(), this.gameController, this.lobbyController));
        backButton.setOnAction(e -> this.sceneManager.changeToCreateOrJoinLobbyView(this.getPrimaryStage(), this.gameController, this.lobbyController));

        joinButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        backButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

        pane.setMaxSize(750, 500);

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

        iv2.setImage(image);
        iv2.setFitWidth(500);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(false);//todo tmp off

        pane.getChildren().addAll(iv2, labelLobbyID, textFieldLobbyID, joinButton, backButton);

        return pane;
    }


    public void eventJoinLobby() {

    }
}
