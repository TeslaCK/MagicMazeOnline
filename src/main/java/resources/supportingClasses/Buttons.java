package resources.supportingClasses;

import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import models.BoardModel;
import models.CharacterModel;
import views.GameView;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * @author Tessa
 */

public class Buttons {
    //2D array List
    List<List<Integer>> testArr = new ArrayList<List<Integer>>();

    private final int CHARACTERIDGREEN = 10;

    //The id's of the characters
    private static final int GREENID = 0;
    private static final int PURPLEID = 1;
    private static final int REDID = 2;
    private static final int YELLOWID = 3;

    private static final String GREENCHARACTERSTYLE = "-fx-background-color: #00FF00; ";
    private static final String PURPLECHARACTERSTYLE = "-fx-background-color: #FF00FF; ";
    private static final String REDCHARACTERSTYLE = "-fx-background-color: RED; ";
    private static final String YELLOWCHARACTERSTYLE = "-fx-background-color: YELLOW; ";


    private final String TILESTYLEGROUND = "-fx-background-color: #FFE5CC; ";
    private final String TILESTYLEDOOR = "-fx-background-color: #FFB266; ";
    private final String TILESTYLEWALL = "-fx-background-color: #994C00; ";
    private static final String TILESTYLEITEMGREEN = "-fx-background-color: #99FF99; ";
    private final String TILESTYLEEXITGREEN = "-fx-background-color: #00FF00; ";

    private final String IMAGEGROUNDPATH = "src\\main\\java\\resources\\images\\groundTile.jpg";

    private final String IMAGEWALLPATH = "images\\wallTile.jpg";

    private final String IMAGEEXITPURPLEPATH = "images\\groundExitPurple.jpg";

    private final String BOARDPATH = "src\\main\\java\\resources\\gameBoards\\startingBoard1.txt";
    private final String CHARACTERSPATH = "src\\main\\java\\resources\\gameBoards\\startingCharacters1.txt";

    private String filePath = "src\\main\\java\\resources\\gameBoards\\startingBoard1.txt";

    private BoardModel boardModel;

    private BoardReader boardReader = new BoardReader(filePath);
    int[][] boardArray = boardReader.getBoard();

    public Buttons() {
        boardModel = BoardModel.getInstance();
        boardModel.loadBoard(BOARDPATH);
        boardModel.setUpCharacterLocations(CHARACTERSPATH);
    }


    //Method takes the file that contains elements, and loops through the list.
    public VBox buttons() {
        VBox vBox = new VBox();
        HBox[] hBoxes = new HBox[boardArray.length];
//        Image imageGround;
//        imageGround = new Image(getClass().getResourceAsStream(IMAGEGROUNDPATH));


        for (int i = 0; i < boardArray.length; i++) {
            hBoxes[i] = new HBox();
        }
        for (int y = 0; y < boardArray.length; y++) {
            for (int x = 0; x < boardArray[y].length; x++) {
                Button tempButton;
                switch (boardArray[y][x]) {
                    case 0:
                        tempButton = new Button("0");
                        tempButton.setStyle(TILESTYLEGROUND);
                        tempButton.setId(x + " " + y + " " + "0");
//                        GameView.buttonClicked(x, y, tempButton.getText())
                        tempButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                String idButton = tempButton.getId();
                                Scanner scanner = new Scanner(idButton);
                                GameView.buttonClicked(scanner.nextInt(), scanner.nextInt(), tempButton);
                            }
                        });
                        int isCharacter = isCharacter(x, y);
                        if (isCharacter != -1) {
                            switch (isCharacter) {
                                case GREENID:
                                    tempButton.setStyle(GREENCHARACTERSTYLE);
                                    break;
                                case PURPLEID:
                                    tempButton.setStyle(PURPLECHARACTERSTYLE);
                                    break;
                                case REDID:
                                    tempButton.setStyle(REDCHARACTERSTYLE);
                                    break;
                                case YELLOWID:
                                    tempButton.setStyle(YELLOWCHARACTERSTYLE);
                                    break;
                            }
                        }

//                        tempButton.setGraphic(new ImageView(imageGround));
                        break;
                    case 1:
                        tempButton = new Button("1");
                        tempButton.setStyle(TILESTYLEDOOR);
                        break;
                    case 2:
                        tempButton = new Button("2");
                        tempButton.setStyle(TILESTYLEWALL);
                        break;
                    case 3:
                        tempButton = new Button("3");
                        break;
                    case 4:
                        tempButton = new Button("4");
                        tempButton.setStyle(TILESTYLEITEMGREEN);
                        break;
                    case 5:
                        tempButton = new Button("5");
                        tempButton.setStyle(TILESTYLEEXITGREEN);
                        break;
                    default:
                        tempButton = new Button("-1");
                        break;
                }
                hBoxes[y].getChildren().add(tempButton);
            }
        }
        for (int i = 0; i < hBoxes.length; i++) {
            vBox.getChildren().add(hBoxes[i]);
        }
        return vBox;
    }


    private int isCharacter(int x, int y) {
        CharacterLocation[] characterLocations = boardModel.getCharacterLocations();
        for (int i = 0; i < boardModel.getCharacterLocations().length; i++) {
            System.out.println("CharacterID: " + boardModel.getCharacterLocations()[i].getCharacterID() +
                    "\n x: " + boardModel.getCharacterLocations()[i].getLocation().getX() +
                    "\n y: " + boardModel.getCharacterLocations()[i].getLocation().getY());
        }
        for (int i = 0; i < characterLocations.length; i++) {
            System.out.println("i = " + i);
            if (characterLocations[i] != null) {
                System.out.println("characterLocations[" + i + "] != null");
                if (x == characterLocations[i].getLocation().getX() && y == characterLocations[i].getLocation().getY()) {
                    System.out.println("return characterLocation[" + i + "].getCharacterID(): " + characterLocations[i].getCharacterID());
                    return characterLocations[i].getCharacterID();
                }
            }
        }
        return -1;
    }
}
