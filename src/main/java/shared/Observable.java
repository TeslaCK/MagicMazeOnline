package shared;

import com.google.cloud.firestore.DocumentSnapshot;

import views.View;


/**
 *
 * @author C.K
 */
public interface Observable {
	public void registerObserver(View v);
	public void unregisterObserver(View v);
	public void notifyObservers(DocumentSnapshot ds);
}
