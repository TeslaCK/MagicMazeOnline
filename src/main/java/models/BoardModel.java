package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.BoardReader;
import resources.supportingClasses.CharacterLocation;
import resources.supportingClasses.Location;
import resources.supportingClasses.MoveSet;
import views.View;

import java.util.ArrayList;
import java.util.List;

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


    public List<View> observers = new ArrayList<View>();
    static BoardModel boardModel;
    int[][] board; //board[y][x]
    CharacterLocation[] characterLocations = new CharacterLocation[TOTALCHARACTERS];

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
        this.observers.add(v);
    }

    /**
     * @param v
     * @author Carl Zee
     */
    @Override
    public void unregisterObserver(View v) {
        this.observers.remove(v);
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
                    characterLocations[GREENID] = new CharacterLocation(GREENID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONPURPLE) {
                    characterLocations[PURPLEID] = new CharacterLocation(PURPLEID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONGRED) {
                    characterLocations[REDID] = new CharacterLocation(REDID, new Location(x, y));
                }
                if (board[y][x] == STARTINGLOCATIONYELLOW) {
                    characterLocations[YELLOWID] = new CharacterLocation(YELLOWID, new Location(x, y));
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
        List<Location> listLocations = new ArrayList<Location>(1);

        int currentX = characterLocations[characterID].getLocation().getX();
        int currentY = characterLocations[characterID].getLocation().getY();
        int checker;

        // Moving to the current location of the character is a legal move
        listLocations.add(new Location(currentX, currentY));

        //Checks for each direction if there is a possible path.
        for (int i = 0; i < moveSet.getNumberOfMoves(); i++) {
            switch (moveSet.getMove(i).getDirection()) {
                case "UP":
                    for (int y = currentY; y >= 0; y--) {
                        checker = board[y][currentX];
                        if (checker == 0 || checker == 1) {
                            listLocations.add(new Location(currentX, y));
                        }
                    }
                    break;
                case "RIGHT":
                    for (int x = currentX; x <= board[currentY].length; x++) {
                        checker = board[currentY][x];
                        if (checker == 0 || checker == 1) {
                            listLocations.add(new Location(x, currentY));
                        }
                    }
                    break;
                case "DOWN":
                    for (int y = currentY; y <= board.length; y++) {
                        checker = board[y][currentX];
                        if (checker == 0 || checker == 1) {
                            listLocations.add(new Location(currentX, y));
                        }
                    }
                    break;
                case "LEFT":
                    for (int x = currentX; x >= 0; x--) {
                        checker = board[currentY][x];
                        if (checker == 0 || checker == 1) {
                            listLocations.add(new Location(x, currentY));
                        }
                    }
                    break;
                case "ESCALATOR":
                    //TODO
                    break;
                case "PORTAL":
                    //TODO
                    break;
                case "EXPLORE":
                    //TODO
                    break;
            }
        }

        //Converts the list into an Location[]
        Location[] locations = new Location[listLocations.size()];
        locations = listLocations.toArray(locations);
        askMoves(locations);
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
            if (characterLocations[i] != null) {
                if (characterLocations[i].getLocation().equals(location)) {
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
        characterLocations[characterID].setLocation(location);
        //TODO update the views.
    }
}
