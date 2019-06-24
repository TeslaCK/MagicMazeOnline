package controllers;

import com.google.cloud.firestore.DocumentSnapshot;

import shared.Observable;
import views.View;

/**
 *
 * @author C.K
 */
public interface Controller {
	public void update(DocumentSnapshot ds);
	public void registerObserver(View v);
}
