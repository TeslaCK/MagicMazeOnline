package resources.supportingClasses;

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
import java.util.List;


/**
 * @author Tessa
 */

public class Buttons {
    //2D array List
    List<List<Integer>> boardArr = new ArrayList<List<Integer>>();
    private int[][] arr = new int[10][10];
    private char[] array = new char[100];


    //Read file method, reads out the file that contains all the positions of the elements on the board.
    public void readFile() {
        try {
            File startingBoard = new File("C:\\Users\\tessa\\Documents\\MagicMazeOnline\\src\\main\\java\\resources\\gameBoards\\startingBoard.txt");
            FileReader fileReader = new FileReader(startingBoard);
            BufferedReader bufReader = new BufferedReader(fileReader);

            boardArr.add(new ArrayList<Integer>());

            String line = null;


            while ((line = bufReader.readLine()) != null) {
                for (int i = 0; i < boardArr.size(); i++) {
                    System.out.println(line);

                }

                try {
                    line.getChars(0, 19, array, 0);
                    System.out.print("Copied Value is ");
                    System.out.println(array);

                } catch (Exception ex) {
                    System.out.println("exeption");

                }
            }

            bufReader.close();
            fileReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        //}


        // }
        //System.out.print("The coppied value is ");
        //System.out.println(array);


    }


    //Method takes the file that contains elements, and loops through the list.
    public VBox tileButtons() throws FileNotFoundException {
        String imagePath = "C:\\Users\\tessa\\Desktop\\IIPSEN\\img\\tile.jpg";

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
            FileInputStream input = new FileInputStream(imagePath);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            //for loop to loop through all the elements in the list.
            for(int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[i].length; j++) {


                    final Button row1 = new Button("" + (arr[i][j]));
                    hBox1.getChildren().add(row1);
                    Button row2 = new Button("" + (arr[i][j]));
                    hBox2.getChildren().add(row2);
                    Button row3 = new Button("" + (arr[i][j]));
                    hBox3.getChildren().add(row3);
                    Button row4 = new Button("" + (arr[i][j]));
                    hBox4.getChildren().add(row4);
                    Button row5 = new Button("" + (arr[i][j]));
                    hBox5.getChildren().add(row5);
                    Button row6 = new Button("" + (arr[i][j]));
                    hBox6.getChildren().add(row6);
                    Button row7 = new Button("" + (arr[i][j]));
                    hBox7.getChildren().add(row7);
                    Button row8 = new Button("" + (arr[i][j]));
                    hBox8.getChildren().add(row8);
                    Button row9 = new Button("" + (arr[i][j]));
                    hBox9.getChildren().add(row9);
                    Button row10 = new Button("" + (arr[i][j]));
                    hBox10.getChildren().add(row10);

                    Button[] buttons = {
                            row1, row2, row3, row4, row5, row6, row7, row8, row9, row10

                    };
                    for (Button button : buttons) {
                        button.setMinWidth(50);
                        button.setMinHeight(50);

                    }


                    if (arr[i][j] == arr[5][5]) {
                        break;
                    }


                }
            vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, hBox10);


        } finally {
        }
        return vBox;


    }
}










