package views;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author CK
 */
public class LoginView implements View {
    private GameController gameController;
    private LobbyController lobbyController;
    private int buttonHeight = 25;
    private int buttonWidth = 100;
    private double labelWidth = 200;
    private double titleX1 = 200;
    private double titleX2 = 350;
    private Stage primaryStage;
    private SceneManager sceneManager;
    private String password;
    private String username;
    private boolean check;

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    Image image = new Image("/images/logo.png");


    public LoginView(Stage primaryStage) {
        //deze worden verplaatst naar de eerste view straks
        this.primaryStage = primaryStage;
        this.sceneManager = new SceneManager();
        this.gameController = new GameController();
        this.lobbyController = new LobbyController();
    }


    @Override
    public void update() {
    }

    public Stage loadPrimaryStageWithPane(Stage primaryStage) {
        Scene scene = new Scene(this.createMainPane(), screenWidth, screenHeight);

        primaryStage.setTitle("login");
        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }

    private BorderPane createMainPane() {
        BorderPane bPane = new BorderPane();

        ImageView imageViewleft = new ImageView();
        imageViewleft.setImage(new Image("/images/left.png"));

        ImageView imageViewright = new ImageView();
        imageViewright.setImage(new Image("/images/right.png"));

        imageViewleft.setFitHeight(screenHeight);
        imageViewright.setFitHeight(screenHeight);


        bPane.setId("background");

        bPane.setCenter(this.LoginAndRegister());
        // bPane.setBottom();

        bPane.setLeft(imageViewleft);
        bPane.setRight(imageViewright);

        return bPane;
    }


    public VBox LoginAndRegister() {
        // enter username
        Label usernameLbl = new Label("Username:");
        usernameLbl.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        usernameLbl.setFont(Font.font("ARIAL", FontWeight.THIN, 12));
        TextField usernameTxt = new TextField();
        this.username = usernameTxt.getText();

        // enter password
        Label passwordLbl = new Label("Password:");
        passwordLbl.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");
        passwordLbl.setFont(Font.font("ARIAL", FontWeight.THIN, 12));
        PasswordField passwordTxt = new PasswordField();
        this.password = passwordTxt.getText();

        // start gameButton

        Button startLoginButton = new Button("Login");
        startLoginButton.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

        // check box want to register or login
        CheckBox checkBox1 = new CheckBox("Register");
        checkBox1.setStyle("-fx-background-color: #CCCCFF; -fx-text-fill: white; -fx-font-size: 20;");

        // event handelers

        startLoginButton.setOnAction(e -> this.gameController.manageLoginView(usernameTxt.getText(), passwordTxt.getText(),
                checkBox1.isSelected(), this.primaryStage, this.lobbyController, this.gameController));

        VBox vBox = new VBox();
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();

        vBox.setId("window");

        usernameTxt.setMaxSize(labelWidth, buttonHeight);
        passwordTxt.setMaxSize(labelWidth, buttonHeight);
        startLoginButton.setPrefSize(buttonWidth, 25);

        vBox.setMaxSize(1120, 592);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);

        startLoginButton.setTranslateX(500);

        usernameLbl.setTranslateX(titleX1);

        usernameTxt.setTranslateX(titleX2);

        passwordLbl.setTranslateX(titleX1);

        passwordTxt.setTranslateX(titleX2);

        checkBox1.setTranslateX(titleX1);


        // ObservableList list =
        hBox.getChildren().addAll(startLoginButton);
        hBox1.getChildren().addAll(usernameLbl, usernameTxt);
        hBox2.getChildren().addAll(passwordLbl, passwordTxt);
        vBox.getChildren().addAll(hBox1, hBox2, checkBox1, hBox);
        ObservableList list1 = hBox.getChildren();
        return vBox;
    }
}
