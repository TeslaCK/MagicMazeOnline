package controllers;


import com.google.cloud.firestore.DocumentSnapshot;
import models.CharacterModel;
import resources.supportingClasses.Location;
import services.FirebaseService;
import views.View;
import resources.supportingClasses.MoveSet;


/**
 * @author Carl Zee
 */
public class CharacterController implements Controller {

    static CharacterController characterController;
    private CharacterModel characterModel;
    private BoardController boardController;
    private PlayerInGameController playerInGameController;
    private LobbyController lobbyController;
    private FirebaseService firebaseService;
    private String documentID;
    private String pathToCollection = "character";

    /**
     * Constructor
     */
    private CharacterController() {
<<<<<<< HEAD
        initialiseVariables();
    }

    public CharacterController(BoardController boardController) {
        this.boardController = boardController;
        this.characterModel = CharacterModel.getInstance();
        this.playerInGameController = PlayerInGameController.getInstance();
    }

    /**
     * Fix for getInstance()
     *
     * @author Carl Zee
     */
    public void initialiseVariables() {
=======
>>>>>>> 13af1e31debe90cf945530fcb81d18166654c81f
        this.characterModel = CharacterModel.getInstance();
        this.boardController = BoardController.getInstance();
        this.playerInGameController = PlayerInGameController.getInstance();
        this.lobbyController = LobbyController.getInstance();
        setUpFireBase();
    }

    /**
     * Extra contructor that will be called from the BoardController
     *
     * @param boardController This will be the boardController
     */
    public CharacterController(BoardController boardController) {
        this.characterModel = CharacterModel.getInstance();
        this.playerInGameController = PlayerInGameController.getInstance();
        this.boardController = boardController;
        this.lobbyController = LobbyController.getInstance();
        setUpFireBase();
    }


    /**
     * Set's firebase up for this controller.
     *
     * @author Carl Zee
     */
    private void setUpFireBase() {
        characterModel.setDocumentID(lobbyController.askLobbyModelID());
        this.firebaseService = FirebaseService.getInstance();
        this.documentID = String.valueOf(characterModel.getDocumentID());
        firebaseService.listen(pathToCollection, documentID, this);
    }


    /**
     * If you call CharacterController.getInstance() it guarantees there is only 1 instance.
     * It gives you the existing boardController or else it makes a new one.
     *
     * @return The characterController.
     * @author Carl Zee
     */
    public static CharacterController getInstance() {
        if (characterController == null) {
            characterController = new CharacterController();
        }
        return characterController;
    }


    /**
     * This will update the characterModel.
     *
     * @param ds The DocumentSnapshot.
     * @author Carl Zee
     */
    @Override
    public void update(DocumentSnapshot ds) {
        System.out.println("CharacterModel gets an update.");
        this.characterModel.notifyObservers(ds);
    }

    /**
     * This method registered the observers.
     *
     * @param v The view that will be registered.
     * @author Carl Zee
     */
    @Override
    public void registerObserver(View v) {
        characterModel.registerObserver(v);
    }

    /**
     * If the character is occupied it that and if if the character isn't occupied it will set the character on occupied.
     *
     * @param characterID
     * @param playerID
     */
    public void characterClicked(int characterID, int playerID) {
        if (isCharacterOccupied(characterID)) {
            displayCharacterOccupied(characterID);
        } else {
            characterOccupiedToFB(characterID, true);
        }
    }


    /**
     * This method checks if the character is already occupied by a player.
     *
     * @param characterID This is the character that will be checked.
     * @author Carl Zee
     */
    private boolean isCharacterOccupied(int characterID) {
        if (characterModel.isCharacterFree(characterID)) {
            return true;
        };
        return false;
    }

    /**
     * This method can change the occupied status of the character.
     * It will change it in the FireBase data.
     *
     * @param characterID The character that will be changed.
     * @param occupied    True for occupied and false for not occupied.
     */
    public void characterOccupiedToFB(int characterID, boolean occupied) {
        // TODO implement here
    }

    /**
     * This method sends the character status to the CharacterModel and calls askMoveSet.
     *
     * @param characterID This is the id of the character.
     * @param playerID    This is the id of the player that clicked on the character, -1 is for no player.
     * @param occupied    True for occupied, false if not occupied.
     */
    public void characterStatus(int characterID, int playerID, boolean occupied) {
        characterModel.characterStatus(characterID, playerID, occupied);
        askMoveSet(characterID, playerID);
    }

    /**
     * This will get the moveSet that playerID may use and will ask the BoardController to calculate the moves.
     *
     * @param characterID The id of the character where the moves will be calculated from.
     * @param playerID The id of the player that it get's the moveSet from.
     * @author Carl Zee
     */
    public void askMoveSet(int characterID, int playerID) {
        MoveSet moveSet = playerInGameController.askMoveSet(playerID);
        boardController.calculateMoves(characterID, moveSet);
    }

    /**
     * This will ask the boardController to calculate the possible moves
     *
     * @param characterID The ID of the character that can be moved.
     * @param moveSet     The moveSet that will be used in calculating the possible locations.
     * @author Carl Zee
     */
    public void calculateMoves(int characterID, MoveSet moveSet) {
        boardController.calculateMoves(characterID, moveSet);
    }

    /**
     * This method will ask the CharacterModel to display that the character is occupied.
     *
     * @param characterID The character that is occupied.
     * @author Carl Zee
     */
    private void displayCharacterOccupied(int characterID) {
        characterModel.displayCharacterOccupied(characterID);
    }

    /**
     * This will update the characterModel with the new location of an character.
     *
     * @param characterID
     * @param location
     * @author Carl Zee
     */
    public void characterLocation(int characterID, Location location) {
        boardController.characterLocationToFB(characterID, location);
    }
}