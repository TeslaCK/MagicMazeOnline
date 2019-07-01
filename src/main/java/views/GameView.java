package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.GameController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import resources.supportingClasses.Buttons;
import shared.Observer;

import java.io.FileNotFoundException;


/**
 * @author C.K
 */
public class GameView implements Observer, View {
    //	private Controller gameController;
    private GameController gameController;
    private Stage primaryStage;
    //lijst met players
    //gameboard controller


//	public GameView(Controller controller) {
//		this.gameController = controller;
//		
//		gameController.registerObserver(this);
//	}


    public GameView(Stage primaryStage) {
        this.gameController = new GameController();
        this.primaryStage = primaryStage;
    }


    public void update(DocumentSnapshot ds) {
    }


    public Stage loadPrimaryStageWithPane(Stage primaryStage) {
        Scene scene = new Scene(this.createMainPane(), 1920, 1080);

        primaryStage.setTitle("game");
        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }


    private Pane createMainPane() {
        Pane pane = new Pane();
        //eruit
        PlayerView playerView = new PlayerView();
        BoardView boardView = new BoardView();
//        , playerView.playerScoreAndRankingPane(), playerView.playerPane(), boardView.mainBoardPane()

        Buttons buttons = new Buttons();
        buttons.readFile();

        try {
            pane.getChildren().add(buttons.buttons());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return pane;
    }


//	private Pane mainPlayersPane() {
//		Pane pane = new Pane();
//
//		pane.setMinSize(1500, 200);
////		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
//
//		pane.setTranslateX(110);
//		pane.setTranslateY(50);
//
//		int translateInt = 10;
//
//		for (int i = 0; i < 5; i++) {
//			Pane playersPane = this.playersPane();
//			playersPane.setTranslateX(translateInt);
//			pane.getChildren().addAll(playersPane);
//			translateInt += 300;
//		}
//
//		return pane;
//	}
//
//
//	private Pane playersPane() {
//		Pane pane = new Pane();
//
//		pane.setMinSize(290, 200);
//		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
//
//		pane.setTranslateX(0);
//		pane.setTranslateY(2.5);
//		//eruit
//		PlayerView playerView = new PlayerView();
//		Pane removeCrystalsFromCaravanPane = playerView.caravanPane();
//		removeCrystalsFromCaravanPane.setTranslateX(150);
//
//		Label playerNameLabel = new Label("player: ");
//		Label playerScoreLabel = new Label("score: ");
//
//		playerNameLabel.setTranslateX(135);
//		playerNameLabel.setTranslateY(-25);
//
//		playerScoreLabel.setTranslateX(35);
//		playerScoreLabel.setTranslateY(-25);
//
//		pane.getChildren().addAll(playerNameLabel, playerScoreLabel, playerView.playedCardsPane(), removeCrystalsFromCaravanPane);
//
//		return pane;
//	}


//	private Pane crystalDepoDecoration() {
//		Pane pane = new Pane();
//		Label crystalIMGLabel = new Label("4 crystal depo imgs");
//
//		pane.setMinSize(600, 400);
//		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
//
//		pane.setTranslateX(50);
//		pane.setTranslateY(300);
//
//		crystalIMGLabel.setTranslateX(235);
//		crystalIMGLabel.setTranslateY(180);
//
//		pane.getChildren().addAll(crystalIMGLabel);
//
//		return pane;
//	}


//	private Pane optionPane() {
//		Pane pane = new Pane();
//		Label optionsLabel = new Label("options img");
//
//		pane.setMaxSize(750, 500);
//
//		pane.setTranslateX(100);
//		pane.setTranslateY(850);
//
//		pane.getChildren().addAll(optionsLabel);
//
//		return pane;
//	}


    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
}
