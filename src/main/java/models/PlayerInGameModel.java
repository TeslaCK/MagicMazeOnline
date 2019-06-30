package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.MoveSet;
import views.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl Zee
 */
public class PlayerInGameModel implements Model {

    static PlayerInGameModel playerInGameModel;

    private List<View> observers = new ArrayList<View>();
    private int totalPlayers;
    private MoveSet[] moveSets;

    /**
     * Constructor
     *
     * @author Carl Zee
     */
    public PlayerInGameModel() {
        this.totalPlayers = 3;
        //TODO needs to assign movesets
    }


    /**
     * If you call CharacterController.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The characterController.
     * @author Carl Zee
     */
    public static PlayerInGameModel getInstance() {
        if (playerInGameModel == null) {
            playerInGameModel = new PlayerInGameModel();
        }
        return playerInGameModel;
    }

    /**
     * This will swap the MoveSets so that every player has a new moveSet.
     *
     * @author Carl Zee
     */
    public void swapMoveSets() {
        MoveSet temp = moveSets[0];
        for (int i = 0; i < totalPlayers - 1; i++) {
            moveSets[i] = moveSets[i + 1];
        }
        moveSets[totalPlayers - 1] = temp;
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
     * This wil return the MoveSet  of the playerID.
     *
     * @param playerID The id of the player with the required MoveSet
     * @return The MoveSet from playerID
     * @author Carl Zee
     */
    public MoveSet getMoveSet(int playerID) {
        return moveSets[playerID];
    }
}
