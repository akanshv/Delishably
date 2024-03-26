
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class javafxtut4 extends Application implements EventHandler<ActionEvent>{

   Button btnred,btngreen;
   Scene scene;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws Exception{
        btnred =new Button("Red");
        btngreen=new Button("Green");
        VBox root=new VBox();
        root.getChildren().addAll(btnred,btngreen);
        scene=new Scene(root,300,250);
        primaryStage.setTitle("Java fx application");
        primaryStage.setScene(scene);
        primaryStage.show();
        btnred.setOnAction(this);
        btngreen.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event){
        if(event.getSource()==btnred)
        {   System.out.println(btnred.getText()+"Clicked");
        
        }
        else if(event.getSource()==btngreen)
        {
            System.out.println(btngreen.getText()+"Clicked");
        }
    }
    
}
