package nl.game.models;

import java.util.ArrayList;
import java.util.List;

/**
 *@author CK
 * */
public class PlayerModel {
   // public List<View> observers = new ArrayList<View>();
    public int id, score;
    public String username, password;
//    public CaravanCardModel caravan;
//    public List<CardModel> handCards, playedCards;


    public PlayerModel() {
        // TODO Auto-generated constructor stub
    }

//    public void registerObserver(View v) {
//        this.observers.add(v);
//    }
//
//    public void unregisterObserver(View v) {
//        this.observers.remove(v);
//    }
//
//    public void notifyObservers() {
//        for (View o : observers) {
//            o.update();
//        }
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}