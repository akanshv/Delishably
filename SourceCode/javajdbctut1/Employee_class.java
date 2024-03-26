package javajdbctut1;

import java.sql.*;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection(String database, String user, String password) {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database, user, password);
//here sonoo is database name, root is username and password 
                System.out.println("connection created....");

            }
        } catch (Exception e) {
            System.out.println("connection not made....");
        }
        return con;
    }
}



public class Employee_class extends  Application {

    private static String database = "projpractice";
    private static String user = "root";
    private static String password = "dhruv";
    private static String tablename="employees";
    private ArrayList<String>column_names_arr;
    public ArrayList<String>column_forwhich_piechart_todraw;
  public void initialize_column_names_arr(ResultSet rs)
  {
      column_names_arr=Javajdbc.get_arrayof_column_names(rs);
  }
    public static ResultSet getresultset(ResultSet rs)
    {
        return rs;
    }
   public void initialize_column_forwhich_piechart_todraw (ArrayList<String>arr)
   {
       for(int i=0;i<arr.size();i++)
       {
           column_forwhich_piechart_todraw.add(arr.get(i));
       }
       
   }
   
   
    @Override
        public void start(Stage stage) throws Exception
        {
            ObservableList<PieChart.Data>piedata=FXCollections.observableArrayList(
            new PieChart.Data("IT ",40)
            );
        }

    public static void main(String args[]) throws Exception
    {
        Connection con = ConnectionProvider.getConnection(database, user, password);
        Statement st = Javajdbc.get_a_fresh_statement(con);
         ResultSet tabledetails = st.executeQuery(Javajdbc.alltablevaluesQuery(tablename));
         launch(args);
        con.close();
    }

   
}
