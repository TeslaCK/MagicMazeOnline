package views;

import com.google.cloud.firestore.DocumentSnapshot;

<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.scene.layout.*;
=======
import controllers.BoardController;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
>>>>>>> 811d6e06c938d955d0607237896c8b6b68485d86
import javafx.scene.paint.Color;
import models.LobbyModel;
import resources.supportingClasses.Buttons;
import shared.Observer;

<<<<<<< HEAD
import java.io.FileNotFoundException;


=======
>>>>>>> 811d6e06c938d955d0607237896c8b6b68485d86
/**
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






//        try {
//            pane.getChildren().addAll(test.tileButtonsH("C:\\Users\\tessa\\Desktop\\IIPSEN\\img\\tile.jpg"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        pane.getChildren().addAll(this.golemCardBoardPane(), this.actionCardBoardPane());

        return pane;
    }
}
