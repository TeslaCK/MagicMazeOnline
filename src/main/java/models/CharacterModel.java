package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.Location;
import views.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Carl Zee
 */
public class CharacterModel implements Model {

    //The id's of the characters
    private static final int GREENID = 0;
    private static final int PURPLEID = 1;
    private static final int REDID = 2;
    private static final int YELLOWID = 3;

    private static final int ISNOTOCCUPIED = -1;

    private List<View> observers = new ArrayList<View>();
    static CharacterModel characterModel;

    // <characterID, playerID> if occupied, <characterID, ISNOTOCCUPIED> if it isn't occupied
    private HashMap<Integer, Integer> characters;

    /**
     * Constructor
     *
     * @author Carl Zee
     */
    public CharacterModel() {
        characters = new HashMap<>();
        // This will initialise all the characters and they aren't occupied.
        characters.put(GREENID, ISNOTOCCUPIED);
        characters.put(PURPLEID, ISNOTOCCUPIED);
        characters.put(REDID, ISNOTOCCUPIED);
        characters.put(YELLOWID, ISNOTOCCUPIED);
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
        this.observers.add(v);
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
        this.observers.remove(v);
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
     * This will update this model with the new information and notify that there is an update in the characterModel.
     *
     * @param characterID The id of the character to update
     * @param playerID    The id of the player that has the character, -1 for no player
     * @param occupied    True for occupied, false for not occupied
     * @author Carl Zee
     */
    public void updateCharacterModel(int characterID, int playerID, boolean occupied) {
        if (occupied) {
            characters.replace(characterID, playerID);
        } else {
            characters.replace(characterID, -1);
        }
        //TODO notify the observers that there is an update in the characterModel
    }

    /**
     * Checks if a character is free.
     *
     * @return Returns true if the character isn't occupied by a player, returns false if otherwise.
     * @author Carl Zee
     */
    public boolean isCharacterFree(int characterID) {
        if (characters.get(characterID) == ISNOTOCCUPIED) {
            return true;
        }
        return false;
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
