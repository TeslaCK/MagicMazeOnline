package resources.supportingClasses;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class will read the board.txt files and converts it into an array. Use getBoard() to get the array.
 *
 * @author Carl Zee
 */
public class BoardReader {

    int[][] board;

    /**
     * This is the constructor and will read in the board.
     *
     * @param filePath The path of board txt file that will be used to create this board.
     * @author Carl Zee
     */
    public BoardReader(String filePath) {
        try {
            File tempBoard = new File(filePath);
            FileReader fileReader = new FileReader(tempBoard);
            BufferedReader bufReader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(bufReader);
            int levelHeight = scanner.nextInt();
            int levelWidth = scanner.nextInt();
            this.board = new int[levelHeight][levelWidth];

            for (int y = 0; y < levelHeight; y++) {
                for (int x = 0; x < levelWidth; x++) {
                    board[y][x] = scanner.nextInt();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This is the get method what will give the board.
     *
     * @return Board in int[y][x].
     */
    public int[][] getBoard() {
        return board;
    }
}

