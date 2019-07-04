package resources.supportingClasses;


import com.sun.xml.internal.bind.v2.TODO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import models.BoardModel;
import views.GameView;

import java.util.ArrayList;
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
    private final int GREENID = 0;
    private final int PURPLEID = 1;
    private final int REDID = 2;
    private final int YELLOWID = 3;

    //Character styles
    private final String GREENCHARACTERSTYLE = "-fx-background-color: #00FF00; ";
    private final String PURPLECHARACTERSTYLE = "-fx-background-color: #FF00FF; ";
    private final String REDCHARACTERSTYLE = "-fx-background-color: #FF0000; ";
    private final String YELLOWCHARACTERSTYLE = "-fx-background-color: #FFFF00; ";

    //Tile styles
    private final String TILESTYLEGROUND = "-fx-background-color: #FFE5CC; ";
    private final String TILESTYLEDOOR = "-fx-background-color: #FFB266; ";
    private final String TILESTYLEWALL = "-fx-background-color: #994C00; ";
    private final String TILESTYLEITEMGREEN = "-fx-background-color: #99FF99; ";
    private final String TILESTYLEEXITGREEN = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEITEMPURPLE = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEEXITPURPLE = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEITEMRED = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEEXITRED = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEITEMYELLOW = "-fx-background-color: #00FF00; ";
    private final String TILESTYLEEXITYELLOW = "-fx-background-color: #00FF00; ";

    /*
    TODO @Tessa
    Buttons mogen iets groter       -> Button resize
    Afbeeldingen                    -> Afbeeldingen toevoegen aan buttons
    Kan worden ingedrukt lijntje    -> Clickable buttons zichbaarder maken door bijv en randje

     */

    //Path of the gameBoard and characterLocations
    private final String BOARDPATH = "src\\main\\java\\resources\\gameBoards\\startingBoard1.txt";
    private final String CHARACTERSPATH = "src\\main\\java\\resources\\gameBoards\\startingCharacters1.txt";

    //This needs a boardModel to load the board and characters
    private BoardModel boardModel;


    /**
     * Constructor
     *
     * @author Carl Zee
     */
    public Buttons() {
        boardModel = BoardModel.getInstance();
        boardModel.loadBoard(BOARDPATH);
        boardModel.setUpCharacterLocations(CHARACTERSPATH);
    }


    /**
     * This will create a VBOX with a button for each tile of the board.
     * The buttons will call GameView.buttonClicked(x, y, button) when there are clicked.
     *
     * @return Returns a VBox with a button for each boardTile
     * @author Carl Zee & Tessa van de Wolf
     */
    public VBox buttons() {
        //initialises variables
        VBox vBox = new VBox();
        int[][] boardArray = boardModel.getBoard();
        HBox[] hBoxes = new HBox[boardArray.length];
        for (int i = 0; i < boardArray.length; i++) {
            hBoxes[i] = new HBox();
        }
        //This will add an button for each coordinate of the board.
        for (int y = 0; y < boardArray.length; y++) {
            for (int x = 0; x < boardArray[y].length; x++) {
                Button tempButton;


                switch (boardArray[y][x]) {
                    case 0:
                        tempButton = new Button("0");
                        tempButton.setStyle(TILESTYLEGROUND);
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
                        break;
                    case 1:
                        tempButton = new Button("1");
                        tempButton.setStyle(TILESTYLEDOOR);

                        break;
                    case 2:
                        tempButton = new Button("2");
                        tempButton.setStyle(TILESTYLEWALL);
                        break;
                    case 4:
                        tempButton = new Button("4");
                        tempButton.setStyle(TILESTYLEITEMGREEN);
                        break;
                    case 5:
                        tempButton = new Button("5");
                        tempButton.setStyle(TILESTYLEEXITGREEN);
                        break;
                    case 7:
                        tempButton = new Button("7");
                        tempButton.setStyle(TILESTYLEITEMPURPLE);
                    case 8:
                        tempButton = new Button("8");
                        tempButton.setStyle(TILESTYLEEXITPURPLE);
                    case 10:
                        tempButton = new Button("10");
                        tempButton.setStyle(TILESTYLEITEMRED);
                    case 11:
                        tempButton = new Button("11");
                        tempButton.setStyle(TILESTYLEEXITRED);
                    case 13:
                        tempButton = new Button("13");
                        tempButton.setStyle(TILESTYLEITEMYELLOW);
                    case 14:
                        tempButton = new Button("14");
                        tempButton.setStyle(TILESTYLEEXITYELLOW);
                    default:
                        tempButton = new Button("-1");
                        break;
                }

                //stores the coordinates
                tempButton.setId(x + " " + y);
                Button finalTempButton = tempButton;
                tempButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String idButton = finalTempButton.getId();
                        Scanner scanner = new Scanner(idButton);
                        GameView.buttonClicked(scanner.nextInt(), scanner.nextInt(), finalTempButton);
                    }
                });
                hBoxes[y].getChildren().add(tempButton);
            }
        }
        for (int i = 0; i < hBoxes.length; i++) {
            vBox.getChildren().add(hBoxes[i]);
        }

        return vBox;
    }

    /**
     * Checks if there is a character on this location, gives characterID if so and -1 if no character is found.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return Returns -1 if there isn't a character and else it returns the characterID.
     * @author Carl Zee
     */
    private int isCharacter(int x, int y) {
        CharacterLocation[] characterLocations = boardModel.getCharacterLocations();
        for (int i = 0; i < characterLocations.length; i++) {
            if (characterLocations[i] != null) {
                if (x == characterLocations[i].getLocation().getX() && y == characterLocations[i].getLocation().getY()) {
                    return characterLocations[i].getCharacterID();
                }
            }
        }
        return -1;
    }
}
