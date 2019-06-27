package resources.supportingClasses;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tessa
 */

public class Buttons {
    //2D array List
    List<List<String>> boardArr = new ArrayList<List<String>>();


    //Read file method, reads out the file that contains all the positions of the elements on the board.
    public void readFile() {
        try {
            File startingBoard = new File("C:\\Users\\tessa\\Documents\\MagicMazeOnline\\src\\main\\java\\resources\\gameBoards\\startingBoard.txt");
            FileReader fileReader = new FileReader(startingBoard);
            BufferedReader bufReader = new BufferedReader(fileReader);

            boardArr.add(new ArrayList<String>());

            String line = null;

            while ((line = bufReader.readLine()) != null) {
                for (int i = 0; i < boardArr.size(); i++) {
                    boardArr.get(i).add(line);
                    System.out.println(line);
                }
            }
            bufReader.close();
            fileReader.close();


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    //Method takes the file that contains elements, and loops through the list.
    public GridPane tileButtons() throws FileNotFoundException {
        String imagePath = "C:\\Users\\tessa\\Desktop\\IIPSEN\\img\\tile.jpg";
        GridPane gridPane = new GridPane();

        try {
            FileInputStream input = new FileInputStream(imagePath);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            //for loop to loop through all the elements in the list.
            for(int i = 0; i < boardArr.size(); i++) {
                for (int j = 0; j < boardArr.get(i).size(); j++) {



                    //creating all the buttons
                    Button b1 = new Button(boardArr.get(i).get(j), imageView);
                    Button b2 = new Button(boardArr.get(i).get(j), imageView);
                    Button b3 = new Button(boardArr.get(i).get(j), imageView);
                    Button b4 = new Button(boardArr.get(i).get(j), imageView);
                    Button b5 = new Button(boardArr.get(i).get(j), imageView);
                    Button b6 = new Button(boardArr.get(i).get(j), imageView);
                    Button b7 = new Button(boardArr.get(i).get(j), imageView);
                    Button b8 = new Button(boardArr.get(i).get(j), imageView);
                    Button b9 = new Button(boardArr.get(i).get(j), imageView);
                    Button b10 = new Button(boardArr.get(i).get(j), imageView);

                    //adding the buttons to a grid pane
                    gridPane.add(b1, 0, 0);
                    gridPane.add(b2, 1, 0);
                    gridPane.add(b3, 2, 0);
                    gridPane.add(b4, 3, 0);
                    gridPane.add(b5, 4, 0);
                    gridPane.add(b6, 5, 0);
                    gridPane.add(b7, 6, 0);
                    gridPane.add(b8, 7, 0);
                    gridPane.add(b9, 8, 0);
                    gridPane.add(b10, 9, 0);

                    Button b11 = new Button(boardArr.get(i).get(j), imageView);
                    Button b12 = new Button(boardArr.get(i).get(j), imageView);
                    Button b13 = new Button(boardArr.get(i).get(j), imageView);
                    Button b14 = new Button(boardArr.get(i).get(j), imageView);
                    Button b15 = new Button(boardArr.get(i).get(j), imageView);
                    Button b16 = new Button(boardArr.get(i).get(j), imageView);
                    Button b17 = new Button(boardArr.get(i).get(j), imageView);
                    Button b18 = new Button(boardArr.get(i).get(j), imageView);
                    Button b19 = new Button(boardArr.get(i).get(j), imageView);
                    Button b20 = new Button(boardArr.get(i).get(j), imageView);


                    gridPane.add(b11, 0, 1);
                    gridPane.add(b12, 1, 1);
                    gridPane.add(b13, 2, 1);
                    gridPane.add(b14, 3, 1);
                    gridPane.add(b15, 4, 1);
                    gridPane.add(b16, 5, 1);
                    gridPane.add(b17, 6, 1);
                    gridPane.add(b18, 7, 1);
                    gridPane.add(b19, 8, 1);
                    gridPane.add(b20, 9, 1);

                    Button b21 = new Button(boardArr.get(i).get(j), imageView);
                    Button b22 = new Button(boardArr.get(i).get(j), imageView);
                    Button b23 = new Button(boardArr.get(i).get(j), imageView);
                    Button b24 = new Button(boardArr.get(i).get(j), imageView);
                    Button b25 = new Button(boardArr.get(i).get(j), imageView);
                    Button b26 = new Button(boardArr.get(i).get(j), imageView);
                    Button b27 = new Button(boardArr.get(i).get(j), imageView);
                    Button b28 = new Button(boardArr.get(i).get(j), imageView);
                    Button b29 = new Button(boardArr.get(i).get(j), imageView);
                    Button b30 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b21, 0, 2);
                    gridPane.add(b22, 1, 2);
                    gridPane.add(b23, 2, 2);
                    gridPane.add(b24, 3, 2);
                    gridPane.add(b25, 4, 2);
                    gridPane.add(b26, 5, 2);
                    gridPane.add(b27, 6, 2);
                    gridPane.add(b28, 7, 2);
                    gridPane.add(b29, 8, 2);
                    gridPane.add(b30, 9, 2);

                    Button b31 = new Button(boardArr.get(i).get(j), imageView);
                    Button b32 = new Button(boardArr.get(i).get(j), imageView);
                    Button b33 = new Button(boardArr.get(i).get(j), imageView);
                    Button b34 = new Button(boardArr.get(i).get(j), imageView);
                    Button b35 = new Button(boardArr.get(i).get(j), imageView);
                    Button b36 = new Button(boardArr.get(i).get(j), imageView);
                    Button b37 = new Button(boardArr.get(i).get(j), imageView);
                    Button b38 = new Button(boardArr.get(i).get(j), imageView);
                    Button b39 = new Button(boardArr.get(i).get(j), imageView);
                    Button b40 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b31, 0, 3);
                    gridPane.add(b32, 1, 3);
                    gridPane.add(b33, 2, 3);
                    gridPane.add(b34, 3, 3);
                    gridPane.add(b35, 4, 3);
                    gridPane.add(b36, 5, 3);
                    gridPane.add(b37, 6, 3);
                    gridPane.add(b38, 7, 3);
                    gridPane.add(b39, 8, 3);
                    gridPane.add(b40, 9, 3);

                    Button b41 = new Button(boardArr.get(i).get(j), imageView);
                    Button b42 = new Button(boardArr.get(i).get(j), imageView);
                    Button b43 = new Button(boardArr.get(i).get(j), imageView);
                    Button b44 = new Button(boardArr.get(i).get(j), imageView);
                    Button b45 = new Button(boardArr.get(i).get(j), imageView);
                    Button b46 = new Button(boardArr.get(i).get(j), imageView);
                    Button b47 = new Button(boardArr.get(i).get(j), imageView);
                    Button b48 = new Button(boardArr.get(i).get(j), imageView);
                    Button b49 = new Button(boardArr.get(i).get(j), imageView);
                    Button b50 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b41, 0, 4);
                    gridPane.add(b42, 1, 4);
                    gridPane.add(b43, 2, 4);
                    gridPane.add(b44, 3, 4);
                    gridPane.add(b45, 4, 4);
                    gridPane.add(b46, 5, 4);
                    gridPane.add(b47, 6, 4);
                    gridPane.add(b48, 7, 4);
                    gridPane.add(b49, 8, 4);
                    gridPane.add(b50, 9, 4);

                    Button b51 = new Button(boardArr.get(i).get(j), imageView);
                    Button b52 = new Button(boardArr.get(i).get(j), imageView);
                    Button b53 = new Button(boardArr.get(i).get(j), imageView);
                    Button b54 = new Button(boardArr.get(i).get(j), imageView);
                    Button b55 = new Button(boardArr.get(i).get(j), imageView);
                    Button b56 = new Button(boardArr.get(i).get(j), imageView);
                    Button b57 = new Button(boardArr.get(i).get(j), imageView);
                    Button b58 = new Button(boardArr.get(i).get(j), imageView);
                    Button b59 = new Button(boardArr.get(i).get(j), imageView);
                    Button b60 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b51, 0, 5);
                    gridPane.add(b52, 1, 5);
                    gridPane.add(b53, 2, 5);
                    gridPane.add(b54, 3, 5);
                    gridPane.add(b55, 4, 5);
                    gridPane.add(b56, 5, 5);
                    gridPane.add(b57, 6, 5);
                    gridPane.add(b58, 7, 5);
                    gridPane.add(b59, 8, 5);
                    gridPane.add(b60, 9, 5);

                    Button b61 = new Button(boardArr.get(i).get(j), imageView);
                    Button b62 = new Button(boardArr.get(i).get(j), imageView);
                    Button b63 = new Button(boardArr.get(i).get(j), imageView);
                    Button b64 = new Button(boardArr.get(i).get(j), imageView);
                    Button b65 = new Button(boardArr.get(i).get(j), imageView);
                    Button b66 = new Button(boardArr.get(i).get(j), imageView);
                    Button b67 = new Button(boardArr.get(i).get(j), imageView);
                    Button b68 = new Button(boardArr.get(i).get(j), imageView);
                    Button b69 = new Button(boardArr.get(i).get(j), imageView);
                    Button b70 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b61, 0, 6);
                    gridPane.add(b62, 1, 6);
                    gridPane.add(b63, 2, 6);
                    gridPane.add(b64, 3, 6);
                    gridPane.add(b65, 4, 6);
                    gridPane.add(b66, 5, 6);
                    gridPane.add(b67, 6, 6);
                    gridPane.add(b68, 7, 6);
                    gridPane.add(b69, 8, 6);
                    gridPane.add(b70, 9, 6);

                    Button b71 = new Button(boardArr.get(i).get(j), imageView);
                    Button b72 = new Button(boardArr.get(i).get(j), imageView);
                    Button b73 = new Button(boardArr.get(i).get(j), imageView);
                    Button b74 = new Button(boardArr.get(i).get(j), imageView);
                    Button b75 = new Button(boardArr.get(i).get(j), imageView);
                    Button b76 = new Button(boardArr.get(i).get(j), imageView);
                    Button b77 = new Button(boardArr.get(i).get(j), imageView);
                    Button b78 = new Button(boardArr.get(i).get(j), imageView);
                    Button b79 = new Button(boardArr.get(i).get(j), imageView);
                    Button b80 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b71, 0, 7);
                    gridPane.add(b72, 1, 7);
                    gridPane.add(b73, 2, 7);
                    gridPane.add(b74, 3, 7);
                    gridPane.add(b75, 4, 7);
                    gridPane.add(b76, 5, 7);
                    gridPane.add(b77, 6, 7);
                    gridPane.add(b78, 7, 7);
                    gridPane.add(b79, 8, 7);
                    gridPane.add(b80, 9, 7);

