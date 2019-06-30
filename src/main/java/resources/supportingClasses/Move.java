package resources.supportingClasses;

/**
 * This class has one variable and that is direction.
 * The directions are: UP, RIGHT, DOWN, LEFT, ESCALATOR, PORTAL and EXPLORE.
 *
 * @author Carl Zee
 */
public class Move {

    private String direction;

    /**
     * Default constructor
     *
     * @author Carl Zee
     */
    private Move(String direction) {
        this.direction = direction;

    }

    /**
     * This makes a move with the direction up.
     *
     * @return Returns a Move with the direction up.
     * @author Carl Zee
     */
    public static Move moveUp() {
        Move move = new Move("UP");
        return move;
    }


    /**
     * This makes a move with the direction right.
     *
     * @return Returns a Move with the direction right
     * @author Carl Zee
     */
    public static Move moveRight() {
        Move move = new Move("RIGHT");
        return move;
    }

    /**
     * This makes a move with the direction down.
     *
     * @return Returns a Move with the direction down.
     * @author Carl Zee
     */
    public static Move moveDown() {
        Move move = new Move("DOWN");
        return move;
    }

    /**
     * This makes a move with the direction left.
     *
     * @return Returns a Move with the direction left.
     * @author Carl Zee
     */
    public static Move moveLeft() {
        Move move = new Move("Left");
        return move;
    }

    /**
     * This makes a move with the direction escalator.
     *
     * @return Returns a Move with the direction escalator
     * @author Carl Zee
     */
    public static Move moveEscalator() {
        Move move = new Move("ESCALATOR");
        return move;
    }

    /**
     * This makes a move with the direction portal.
     *
     * @return Returns a Move with the direction portal.
     * @author Carl Zee
     */
    public static Move movePortal() {
        Move move = new Move("Portal");
        return move;
    }

    /**
     * This makes a move with the direction explore.
     *
     * @return Returns a Move with the direction explore.
     * @author Carl Zee
     */
    public static Move moveExplore() {
        Move move = new Move("EXPLORE");
        return move;
    }

    public String getDirection() {
        return direction;
    }
}
