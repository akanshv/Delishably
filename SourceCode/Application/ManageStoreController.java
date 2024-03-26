package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ManageStoreController {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	// Event Listener on RadioButton.onAction
	@FXML
	public void storetiming(ActionEvent event) {
	
	}
	// Event Listener on RadioButton.onAction
	@FXML
	public void store(ActionEvent event) {
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void back(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("manager.fxml"));
		root=loader.load();
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
	 stage.show();	
	}
}
