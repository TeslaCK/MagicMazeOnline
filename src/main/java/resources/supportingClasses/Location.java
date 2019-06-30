package resources.supportingClasses;

/**
 * @author Carl Zee
 */
public class Location {
    private int x;
    private int y;

    /**
     * The constructor.
     *
     * @param x The x param of the location.
     * @param y The y param of the location.
     * @author Carl Zee
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Checks if a object is equal to a point.
     * @param obj The object that is compared to this
     * @return Return true if obj isn't null, obj is a point and the x and y are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        return (this.x == ((Location) obj).x && this.y == ((Location) obj).y);
    }
}
