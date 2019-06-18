package models;

import com.google.cloud.firestore.DocumentSnapshot;
import views.View;

public class CharacterModel implements Model {


    /**
     * Default constructor
     * @author Carl Zee
     */
    public CharacterModel(){
    }

    /**
     * @author Carl Zee
     * @param v
     */
    @Override
    public void registerObserver(View v) {
        //TODO implement here
    }

    /**
     * @author Carl Zee
     * @param ds
     */
    @Override
    public void notifyObservers(DocumentSnapshot ds) {
        //TODO implement here
    }

    /**
     * @author Carl Zee
     * @param v
     */
    @Override
    public void unregisterObserver(View v) {
        //TODO implement here
    }
}
