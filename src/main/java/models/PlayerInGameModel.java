package models;

import com.google.cloud.firestore.DocumentSnapshot;
import resources.supportingClasses.MoveSet;
import views.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Carl Zee
 */
public class PlayerInGameModel implements Model {

    static PlayerInGameModel playerInGameModel;

    private List<View> observers = new ArrayList<View>();
    private int totalPlayers;
    private HashMap<Integer, MoveSet> moveSets; //<playerID,MoveSet>

    /**
     * Constructor
     *
     * @author Carl Zee
     */
    public PlayerInGameModel() {
        //The standard is now 3, but there is room for some methods what will make a different total
        // players possible (from 2 to 8)
        this.totalPlayers = 3;

        //This will give each player an MoveSet.
        MoveSet[] moveSets = MoveSet.initializeStartingMoveSets(totalPlayers);
        for (int i = 0; i < moveSets.length; i++) {
            this.moveSets.put(i, moveSets[i]);
        }
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
     * @param v
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        this.observers.add(v);
    }


    /**
     * This will load in this DocumentSnapshot and notify all the observers.
     *
     * @param ds The DocumentSnapshot.
     * @author Carl Zee
     */
    @Override
    public void notifyObservers(DocumentSnapshot ds) {
        PlayerInGameModel playerInGameModel = ds.toObject(PlayerInGameModel.class);
        this.setMoveSets(playerInGameModel.getMoveSets());
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }

    /**
     * Getter for moveSets.
     *
     * @return Returns moveSets<integer><integer>.
     * @author Carl Zee
     */
    public HashMap<Integer, MoveSet> getMoveSets() {
        return moveSets;
    }

    /**
     * The setter for moveSets.
     *
     * @param moveSets The new moveSets.
     * @author Carl Zee
     */
    public void setMoveSets(HashMap<Integer, MoveSet> moveSets) {
        if (this.moveSets.size() == moveSets.size()) {
            for (int i = 0; i < moveSets.size(); i++) {
                this.moveSets.replace(i, moveSets.get(i));
            }
        } else {
            System.out.println("models/PlayerInGameModel/setMoveSets: This moveSet isn't the same size.");
        }
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
     * This wil return the MoveSet of the playerID.
     *
     * @param playerID The id of the player with the required MoveSet
     * @return The MoveSet from playerID
     * @author Carl Zee
     */
    public MoveSet getMoveSet(int playerID) {
        return moveSets.get(playerID);
    }
}
