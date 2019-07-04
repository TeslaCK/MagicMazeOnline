package views;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertView {


    public AlertView() {

    }


    public void alert(String text) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Oops!");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
