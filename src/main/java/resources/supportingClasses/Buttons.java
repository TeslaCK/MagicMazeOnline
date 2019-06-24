package resources.supportingClasses;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Buttons {

    public HBox tileButtons(String imagePath) throws FileNotFoundException {

        try {

            HBox hbox = new HBox();
            Button button2 = new Button("test2");


            FileInputStream input = new FileInputStream(imagePath);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            Button button = new Button("", imageView);

            hbox.getChildren().addAll(button, button2);

            return hbox;
        } finally {

        }
    }
}


