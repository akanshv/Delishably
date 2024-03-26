
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class javafxtut6 extends Application implements EventHandler<ActionEvent>{

    public static void main(String args[])throws Exception
    {   
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn =new Button("Click me");
        StackPane root =new StackPane();
        root.getChildren().add(btn);
        Scene scene=new Scene(root,300,300);
        primaryStage.setTitle("first Window");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setOnAction(e->
                {
                    display();
                });
       // btn.setOnAction(this);
                
        
    }

    @Override
    public void handle(ActionEvent event) {
        display();
       Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             closeWindow(stage);
    }

    void display() {
      Stage  newStage=new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        Button btnclose=new Button("Close");
        HBox hb=new HBox();
        hb.getChildren().add(btnclose);
        Scene scene=new Scene(hb,300,300);
        newStage.setScene(scene);
        newStage.show();
               newStage.setOnCloseRequest(e->{
           closeWindow(newStage); 
        });
        
    }

   void closeWindow(Stage newStage) {
       System.out.println("Window closed");
       newStage.close();
    }
    
}
