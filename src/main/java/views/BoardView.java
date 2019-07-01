package views;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import models.LobbyModel;
import resources.supportingClasses.Buttons;
import shared.Observer;


import java.io.FileNotFoundException;

/**
 * import javafx.scene.paint.Color;
 * import models.LobbyModel;
 * import shared.Observer;
 * <p>
 * <p>
 * /**
 * <p>
 *
 * @author C.K
 */
public class BoardView implements Observer, View {


    @Override
    public void update() {
        // TODO Auto-generated method stub

    }


    Pane mainBoardPane() {
        Pane pane = new Pane();

        pane.setMinSize(1050, 400);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        pane.setTranslateX(750);
        pane.setTranslateY(300);

        pane.getChildren().addAll(this.golemCardBoardPane(), this.actionCardBoardPane());

        return pane;
    }


    private Pane golemCardBoardPane() {
        Pane pane = new Pane();

        pane.setMinSize(1050, 200);
//		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        pane.setTranslateX(150);
        pane.setTranslateY(10);

        int translateInt = 10;
        //eruit
        PlayerView playerView = new PlayerView();
        for (int i = 0; i < 6; i++) {
            translateInt += 150;
        }

        return pane;
    }


    private Pane actionCardBoardPane() {
        Pane pane = new Pane();

        pane.setMinSize(1050, 200);
        pane.setTranslateX(0);
        pane.setTranslateY(200);


        return pane;
    }
}