package resources.supportingClasses;

/**
 * @author Carl Zee
 */
public class MoveSet {

    private Move[] moves;
    private int numberOfMOves;

    /** Basic constructor
     *
     * @author Carl Zee
     */
    public MoveSet (){
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
     * This will return the moves in this moveSet.
     *
     * @return Return the moves in this moveSet
     * @author Carl Zee
     */
    public Move[] getMoves(){
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
}
