
 

import java.sql.Connection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javajdbctut1.Javajdbc;

public class piechart extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
          int data[]={8752,8672};
   
        {
       // int income=Javajdbc.getdetails("Income",data[i]);
        int expense=Javajdbc.getdetails("Expenses",data[0]);
        int profit=Javajdbc.getdetails("profit",data[0]);
       // System.out.println(income);
        System.out.println(expense);
        System.out.println(profit);
        // Creating PieChart Data
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                // insert data
               // new PieChart.Data("Income", income),
                new PieChart.Data("Expenses", expense),
                new PieChart.Data("Profit", profit)
        );

        PieChart pie = new PieChart(pieData);
        pie.setTitle("Pie-Chart");

        Group root = new Group(pie);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Data on Pie-Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}