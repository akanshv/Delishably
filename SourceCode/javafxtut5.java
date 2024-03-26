
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class javafxtut5 extends Application implements EventHandler<Event> {
    
    
    public static void main(String args[])throws Exception
    {   
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn=new Button("Click Here");
        StackPane root=new StackPane();
        root.getChildren().add(btn);
        Scene scene=new Scene(root,300,250);
        primaryStage.setTitle("javaFxappllication");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setOnAction(e->{
            Button btnback=new Button("Back");
            VBox vb=new VBox();
            vb.getChildren().add(btnback);
            Scene s=new Scene(vb,400,250);
            primaryStage.setScene(s);
            btnback.setOnAction(f->{
                primaryStage.setScene(scene);
            });
        });
    }

    @Override
    public void handle(Event t) {
    }
    
    
}
