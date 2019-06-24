package controllers;

import models.PlayerInGameModel;
import resources.supportingClasses.MoveSet;

/**
 * This is an additional PlayerController that only works in game.
 *
 * @author Carl Zee
 */
public class PlayerInGameController {

    static PlayerInGameController playerInGameController;
    PlayerInGameModel playerInGameModel;

    /**
     * Constructor
     */
    private PlayerInGameController() {
        this.playerInGameModel = PlayerInGameModel.getInstance();
    }

    /**
     * If you call CharacterController.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The characterController.
     * @author Carl Zee
     */
    public static PlayerInGameController getInstance() {
        if (playerInGameController == null) {
            playerInGameController = new PlayerInGameController();
        }
        return playerInGameController;
    }


    /**
     * This will get the MoveSet that playerID may use.
     * @param playerID The id of the player that ist get's the MoveSet from.
     * @return The MoveSet
     * @author Carl Zee
     */
    public MoveSet askMoveSet(int playerID) {
        return playerInGameModel.getMoveSet(playerID);
    }


    /** This will get the moveSet that playerID may use.
     * @author Carl Zee
     * @param playerID The id of the player that it get's the moveSet from.
     */
	public MoveSet grabMoveSet(int playerID) {
		//TODO implement here
		return null;
	}
}
