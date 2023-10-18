package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.LoginScene;
import view.SignupScene;

//This class serves as the controller for the welcome screen of the Data Analytics Hub application.
public class WelcomeController {
	// This method handles the event when the user clicks on the "Sign Up" button.
	@FXML
	public void GoToSignUpHandler(ActionEvent event) throws IOException {
		// Creating a new SignupScene and displaying it in a new stage.
		SignupScene signup = new SignupScene();
		Stage stage = new Stage();
		stage.setTitle(signup.getTitle());
		stage.setScene(signup.getScene());
		stage.show();
		// Closing the current window after opening the signup window.
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	// This method handles the event when the user clicks on the "Login" button.
	@FXML
	public void GoToLoginHandler(ActionEvent event) throws IOException {
		// Creating a new LoginScene and displaying it in a new stage.
		LoginScene login = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(login.getTitle());
		stage.setScene(login.getScene());
		stage.show();
		// Closing the current window after opening the login window.
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}
