package views;

import controllers.GameController;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author CK
 */
public class LobbyManagerView implements View {
    private LobbyController lobbyController;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private GameController gameController;

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    Image image = new Image("/images/logo.png");



    public LobbyManagerView(Stage primaryStage, GameController gameController, LobbyController lobbyController) {
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

        primaryStage.setTitle("create/join");
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

        bPane.setCenter(this.mainLobbyManager());

        bPane.setLeft(imageViewleft);
        bPane.setRight(imageViewright);

        return bPane;
    }


    private VBox mainLobbyManager() {


        Button joinButton = new Button("Join a game");
        Button createButton = new Button("Create a game");

        ImageView iv2 = new ImageView();

        VBox vBox = new VBox();



        joinButton.setOnAction(e -> this.sceneManager.changeToJoinLobbyView(this.getPrimaryStage(), this.gameController, this.lobbyController));
        createButton.setOnAction(e -> this.lobbyController.createLobby(this.primaryStage, this.gameController, this.lobbyController));

        joinButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        createButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

        joinButton.setPrefSize(200, 50);
        createButton.setPrefSize(200, 50);
        vBox.setMaxSize(750, 500);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);

        iv2.setImage(image);
        iv2.setFitWidth(500);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(false);//todo tmp off

        ObservableList list = vBox.getChildren();
        list.addAll(iv2, joinButton, createButton);

        return vBox;
    }
}
