package resources.supportingClasses;

/**
 * @author Carl Zee
 */
public class MoveSet {

    private Move[] moves;
    private int numberOfMOves;

    /**
     * Basic constructor
     *
     * @author Carl Zee
     */
    public MoveSet() {
        numberOfMOves = 0;
    }

    /**
     * This method will add an move to the moveSet.
     *
     * @param move The new move that will be added to the MoveSet
     * @author Carl Zee
     */
    public void addMove(Move move) {
        Move[] newMoves = new Move[this.numberOfMOves + 1];
        for (int i = 0; i < this.numberOfMOves; i++) {
            newMoves[i] = this.moves[i];
        }
        this.numberOfMOves = newMoves.length;
        newMoves[numberOfMOves - 1] = move;
    }

    /**
     * This will return a Move of the respective index.
     *
     * @param index Index of the move that it returns.
     * @return Returns a Move with the respective index.
     * @author Carl Zee
     */
    public Move getMove(int index) {
        if (index >= 0 && index < numberOfMOves) {
            return moves[index];
        }
        return null;
    }

    /**
     * This will return the moves in this moveSet.
     *
     * @return Return the moves in this moveSet
     * @author Carl Zee
     */
    public Move[] getMoves() {
        return moves;
    }

    /**
     * This will return the number of Moves that are in this MoveSet
     *
     * @return The number of Moves in this MoveSet.
     * @author Carl Zee
     */
    public int getNumberOfMoves() {
        return numberOfMOves;
    }

    /**
     * @param totalPlayers The number of moveSets.
     * @author Carl Zee
     */
    public static MoveSet[] initializeStartingMoveSets(int totalPlayers) {
        if (totalPlayers > 1 && totalPlayers < 9) {
            MoveSet[] moveSets = new MoveSet[totalPlayers];
            switch (totalPlayers) {
                case 2:
                    moveSets[0].addMove(Move.moveUp());
                    moveSets[0].addMove(Move.moveRight());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveDown());
                    moveSets[1].addMove(Move.moveLeft());
                    moveSets[1].addMove(Move.moveEscalator());
                    moveSets[1].addMove(Move.moveExplore());
                    return moveSets;
                case 3:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[1].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveDown());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[2].addMove(Move.moveExplore());
                    return moveSets;
                case 4:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[2].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[3].addMove(Move.moveDown());
                    moveSets[3].addMove(Move.moveExplore());
                    return moveSets;
                case 5:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[2].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[3].addMove(Move.moveDown());
                    moveSets[3].addMove(Move.moveExplore());
                    moveSets[4].addMove(Move.moveLeft());
                    return moveSets;
                case 6:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[2].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[3].addMove(Move.moveDown());
                    moveSets[3].addMove(Move.moveExplore());
                    moveSets[4].addMove(Move.moveLeft());
                    moveSets[5].addMove(Move.moveRight());
                    return moveSets;
                case 7:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[2].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[3].addMove(Move.moveDown());
                    moveSets[3].addMove(Move.moveExplore());
                    moveSets[4].addMove(Move.moveLeft());
                    moveSets[5].addMove(Move.moveRight());
                    moveSets[6].addMove(Move.moveDown());
                    return moveSets;
                case 8:
                    moveSets[0].addMove(Move.moveLeft());
                    moveSets[0].addMove(Move.movePortal());
                    moveSets[1].addMove(Move.moveUp());
                    moveSets[2].addMove(Move.moveRight());
                    moveSets[2].addMove(Move.moveEscalator());
                    moveSets[3].addMove(Move.moveDown());
                    moveSets[3].addMove(Move.moveExplore());
                    moveSets[4].addMove(Move.moveLeft());
                    moveSets[5].addMove(Move.moveRight());
                    moveSets[6].addMove(Move.moveDown());
                    moveSets[7].addMove(Move.moveUp());
                    return moveSets;
            }
        }
        System.out.println("Total players isn't between 1 and 9. It is: " + totalPlayers);
        return null;
    }

}
