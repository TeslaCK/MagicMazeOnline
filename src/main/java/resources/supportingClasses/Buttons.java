package resources.supportingClasses;

import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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


    //Read file method, reads out the file that contains all the positions of the elements on the board.
    public void readFile() {

        try {
            File startingBoard = new File(filePath);
            FileReader fileReader = new FileReader(startingBoard);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            testArr.add(new ArrayList<Integer>());


            String line = null;


            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < testArr.size(); i++) {
                    System.out.println(line);

                }

            }

            bufferedReader.close();
            fileReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Method takes the file that contains elements, and loops through the list.
    public VBox buttons() throws FileNotFoundException {
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();
        HBox hBox7 = new HBox();
        HBox hBox8 = new HBox();
        HBox hBox9 = new HBox();
        HBox hBox10 = new HBox();

        VBox vBox = new VBox();


        try {
            HBox[] hBoxes = new HBox[boardArray.length];
            hBoxes[0] = hBox1;
            hBoxes[1] = hBox2;
            hBoxes[2] = hBox3;
            hBoxes[3] = hBox4;
            hBoxes[4] = hBox5;
            hBoxes[5] = hBox6;
            hBoxes[6] = hBox7;
            hBoxes[7] = hBox8;
            hBoxes[8] = hBox9;
            hBoxes[9] = hBox10;

            for (int y = 0; y < boardArray.length; y++) {
                for (int x = 0; x < boardArray[y].length; x++) {
                    System.out.print(boardArray[y][x] + " ");
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
                System.out.println("\n");

            }


            for (int i = 0; i < hBoxes.length; i++) {
                vBox.getChildren().add(hBoxes[i]);
            }

        } finally {

        }
        return vBox;


    }
}
