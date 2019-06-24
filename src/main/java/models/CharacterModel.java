package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.Location;
import views.View;

public class CharacterModel implements Model {

    static CharacterModel characterModel;

    public CharacterModel() {
    }

    /**
     * If you call CharacterModel.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The characterController.
     * @author Carl Zee
     */
    public static CharacterModel getInstance() {
        if (characterModel == null) {
            characterModel = new CharacterModel();
        }
        return characterModel;
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
     * @param ds
     * @author Carl Zee
     */
    @Override
    public void notifyObservers(DocumentSnapshot ds) {
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
     * This method will call updateCharacterModel to update the status to the parameters.
     *
     * @param characterID The new characterID
     * @param playerID The new PlayerID
     * @param occupied True for occupied, false for isn't occupied.
     */
    public void characterStatus(int characterID, int playerID, boolean occupied) {
        updateCharacterModel(characterID, playerID, occupied);
    }

    /**
     * This will notify that there is an update in the characterModel.
     *
     * @param characterID The id of the character to update
     * @param playerID    The id of the player that has the character, -1 for no player
     * @param occupied    True for occupied, false for not occupied
     * @author Carl Zee
     */
    public void updateCharacterModel(int characterID, int playerID, boolean occupied) {
        // TODO implement here
        updateCharacterModel(characterID, playerID, occupied);
    }

    /**
     * This will notify the observers that an character is occupied.
     *
     * @param characterID The character that is occupied.
     * @author Carl Zee
     */
    public void displayCharacterOccupied(int characterID) {
        //TODO implement here
    }

    /**
     * This will notify the observers that a character has moved.
     *
     * @param characterID The id of the character that is moved.
     * @param location    The new location of the character.
     * @author Carl Zee
     */
    public void updateCharacterLocation(int characterID, Location location) {
        //TODO implement here
    }
}
