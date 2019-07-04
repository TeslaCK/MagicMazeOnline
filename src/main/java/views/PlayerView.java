package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.google.cloud.firestore.DocumentSnapshot;

import controllers.GameController;
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
import javafx.stage.Stage;
import models.LobbyModel;
import models.PlayerModel;
import shared.Observer;

public class PlayerView implements View {
	private PlayerController playerController;
	private Stage primaryStage;
	private GameController gameController;
	private PlayerModel currentPlayer;
	Label score;

	/**
	 * @author CK
	 */
	public PlayerView(Stage primaryStage, GameController gameController, PlayerModel currentPlayer) {
		this.primaryStage = primaryStage;
		this.gameController = gameController;
		this.currentPlayer = currentPlayer;
	}

	@Override
	public void update() {
	}


	Pane playerPane() {
		Pane pane = new Pane();

		pane.setMinSize(450, 200);
		pane.setBorder(
				new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

		pane.setTranslateX(700);
		pane.setTranslateY(750);

		pane.getChildren().addAll();

		return pane;
	}

	public Pane playerScoreAndRankingPane() {
		Pane pane = new Pane();
		Label score = new Label("score: " + this.currentPlayer.getScore());
		Label currentUsername = new Label("player: " + this.currentPlayer.getUsername());

		pane.setMaxSize(750, 500);

		pane.setTranslateX(1600);
		pane.setTranslateY(850);

		currentUsername.setPadding(new Insets(0, 0, 0, 150));

		pane.getChildren().addAll(score, currentUsername);

		return pane;
	}
}
