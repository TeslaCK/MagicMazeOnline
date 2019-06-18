package controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import views.View;

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
}