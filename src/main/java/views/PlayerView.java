package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.PlayerController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import models.LobbyModel;
import shared.Observer;

/**
 *
 * @author C.K
 */

public class PlayerView implements Observer, View {
	private PlayerController playerController;


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

	Pane playerPane() {
		Pane pane = new Pane();
		
		pane.setMinSize(450, 200);
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

		pane.setTranslateX(200);
		pane.setTranslateY(250);
		
		pane.getChildren().addAll();
		
		return pane;
	}


	public Pane playerScoreAndRankingPane() {
		Pane pane = new Pane();
		Label score = new Label("score: ");
		Label ranking = new Label("ranking: ");
		
		pane.setMaxSize(750, 500);
		
		pane.setTranslateX(1600);
		pane.setTranslateY(850);
		
		ranking.setPadding(new Insets(0,0,0,150));
		
		pane.getChildren().addAll(score, ranking);
		
		return pane;
	}
}