                    Button b81 = new Button(boardArr.get(i).get(j), imageView);
                    Button b82 = new Button(boardArr.get(i).get(j), imageView);
                    Button b83 = new Button(boardArr.get(i).get(j), imageView);
                    Button b84 = new Button(boardArr.get(i).get(j), imageView);
                    Button b85 = new Button(boardArr.get(i).get(j), imageView);
                    Button b86 = new Button(boardArr.get(i).get(j), imageView);
                    Button b87 = new Button(boardArr.get(i).get(j), imageView);
                    Button b88 = new Button(boardArr.get(i).get(j), imageView);
                    Button b89 = new Button(boardArr.get(i).get(j), imageView);
                    Button b90 = new Button(boardArr.get(i).get(j), imageView);

                    gridPane.add(b81, 0, 9);
                    gridPane.add(b82, 1, 9);
                    gridPane.add(b83, 2, 9);
                    gridPane.add(b84, 3, 9);
                    gridPane.add(b85, 4, 9);
                    gridPane.add(b86, 5, 9);
                    gridPane.add(b87, 6, 9);
                    gridPane.add(b88, 7, 9);
                    gridPane.add(b89, 8, 9);
                    gridPane.add(b90, 9, 9);

                    Button b91 = new Button(boardArr.get(i).get(j), imageView);
                    Button b92 = new Button(boardArr.get(i).get(j), imageView);
                    Button b93 = new Button(boardArr.get(i).get(j), imageView);
                    Button b94 = new Button(boardArr.get(i).get(j), imageView);
                    Button b95 = new Button(boardArr.get(i).get(j), imageView);
                    Button b96 = new Button(boardArr.get(i).get(j), imageView);
                    Button b97 = new Button(boardArr.get(i).get(j), imageView);
                    Button b98 = new Button(boardArr.get(i).get(j), imageView);
                    Button b99 = new Button(boardArr.get(i).get(j), imageView);
                    Button b100 = new Button(boardArr.get(i).get(j), imageView);


                    gridPane.add(b91, 0, 10);
                    gridPane.add(b92, 1, 10);
                    gridPane.add(b93, 2, 10);
                    gridPane.add(b94, 3, 10);
                    gridPane.add(b95, 4, 10);
                    gridPane.add(b96, 5, 10);
                    gridPane.add(b97, 6, 10);
                    gridPane.add(b98, 7, 10);
                    gridPane.add(b99, 8, 10);
                    gridPane.add(b100, 9, 10);

                    // array of buttons, makes it easier to set things for all the buttons.
                    Button[] buttons = new Button[]{
                            b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
                            b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40,
                            b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, b55, b56, b57, b58, b59, b60,
                            b61, b62, b63, b64, b65, b66, b67, b68, b69, b70, b71, b72, b73, b74, b75, b76, b77, b78, b79, b80,
                            b81, b82, b83, b84, b85, b86, b87, b88, b89, b90, b91, b92, b93, b94, b95, b96, b97, b98, b99, b100
                    };

                    for (Button button : buttons) {
                        button.setMaxSize(50, 50);
                    }
                }
            }
            return gridPane;

        } finally {
        }
    }
}