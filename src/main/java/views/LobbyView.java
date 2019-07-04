package views;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.GameController;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import services.FirebaseService;


public class LobbyView implements View {
    private LobbyController lobbyController;
    private Stage primaryStage;
    private int buttonWidth = 100;
    private int buttonHeight = 25;
    private SceneManager sceneManager;
    private GameController gameController;
    private LobbyModel lobby;
    private PlayerModel currentPlayer;
    private String lobbyDocumentId;
    private Label labelLobbyID;
    private GridPane gPane;
    private boolean confirmationToStart = false;
    private int confirmationTeller = 0;


    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    Image image = new Image("/images/logo.png");


    public LobbyView(Stage primaryStage, LobbyModel lobby, String lobbyDocumentId, GameController gameController, LobbyController lobbyController) {
        this.sceneManager = new SceneManager();
        this.primaryStage = primaryStage;
        this.lobby = lobby;
        this.lobbyDocumentId = lobbyDocumentId;
        this.lobbyController = lobbyController;
        this.gameController = gameController;
        this.lobbyController.setLobbyModel(lobby);
        this.lobbyController.registerObserver(this);
    }

    @Override
    public void update() {

        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                gPane.getChildren().retainAll(gPane.getChildren().get(0));

                labelLobbyID.setText("Lobby id: " + lobby.id.toString());
                labelLobbyID.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

                int y = 0;

                for (PlayerModel player : lobby.players) {
                    Label label = new Label(player.getUsername());
                    Button readyButton = new Button("player ready");

                    if(player.getLobbyConfirmation() == false) {
                        readyButton.setOnAction(e -> lobbyController.aPlayerIsReady(confirmationTeller, player));
                    } else {
                        readyButton.setDisable(true);
                    }

                    int x = 0;
                    gPane.add(label, x, y);
                    x++;
                    gPane.add(readyButton, x, y);
                    y++;
                }


                gPane.setHgap(375);
                gPane.setVgap(15);
                gPane.setTranslateX(140);
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

        bPane.setId("background");

        bPane.setCenter(this.Lobby());

        bPane.setLeft(imageViewleft);
        bPane.setRight(imageViewright);

        return bPane;
    }


    private Pane Lobby() {
        ImageView iv2 = new ImageView();
        Pane pane = new Pane();
        this.labelLobbyID = new Label("loading");
        Button leaveButton = new Button("leave");
        Button startGameButton = new Button("start game");
        leaveButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        startGameButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        this.gPane = new GridPane();

        pane.setMaxSize(750, 500);
        leaveButton.setPrefSize(buttonWidth, buttonHeight);
        startGameButton.setPrefSize(buttonWidth, buttonHeight);

        int y = 0;

        for (PlayerModel player : this.lobby.players) {
            Label label = new Label("");
            Button readyButton = new Button("loading");
            label.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
            readyButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

            int x = 0;
            this.gPane.add(label, x, y);
            x++;
            this.gPane.add(readyButton, x, y);
            y++;
        }

        startGameButton.setOnAction(e -> this.lobbyController.initializeTheGame(this.primaryStage, this.gameController, this.lobbyController));

        leaveButton.setOnAction(e -> {
            this.lobbyController.leaveLobby(this.primaryStage, this.lobby.id.toString(), this.gameController, this.lobbyController);
        });

        labelLobbyID.setTranslateX(600);
        labelLobbyID.setTranslateY(25);
        leaveButton.setTranslateX(120);
        leaveButton.setTranslateY(400);
        startGameButton.setTranslateX(555);
        startGameButton.setTranslateY(400);
        this.gPane.setHgap(375);
        this.gPane.setVgap(15);
        this.gPane.setTranslateX(140);
        this.gPane.setTranslateY(100);
        this.gPane.setGridLinesVisible(false);

        iv2.setImage(image);
        iv2.setFitWidth(500);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(false);//todo tmp off

        pane.getChildren().addAll( labelLobbyID, leaveButton, startGameButton, gPane);

        return pane;
    }
}
