package resources.supportingClasses;

import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Tessa
 */

public class Buttons {
    //2D array List
    List<List<Integer>> testArr = new ArrayList<List<Integer>>();

    private final String TILESTYLEGROUND = "-fx-background-color: #FFE5CC; ";
    private final String TILESTYLEDOOR = "-fx-background-color: #FFB266; ";
    private final String TILESTYLEWALL = "-fx-background-color: #994C00; ";
    private static final String TILESTYLEITEMGREEN = "-fx-background-color: #99FF99; ";
    private final String TILESTYLEEXITGREEN = "-fx-background-color: #00FF00; ";

    private String filePath = "src\\main\\java\\resources\\gameBoards\\startingBoard1.txt";
    private BoardReader boardReader = new BoardReader(filePath);
    int[][] boardArray = boardReader.getBoard();


    //Method takes the file that contains elements, and loops through the list.
    public VBox buttons() {
        VBox vBox = new VBox();
        HBox[] hBoxes = new HBox[boardArray.length];
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
}
