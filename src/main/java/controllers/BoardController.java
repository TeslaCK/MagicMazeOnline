package controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.Location;
import views.View;
import resources.supportingClasses.MoveSet;

/**
 * 
 * @author C.K
 */
public class BoardController implements Controller{

    /**
     * Default constructor
     */
    public BoardController() {
    }

    /**
     *
     * @param ds The DocumentSnapshot.
     * @author Carl Zee
     */
    @Override
    public void update(DocumentSnapshot ds) {
        // TODO implement here
    }

    /** This method registrated the oberservers.
     * @param v The view that will be registered.
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        // TODO implement here
    }

    /** This method notifies the CharacterController that which character is clicked by which player.
     * @param playerID This is the id of the player who clicked.
     * @param characterID This is the id of the clicked character.
     * @author Carl Zee
     */
    public void characterClicked(int characterID, int playerID) {
        // TODO implement here
    }

    /** This method sends the character status to the CharacterController.
     * @param characterID This is the id of the character.
     * @param playerID This is the id of the player that clicked on the character, -1 is for no player.
     * @param occupied True for occupied, false if not occupied.
     */
    public void characterStatus(int characterID, int playerID, boolean occupied) {
        //TODO implement here
    }

    /** This will ask the boardModel to calculate the possible moves
     * @author Carl Zee
     * @param characterID The ID of the character that can be moved.
     * @param moveSet The moveSet that will be used in calculating the possible locations.
     * @param startingLocation The starting location.
     */
    public void calculateMoves(int characterID, MoveSet moveSet, Location startingLocation) {
        //TODO implement here
    }

    /** This will update the new location of an character to the firebase.
     * @author Carl Zee
     * @param characterID The character id of the character.
     * @param location The new location.
     */
    public void locationClicked(int characterID, Location location) {
        //TODO implement here
    }

    /** This will update the characterController with the new location of an character.
     * @author Carl Zee
     * @param characterID
     * @param location
     */
    public void characterLocation(int characterID, Location location) {
        //TODO implement here
    }
}
