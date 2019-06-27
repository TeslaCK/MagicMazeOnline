package views;

import com.google.cloud.firestore.DocumentSnapshot;

import controllers.BoardController;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
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

import javafx.scene.paint.Color;
import models.LobbyModel;
import shared.Observer;

import java.io.FileNotFoundException;


/**
 *
>>>>>>> c93528c8d51682e57e40e8becd4236f5248db1d9
>>>>>>> origin/devGedoeTessa
 * @author C.K
 */
public class BoardView implements Observer, View {

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }


    Pane mainBoardPane() throws FileNotFoundException {
        Pane pane = new Pane();

        pane.setMinSize(300, 300);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        pane.setTranslateX(300);
        pane.setTranslateY(300);

        Buttons test = new Buttons();
        test.readFile();
        test.tileButtons();
        pane.getChildren().addAll(test.tileButtons());
        return pane;
    }
}
