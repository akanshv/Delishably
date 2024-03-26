import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class javapract1 extends Application {

  
    public static void main(String[] args) {
       launch(args);
    }
    @Override
    public void start (Stage primaryStage)throws Exception
    {
      
       Parent root = FXMLLoader.load(getClass().getResource("styilingpractice.fxml"));
       Scene scene =new Scene(root);
       primaryStage.setScene(scene);
       primaryStage.setTitle("JAVAFX DEMO");
        primaryStage.show();
       
    }
    
}

