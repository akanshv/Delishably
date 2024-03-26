package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javajdbctut1.Javajdbc;

public class finalBillController extends Javajdbc {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Label stars;
	@FXML
	private Label amt;
	@FXML
	private Label ph;
	@FXML
	private Label cname;
        @FXML
        private Label payt;

	// Event Listener on Button.onAction
	@FXML
	public void setamount(String amount) {
            System.out.println("in final bill controller employee.amount_finalizer");
            
            int finalamt=Integer.parseInt(amount);
        finalamt= Employee.Amount_Finalizer(finalamt);
                     String branch =Javajdbc.holdbranch;
                   Javajdbc.seteconomy(finalamt,branch);
            
		 amt.setText("Final amount payed: "+finalamt);
                 
		 Integer i=Integer.valueOf(amount);
		 Integer k=i/1000;
	     //stars.setText("Stars earned: "+k);
	}
        public void setpaytype(int paytype) {
            System.out.println("Final Bill paytype is"+paytype);
            
           // int finalamt=Integer.parseInt(amount);
//        finalamt= Employee.Amount_Finalizer(finalamt);
//                   Javajdbc.seteconomy(finalamt);
//            
//		 amt.setText("Final amount payed: "+finalamt);
//                 
//		 Integer i=Integer.valueOf(amount);
//		 Integer k=i/1000;
//	     stars.setText("Stars earned: "+k);;
             String paymentmd;
             if(paytype==0){
                 paymentmd="Cash";
             }
             else if(paytype==1){
                paymentmd="Card"; 
             }
             
             else if(paytype==2){
                paymentmd="Net Banking"; 
             }
             else{
                paymentmd="UPI Payment"; 
             }
             payt.setText("Payment Mode: "+paymentmd);
             //paymentmd ko tum database me insert kara lo
             
	}
	public void setPhone(String phone) {
		 ph.setText("phone number: "+phone);
	}
	public void setName(String name) {
		 cname.setText("Customer Name: "+name);
	}
	
	
	public void returnmenu(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader=new FXMLLoader(getClass().getResource("employee.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void back(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Billpay.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();	
	}
}