package views;


import com.google.cloud.firestore.DocumentSnapshot;


import controllers.AuthenticationController;
import controllers.GameController;
import controllers.LobbyController;
import controllers.SceneManager;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import models.LobbyModel;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;


/**
 * @author C.K
 */

public class LoginAndRegisterView implements View {

    private LobbyController lobbyController;
    private GameController gameController;
    private AuthenticationController authenticationController;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private int buttonHeight = 25;
    private int buttonWidth = 100;
    private double labelWidth = 200;
    private double titleX1 = 200;
    private double titleX2 = 350;

    public void update() {
    }


    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public LoginAndRegisterView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.sceneManager = new SceneManager();
        this.lobbyController = new LobbyController();
    }

    public Stage loadPrimaryStageWithPane(Stage primaryStage) {
        Scene scene = new Scene(this.createMainPane(), 1920, 1080);

        primaryStage.setTitle("Create or join a lobby");
        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }

    private BorderPane createMainPane() {
        BorderPane bPane = new BorderPane();

        bPane.setCenter(this.createOrJoinLobby());
//		bPane.setBottom();

        return bPane;
    }

    private VBox createOrJoinLobby() {
        //enter username
        Label usernameLbl = new Label("Username:");
        usernameLbl.setFont(Font.font("ARIAL", FontWeight.THIN, 12));
        TextField usernameTxt = new TextField();

        //enter password
        Label passwordLbl = new Label("Password:");
        passwordLbl.setFont(Font.font("ARIAL", FontWeight.THIN, 12));
        PasswordField passwordTxt = new PasswordField();

        //start gameButton
        Button backButton = new Button("Back");
        Button startLoginButton = new Button("Login");


//		startLoginButton.setOnAction(e -> {
//			String valueOfTextField = usernameTxt.getText();
//			this.authenticationController.CheckLogin(this.primaryStage, valueOfTextField);
//		});

        backButton.setOnAction(e -> {
            try {
                this.sceneManager.switchToCreateOrJoinLobbyView(this.getPrimaryStage());
            } catch (FileNotFoundException | MalformedURLException ex) {
                ex.printStackTrace();
            }
        });

        //check box want to register or login
        CheckBox checkBox1 = new CheckBox("Register");
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();

        usernameTxt.setMaxSize(labelWidth, buttonHeight);
        passwordTxt.setMaxSize(labelWidth, buttonHeight);
        startLoginButton.setPrefSize(buttonWidth, 25);
        backButton.setPrefSize(100, 25);
        vBox.setMaxSize(750, 500);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        backButton.setTranslateX(titleX1);

        startLoginButton.setTranslateX(titleX2);

        usernameLbl.setTranslateX(titleX1);

        usernameTxt.setTranslateX(titleX2);

        passwordLbl.setTranslateX(titleX1);

        passwordTxt.setTranslateX(titleX2);

        checkBox1.setTranslateX(titleX1);


        vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));

        //ObservableList list =
        hBox.getChildren().addAll(backButton, startLoginButton);
        hBox1.getChildren().addAll(usernameLbl, usernameTxt);
        hBox2.getChildren().addAll(passwordLbl, passwordTxt);
        vBox.getChildren().addAll(hBox1, hBox2, checkBox1, hBox);
        ObservableList list1 = hBox.getChildren();
        return vBox;
    }
}
	
	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
