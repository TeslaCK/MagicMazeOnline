package resources.supportingClasses;

/**
 * This class has a characterID and a location.
 *
 * @author Carl Zee
 */
public class CharacterLocation {
    private int characterID;
    private Location location;

    /**
     * This is the constructor.
     *
     * @param characterID The id of the character.
     * @param location The location of the character.
     * @author Carl Zee
     */
    public CharacterLocation(int characterID, Location location) {
        this.characterID = characterID;
        this.location = location;
    }

    /**
     * This will set the character to a new location.
     *
     * @param location The new location of the Character.
     * @author Carl Zee
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * This wil get the id of the character.
     *
     * @return Returns characterID.
     */
    public int getCharacterID() {
        return characterID;
    }

    /**
     * This will get the Location of the Character.
     *
     * @return Returns location.
     */
    public Location getLocation() {
        return location;
    }
}
