
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
public class formjavafx extends Application {

  
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
