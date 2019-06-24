package views;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import models.LobbyModel;
import resources.supportingClasses.Buttons;
import shared.Observer;

import java.io.FileNotFoundException;


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


//
//    private Pane golemCardBoardPane() {
//        Pane pane = new Pane();
//
//        pane.setMinSize(1050, 200);
////		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
//
//        pane.setTranslateX(150);
//        pane.setTranslateY(10);
//
//        int translateInt = 10;
//        //eruit
//        PlayerView playerView = new PlayerView();
//        for (int i = 0; i < 6; i++) {
//            //Pane playedCardsPaneV = playerView.playedCardsPane();
//            //playedCardsPaneV.setTranslateX(translateInt);
//            //pane.getChildren().addAll(playedCardsPaneV);
//            translateInt += 150;
//        }
//
//        return pane;
//    }


//    private Pane actionCardBoardPane() {
//        Pane pane = new Pane();
//
//        pane.setMinSize(1050, 200);
////		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
//
//        pane.setTranslateX(0);
//        pane.setTranslateY(200);
//
////		int translateInt = 10;
////		//eruit
////		PlayerView playerView = new PlayerView();
////		for (int i = 0; i < 7; i++) {
////			Pane playedCardsPaneV = playerView.playedCardsPane();
////			playedCardsPaneV.setTranslateX(translateInt);
////			pane.getChildren().addAll(playedCardsPaneV);
////			translateInt += 150;
////		}
//
//        return pane;
//    }
}
