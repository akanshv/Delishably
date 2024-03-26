package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class managerController {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	public void manageEmployee(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageEmployee.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();	
	}
	// Event Listener on RadioButton.onAction
//	@FXML
//	public void manageStore(ActionEvent event) throws IOException {
//		FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageStore.fxml"));
//		root=loader.load();
//		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//		 scene = new Scene(root);
//		 stage.setScene(scene);
//	 stage.show();	
//	}
	// Event Listener on RadioButton.onAction
	@FXML
	public void manageEconomy(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageEconomy.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();	
	}
	// Event Listener on Button.onAction
	@FXML
	public void logout(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("option.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
                  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stage.setScene(scene);
		 stage.show();	
	}
}
