package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.BoardReader;
import resources.supportingClasses.CharacterLocation;
import resources.supportingClasses.Location;
import resources.supportingClasses.MoveSet;
import views.View;

/**
 * This is the boardModel, before you can use it you need to load an board with the loadBoard(filePath) function.
 *
 * @author Carl Zee
 */
public class BoardModel implements Model {

    //The id's of the characters
    private static final int GREENID = 0;
    private static final int PURPLEID = 1;
    private static final int REDID = 2;
    private static final int YELLOWID = 3;

    //See resources/gameBoards/explentationBoard
    private static final int STARTINGLOCATIONGREEN = 3;
    private static final int STARTINGLOCATIONPURPLE = 6;
    private static final int STARTINGLOCATIONGRED = 9;
    private static final int STARTINGLOCATIONYELLOW = 12;

    private static final int TOTALCHARACTERS = 4;


    static BoardModel boardModel;
    int[][] board; //board[y][x]
    CharacterLocation[] characterLocation = new CharacterLocation[TOTALCHARACTERS];

    /**
     * Default Constructor
     *
     * @author Carl Zee
     */
    public BoardModel() {

    }

    /**
     * If you call CharacterModel.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The characterController.
     * @author Carl Zee
     */
    public static BoardModel getInstance() {
        if (boardModel == null) {
            boardModel = new BoardModel();
        }
        return boardModel;
    }

    /**
     * @param v
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        //TODO implement here
    }

    /**
     * @param v
     * @author Carl Zee
     */
    @Override
    public void unregisterObserver(View v) {
        //TODO implement here
    }

    /**
     * This method will load a board in.
     *
     * @param filePath The path of the board file that will be used.
     * @author Carl Zee
     */
    public void loadBoard(String filePath) {
        BoardReader boardReader = new BoardReader(filePath);
        this.board = boardReader.getBoard();
    }

    public void setUpCharacterLocations() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == STARTINGLOCATIONGREEN) {
                    characterLocation[GREENID] = new CharacterLocation(GREENID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONPURPLE) {
                    characterLocation[YELLOWID] = new CharacterLocation(PURPLEID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONGRED) {
                    characterLocation[YELLOWID] = new CharacterLocation(REDID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONYELLOW) {
                    characterLocation[YELLOWID] = new CharacterLocation(YELLOWID, new Location(x, y));
                }
            }
        }
    }

    /**
     * @param ds
     * @author Carl Zee
     */
    @Override
    public void notifyObservers(DocumentSnapshot ds) {
        //TODO implement here
    }

    /**
     * This method will calculate the moves and then it will call askMoves.
     *
     * @param characterID The characterID that the moves will be calculated from
     * @param moveSet     The moveSet with the legal moves
     * @author Carl Zee
     */
    public void calculateMoves(int characterID, MoveSet moveSet) {
        Location[] locations;


        //TODO implement here
        // askMoves(locations);
    }

    /**
     * This method will ask the destination from the boardView.
     *
     * @param locations All the possible legal locations.
     * @author Carl Zee
     */
    public void askMoves(Location[] locations) {
        //TODO implement here;
    }

    /**
     * Returns true if the location is free, false if the location isn't free.
     *
     * @return True if there is no character on that location, false if otherwise.
     * @author Carl Zee
     */
    public boolean locationIsFree(Location location) {
        for (int i = 0; i < TOTALCHARACTERS; i++) {
            if (characterLocation[i] != null) {
                if (characterLocation[i].getLocation().equals(location)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method will set the character on an location and will send an update to the views.
     *
     * @param characterID The characterID that will be on location
     * @param location    The new location of characterID
     */
    private void updateCharacterLocation(int characterID, Location location) {
        characterLocation[characterID].setLocation(location);
        //TODO update the views.
    }
}
