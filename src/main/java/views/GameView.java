package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.Controller;
import controllers.GameController;
import controllers.LobbyController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.GameModel;
import models.LobbyModel;
import models.Model;
import shared.Observer;


/**
 * <<<<<<< HEAD
 *
 * @author C.K
 */
public class GameView implements Observer, View {
    //	private Controller gameController;
    private GameController gameController;
    private Stage primaryStage;
    //lijst met players
    //gameboard controller

    public GameView(Stage primaryStage) {
        this.gameController = new GameController();
        this.primaryStage = primaryStage;
    }


    public void update(DocumentSnapshot ds) {
    }


    public Stage loadPrimaryStageWithPane(Stage primaryStage) {
        Scene scene = new Scene(this.createMainPane(), 900, 900);

        primaryStage.setTitle("game");
        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }


    private Pane createMainPane() {
        Pane pane = new Pane();
        //eruit
        PlayerView playerView = new PlayerView();
        BoardView boardView = new BoardView();
//		pane.getChildren().addAll( playerView.playerScoreAndRankingPane(), playerView.playerPane(), boardView.mainBoardPane());
        pane.getChildren().addAll(boardView.mainBoardPane());

        return pane;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
