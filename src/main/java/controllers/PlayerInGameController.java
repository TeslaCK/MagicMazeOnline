package controllers;

import com.google.cloud.firestore.DocumentSnapshot;
import models.PlayerInGameModel;
import resources.supportingClasses.MoveSet;
import services.FirebaseService;
import views.View;

/**
 * This is an additional PlayerController that only works in game.
 *
 * @author Carl Zee
 */
public class PlayerInGameController implements Controller{

    private static PlayerInGameController playerInGameController;
    private PlayerInGameModel playerInGameModel;
    private LobbyController lobbyController;
    private FirebaseService firebaseService;
    private static String pathToCollection = "playerInGame";
    private String documentID;

    /**
     * Constructor
     *
     * @author Carl Zee
     */
    public PlayerInGameController() {
        this.playerInGameModel = PlayerInGameModel.getInstance();
        setUpFireBase();
    }


    /**
     * Set's firebase up for this controller.
     *
     * @author Carl Zee
     */
    private void setUpFireBase() {
        this.lobbyController = LobbyController.getInstance();
        playerInGameModel.setDocumentID(lobbyController.askLobbyModelID());
        this.firebaseService = FirebaseService.getInstance();
        this.documentID = String.valueOf(playerInGameModel.getDocumentID());
        firebaseService.listen(pathToCollection, documentID, this);
    }

    /**
     * This will update the characterModel.
     *
     * @param ds The DocumentSnapshot.
     * @author Carl Zee
     */
    @Override
    public void update(DocumentSnapshot ds) {
        playerInGameModel.notifyObservers(ds);
    }


    @Override
    public void registerObserver(View v) {
        playerInGameModel.registerObserver(v);
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
		return playerInGameModel.getMoveSet(playerID);
	}
}
