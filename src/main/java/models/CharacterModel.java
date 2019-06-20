package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.Location;
import views.View;

public class CharacterModel implements Model {


    /**
     * Default constructor
     * @author Carl Zee
     */
    public CharacterModel(){
    }

    /**
     * @author Carl Zee
     * @param v
     */
    @Override
    public void registerObserver(View v) {
        //TODO implement here
    }

    /**
     * @author Carl Zee
     * @param ds
     */
    @Override
    public void notifyObservers(DocumentSnapshot ds) {
        //TODO implement here
    }

    /**
     * @author Carl Zee
     * @param v
     */
    @Override
    public void unregisterObserver(View v) {
        //TODO implement here
    }

    /** This will notify that there is an update in the characterModel.
     * @author Carl Zee
     * @param characterID The id of the character to update
     * @param playerID The id of the player that has the character, -1 for no player
     * @param occupied True for occupied, false for not occupied
     */
    public void updateCharacterModel(int characterID, int playerID, boolean occupied) {
        //TODO implement here
    }

    /** This will notify the observers that an character is occupied.
     * @author Carl Zee
     * @param characterID The character that is occupied.
     */
    public void displayCharacterOccupied(int characterID){
        //TODO implement here
    }

    /** This will notify the obervers that a character has moved.
     * @author Carl Zee
     * @param characterID The id of the character that is moved.
     * @param location The new location of the character.
     */
    public void updateCharacterLocation(int characterID, Location location) {
        //TODO implement here
    }
}
