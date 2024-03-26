package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class GetfinalBillController extends Employee{
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private TextField name;
	@FXML
	private TextField gender;
	@FXML
	private TextField age;
	@FXML
	private TextField ph_no;
  String amount;
  String ph;
      void func(Scene scene1) {
		    scene=scene1;
		}
	// Event Listener on Button.onAction
	@FXML
	public void back(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("SeeOrder.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();	
	}
	// Event Listener on Button.onAction
	@FXML
	void setamount(String amt) {
           
            
		amount=amt;
	}
	public void apply(ActionEvent event) throws IOException {
		String Name = name.getText();
		//System.out.println(Name);
		String Gender = gender.getText();
		String Age = age.getText();
		 ph = ph_no.getText();
                
                 
                System.out.println("in Get final bill controller employee.holdcustomerdetails is called");
                //calling employee function                             
		Employee.holdcustomerdetails(Name,Gender,Age,ph);
                
                                
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Bill.fxml"));
		root=loader.load();
		BillController own=loader.getController();
		own.setname(Name);
		own.setphone(ph);
		own.setamount(amount);
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();
		///upadte query
	}
}
