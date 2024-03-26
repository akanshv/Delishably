package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javajdbctut1.Javajdbc;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            //Group root=new Group();
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Startpage.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

           // Parent root = FXMLLoader.load(getClass().getResource("Startpage.fxml"));
            //Scene scene = new Scene(root);
            StartController own=loader.getController();
			own.func(scene);
            //primaryStage.setFullScreen(true);

            primaryStage.setScene(scene);
          //  primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        static int StringExists(String test,ArrayList<String>s)
{
  
    if (s.contains(test))
    {
        return 1;
    }

   s.add(test);
    return 0;
}
   public  static void initializemanager()
     {
         System.out.println("in initializemanager");
         Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
         Statement st=Javajdbc.get_a_fresh_statement(con);
        try {
            ResultSet rs=st.executeQuery("select * from manager");
            Javajdbc.allmanagerid.addAll(Javajdbc.a_particular_rowtoarray(rs, 1));
        } catch (SQLException ex) {
            System.out.println("Exception in initializemanager");
        }
    
     }
   public  static void initializebranch()
     {
         System.out.println("in initializebranch");
    Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
         Statement st=Javajdbc.get_a_fresh_statement(con);
        try {
            ResultSet rs=st.executeQuery("select * from branch");
            Javajdbc.allbranchid.addAll(Javajdbc.a_particular_rowtoarray(rs, 1));
        } catch (SQLException ex) {
            System.out.println("Exception in initializebranch");
        }
     }
    public static void loadcsv(Connection con)
    {   
        try {
            PreparedStatement st = con.prepareStatement("show tables where Tables_in_oopsproject = ?");
            st.setString(1,"economy");
            ResultSet rs=st.executeQuery();
            if(rs.next()==false)
            {
                  Javajdbc.createtable("economy");
                     Javajdbc.csvtodatabase();
            }
            else
            {
                System.out.println("csvfile is already present");
            }
        } catch (SQLException ex) {
            System.out.println("Excpetion in loadcsv main");
            
        }
        
    }
    public static void initializedetails()
    {
                Connection con=Javajdbc.getConnection("oopsproject", "root", "dhruv");
                Main.loadcsv(con);
                Main.initializebranch();
                Main.initializemanager();
    }
    public static void main(String[] args) {
        Main.initializedetails();

        launch(args);

    }
}



