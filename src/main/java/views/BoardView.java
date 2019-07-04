package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.GameController;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.GameModel;
import models.LobbyModel;
import shared.Observer;


/**
 * @author CK
 */
public class BoardView implements View {
    private Stage primaryStage;
    private GameController gameController;
    private GameModel gameModel;


    public BoardView(Stage primaryStage, GameController gameController) {
        this.primaryStage = primaryStage;
        this.gameController = gameController;
        this.gameModel = this.gameController.gameModel;
    }


    @Override
    public void update() {
    }


    Pane mainBoardPane() {
        Pane pane = new Pane();

        pane.setMinSize(1050, 400);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        pane.setTranslateX(750);
        pane.setTranslateY(300);

        pane.getChildren().addAll();

        return pane;
    }


}
