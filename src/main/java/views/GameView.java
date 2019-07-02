package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.GameController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import resources.supportingClasses.Buttons;
import shared.Observer;

import java.io.FileNotFoundException;


/**
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
        Scene scene = new Scene(this.createMainPane(), 1920, 1080);

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

        Buttons buttons = new Buttons();


        pane.getChildren().add(buttons.buttons());



        return pane;
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}