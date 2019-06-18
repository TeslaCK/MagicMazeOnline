package models;

import com.google.cloud.firestore.DocumentSnapshot;

import views.View;


/**
 *
 * @author C.K
 */
public interface Model {
	public void registerObserver(View v);
	public void unregisterObserver(View v);
	public void notifyObservers(DocumentSnapshot ds);	
}