package controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.Location;
import views.View;
import resources.supportingClasses.MoveSet;


/**
 *
 * @author Carl Zee
 */
public class CharacterController implements Controller{

    /**
     * Default constructor
     */
    public CharacterController() {
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

    /** This method checks if the character is already occupied by a player.
     * @param characterID This is the character that will be checked.
     * @author Carl Zee
     */
    public boolean isCharacterOccupied(int characterID) {
        // TODO implement here
        return true;    //TODO
    }

    /** This method can change the occupied status of the character.
     * It will change it in the FireBase data.
     * @param characterID The character that will be changed.
     * @param occupied True for occupied and false for not occupied.
     */
    public void characterOccupied(int characterID, boolean occupied) {
        // TODO implement here
    }

    /** This method sends the character status to the CharacterModel.
     * @param characterID This is the id of the character.
     * @param playerID This is the id of the player that clicked on the character, -1 is for no player.
     * @param occupied True for occupied, false if not occupied.
     */
    public void characterStatus(int characterID, int playerID, boolean occupied) {
        //TODO implement here
    }

    /** This will get the moveSet that playerID may use.
     * @author Carl Zee
     * @param playerID The id of the player that it get's the moveSet from.
     */
	public MoveSet askMoveSet(int playerID) {
		//TODO implement here
		return null;
	}

    /** This will ask the boardController to calculate the possible moves
     * @author Carl Zee
     * @param characterID The ID of the character that can be moved.
     * @param moveSet The moveSet that will be used in calculating the possible locations.
     * @param x The x coördinate from the starting location.
     * @param y The y coördinate from the starting location.
     */
    public void calculateMoves(int characterID, MoveSet moveSet, int x, int y) {
        //TODO implement here
    }

    /** This method will ask the CharacterModel to display that the character is occupied.
     * @author Carl Zee
     * @param CharacterID The character that is occupied.
     */
    public void displayCharacterOccupied(int CharacterID){
        //TODO implement here
    }

    /** This will update the characterModel with the new location of an character.
     * @author Carl Zee
     * @param characterID
     * @param location
     */
    public void characterLocation(int characterID, Location location) {
        //TODO implement here
    }
}