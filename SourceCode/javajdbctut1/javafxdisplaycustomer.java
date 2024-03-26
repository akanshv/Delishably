package javajdbctut1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class javafxdisplaycustomer extends Application {

    String getusername;
    String getpassword;
    boolean flag_for_calling_stage2=false;

    public Stage createstage1() {
        Stage primarystage = new Stage();
        primarystage.setTitle("Welcome!");
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 682, 384);
        // grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        //  grid.setPadding(new Insets(25,25,25,25));

        Label title = new Label("MY Caffee");
        title.setId("title");
        Label username = new Label("User name");

        TextField usernamefield = new TextField();
        usernamefield.setPromptText("Username");

        usernamefield.setFocusTraversable(false);

        Label password = new Label("Password");

        PasswordField passwordfield = new PasswordField();
        passwordfield.setPromptText("Enter Password");
        passwordfield.setFocusTraversable(false);

        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("fancy-button");

        final Label actionText = new Label();
        loginButton.setOnMouseEntered(new EventHandler() {

            @Override
            public void handle(Event t) {
                loginButton.setCursor(Cursor.HAND);

            }

        });
        loginButton.setOnAction((ActionEvent t) -> {
            actionText.setTextFill(Color.AQUA);
            actionText.setText("Authenticating request...");
            getusername = usernamefield.getText();
            getpassword = passwordfield.getText();
            System.out.println(getusername);
            System.out.println(getpassword);
                           // stageimplement();

            System.out.println("Login button pressed..");
        });

        loginButton.setOnMouseExited(new EventHandler() {

            @Override
            public void handle(Event t) {
                loginButton.setEffect(null);
            }

        });
        Button cancel = new Button("Cancel");
        cancel.getStyleClass().add("fancy-button");
        cancel.setOnMouseEntered(new EventHandler() {

            @Override
            public void handle(Event t) {
                cancel.setCursor(Cursor.HAND);
            }

        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                actionText.setTextFill(Color.AQUAMARINE);
                System.out.println("Exit button pressed...");
                actionText.setText("Exit Button Pressed");

                Platform.exit();
            }

        });
        cancel.setOnMouseExited(new EventHandler() {

            @Override
            public void handle(Event t) {
                cancel.setEffect(null);
            }

        });

        HBox hboxButtons = new HBox(20);
        hboxButtons.setAlignment(Pos.BOTTOM_RIGHT);
        hboxButtons.getChildren().addAll(loginButton, cancel);

        grid.add(title, 2, 0, 1, 1);
        grid.add(username, 0, 1, 2, 1);
        grid.add(usernamefield, 2, 1, 1, 1);
        grid.add(password, 0, 2, 2, 1);
        grid.add(passwordfield, 2, 2, 1, 1);
        grid.add(hboxButtons, 2, 4, 1, 1);
        grid.add(actionText, 0, 6, 2, 1);

        scene.getStylesheets().add("javajdbctut1/stylesheet.css");
        primarystage.setScene(scene);
           return primarystage;
    }

    
    @Override
    public void start(Stage primarystage) throws Exception {
        primarystage = createstage1();
       // primarystage=setscene2();
        primarystage.show();
  
    }

    public static void main(String args[]) {
        launch(args);
       
    }

  

}
