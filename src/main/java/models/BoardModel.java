package models;

import com.google.cloud.firestore.DocumentSnapshot;
import com.sun.corba.se.impl.ior.FreezableList;
import controllers.BoardController;
import resources.supportingClasses.Location;
import resources.supportingClasses.MoveSet;
import views.View;

/**
 * @author Carl Zee
 */
public class BoardModel implements Model {

    static BoardModel boardModel;

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
     *
     * @param v
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        //TODO implement here
    }

    /**
     *
     * @param v
     * @author Carl Zee
     */
    @Override
    public void unregisterObserver(View v) {
        //TODO implement here
    }

    /**
     *
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
     * @param moveSet The moveSet with the legal moves
     * @author Carl Zee
     */
    public void calculateMoves(int characterID, MoveSet moveSet) {
        Location[] locations;
        //TODO implement here
        //askMoves(locations);
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
     * @return True if the location is free, false if the location isn't free.
     * @author Carl Zee
     */
    public boolean locationIsFree() {
        return true; //TODO
    }

    /**
     * This method will set the character on an location and will send an update to the views.
     *
     * @param characterID The characterID that will be on location
     * @param location The new location of characterID
     */
    private void updateCharacterLocation(int characterID, Location location) {
        //TODO implement here
    }



}
