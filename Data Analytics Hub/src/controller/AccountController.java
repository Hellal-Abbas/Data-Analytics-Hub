package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import view.AccountDetailsScene;
import view.EditDetailsScene;

//This class serves as the controller for the account-related functionality in the JavaFX application.
public class AccountController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// Creating an instance of AccountDetailsScene and setting it as the initial
		// view in the BorderPane.
		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		try {
			borderpane.setCenter(accountDetailsScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Event handler method for the "Account Details" button.
	@FXML
	public void AccountDetailsHandler(ActionEvent event) throws IOException {
		// Creating an instance of AccountDetailsScene and setting it as the view in the
		// BorderPane.
		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		borderpane.setCenter(accountDetailsScene.getScene());
	}

	// Event handler method for the "Edit Details" button.
	@FXML
	public void EditDetailsHandler(ActionEvent event) throws IOException {
		// Creating an instance of EditDetailsScene and setting it as the view in the
		// BorderPane.
		EditDetailsScene editDetailsScene = new EditDetailsScene();
		borderpane.setCenter(editDetailsScene.getScene());
	}
}