package controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import views.View;

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
}
