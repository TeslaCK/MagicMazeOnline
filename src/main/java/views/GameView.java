package views;

import com.google.cloud.firestore.DocumentSnapshot;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import controllers.BoardController;
import controllers.CharacterController;
import controllers.GameController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import models.BoardModel;
import resources.supportingClasses.Buttons;
import resources.supportingClasses.CharacterLocation;
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


    public GameView(Stage primaryStage, GameController gameController) {
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

        Buttons buttons = new Buttons();


        pane.getChildren().add(buttons.buttons());

        return pane;
    }

    /**
<<<<<<< HEAD
     * @param x
     * @param y
     * @param button
=======
     * If a button is clicked it will call this function who notifies the boardcontroller.
     *
     * @param x The x coordinate of the button.
     * @param y The y coordinate of the button.
     * @param button The button that is clicked
>>>>>>> 13af1e31debe90cf945530fcb81d18166654c81f
     * @author Carl Zee
     */
    public static void buttonClicked(int x, int y, Button button) {
        System.out.println("GameView/buttonClicked(" + x + ", " + y + ", " + button.getText() + ")");
        //is character clicked
        //Not yet implemented so temporary fix
        int tempPlayerID = 0;

        BoardController boardController = BoardController.getInstance();
        BoardModel boardModel = BoardModel.getInstance();

        CharacterLocation[] characterLocations = boardModel.getCharacterLocations();
        for (int i = 0; i < characterLocations.length; i++) {
            if (characterLocations[i] != null) {
                if (x == characterLocations[i].getLocation().getX() && y == characterLocations[i].getLocation().getY()) {
                    System.out.println("Character " + characterLocations[i].getCharacterID() + " is clicked!");
                    boardController.characterClicked(i, tempPlayerID);
                }
            }
        }

    }


    //if clicked -> boardController

    //Boardcontorller -> is bezet?
    //character model == bezet
    // op nieuw board lader


    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}