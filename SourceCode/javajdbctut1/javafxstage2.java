
package javajdbctut1;


import java.io.IOException;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.lang.Thread;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class javafxstage2 extends Application
{    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("stage2fxml.fxml"));
        stage.setTitle("menu");
        stage.setScene(new Scene(root,300,275));
        stage.show();
        
    }
 
public static void main(String args[])
{
launch(args);
}

}
