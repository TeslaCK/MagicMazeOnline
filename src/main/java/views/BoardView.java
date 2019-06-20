package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.BoardController;
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
 * @author C.K
 */
public class BoardView implements Observer, View {

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }


    Pane mainBoardPane() {
        Pane pane = new Pane();

        pane.setMinSize(300, 300);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        pane.setTranslateX(300);
        pane.setTranslateY(300);

//        pane.getChildren().addAll(this.golemCardBoardPane(), this.actionCardBoardPane());

        return pane;
    }
}
