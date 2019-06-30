package controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import models.BoardModel;
import resources.supportingClasses.Location;
import views.View;
import resources.supportingClasses.MoveSet;


/**
 * @author C.K
 */
public class BoardController implements Controller {

    static BoardController boardController;
    private BoardModel boardModel;
    private CharacterController characterController;

    /**
     * The Construnctor
     */
    private BoardController() {
        boardController.boardModel = BoardModel.getInstance();
        boardController.characterController = CharacterController.getInstance();
    }

    /**
     * If you call BoardController.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The boardController.
     * @author Carl Zee
     */
    public static BoardController getInstance() {
        if (boardController == null) {
            boardController = new BoardController();
        }
        return boardController;
    }


    /**
     * @param ds The DocumentSnapshot.
     * @author Carl Zee
     */
    @Override
    public void update(DocumentSnapshot ds) {
        // TODO implement here
    }

    /**
     * This method registrate the oberservers.
     *
     * @param v The view that will be registered.
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        boardModel.registerObserver(v);
    }

    /**
     * This method notifies the CharacterController that which character is clicked by which player.
     *
     * @param playerID    This is the id of the player who clicked.
     * @param characterID This is the id of the clicked character.
     * @author Carl Zee
     */
    public void characterClicked(int characterID, int playerID) {
        characterController.characterClicked(characterID, playerID);
    }

    /**
     * This method sends the character status to the CharacterController.
     * TODO a method that calls this when the firebase is updated
     *
     * @param characterID This is the id of the character.
     * @param playerID    This is the id of the player that clicked on the character, -1 is for no player.
     * @param occupied    True for occupied, false if not occupied.
     */
    public void characterStatus(int characterID, int playerID, boolean occupied) {
        characterController.characterStatus(characterID, playerID, occupied);
    }

    /**
     * This will ask the boardModel to calculate the possible moves
     *
     * @param characterID The ID of the character that can be moved.
     * @param moveSet     The moveSet that will be used in calculating the possible locations.
     * @author Carl Zee
     */
    public void calculateMoves(int characterID, MoveSet moveSet) {
        boardModel.calculateMoves(characterID, moveSet);
    }


    /**
     * This will update the new location of an character to the firebase if the location is free, otherwise it will
     * call ask moves again.
     *
     * @param characterID The character id of the character.
     * @param location    The new location.
     * @param locations   The possible locations the character can go.
     * @author Carl Zee
     */
    public void locationClicked(int characterID, Location location, Location[] locations) {
        if (boardModel.locationIsFree(location)) {
            characterLocationToFB(characterID, location);
        } else {
            boardModel.askMoves(locations);
        }
    }

    /**
     * This will update the FireBaseService with the new location of an character.
     *
     * @param characterID
     * @param location
     * @author Carl Zee
     */
    public void characterLocationToFB(int characterID, Location location) {
        //TODO implement here
    }
}