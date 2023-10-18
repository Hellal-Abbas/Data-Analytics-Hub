package controller;

import java.io.IOException;
import java.util.Objects;

import database.CheckTableExist;
import database.CreateTable;
import database.InsertRow;
import helpers.DataExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.LoginScene;
import view.WelcomeScene;

//This class serves as the controller for the signup screen of the Data Analytics Hub application.
public class SignupController {

	@FXML
	private TextField firstnameField, lastnameField, usernameField, passwordField;

	@FXML
	private Label missingFirstnameOutput;

	@FXML
	private Label missingLastnameOutput;

	@FXML
	private Label missingUsernameOutput;

	@FXML
	private Label missingPasswordOutput;

	@FXML
	private Label existingUserOutput;

	// Event handler method for the "Go Back" button.
	@FXML
	public void goBackHandler(ActionEvent event) throws IOException {
		// Creating a WelcomeScene and displaying it when the "Go Back" button is
		// clicked.
		WelcomeScene welcomeScene = new WelcomeScene();
		Stage stage = new Stage();
		stage.setTitle(welcomeScene.getTitle());
		stage.setScene(welcomeScene.getScene());
		stage.show();
		// Closing the current window (signup screen) after displaying the welcome
		// screen.
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	// Event handler method for the "Signup" button.
	@FXML
	public void SignupHandler(ActionEvent event) throws IOException {
		// Checking if the 'Users' table exists in the database. If not, create the
		// table.
		if (CheckTableExist.CheckUsers() == false) {
			CreateTable.UsersTable();
		}
		// Retrieving user input from the firstname, lastname, username, and password
		// fields.
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();
		String username = usernameField.getText();
		String password = passwordField.getText();
		// Validating user input for missing fields.
		if (firstname.trim().isEmpty()) {
			missingFirstnameOutput.setText("Missing!");
		} else {
			missingFirstnameOutput.setText("");
		}
		// Validating user input for missing fields.
		if (lastname.trim().isEmpty()) {
			missingLastnameOutput.setText("Missing!");
		} else {
			missingLastnameOutput.setText("");
		}
		// Validating user input for missing fields.
		if (username.trim().isEmpty()) {
			missingUsernameOutput.setText("Missing!");
		} else {
			missingUsernameOutput.setText("");
		}
		// Validating user input for missing fields.
		if (password.trim().isEmpty()) {
			missingPasswordOutput.setText("Missing!");
		} else {
			missingPasswordOutput.setText("");
		}
		// Checking if the entered username already exists in the database.
		String UsernameExists = DataExists.usernameExists(username);
		// Handling existing username scenario.
		if (Objects.equals(username, UsernameExists) == true) {
			existingUserOutput.setText("Username Taken!");
			// If the username is unique, proceed with user signup.
		} else if (Objects.equals(username, UsernameExists) == false) {
			existingUserOutput.setText("");
			// Validating that all fields are filled before proceeding with the sign up.
			if ((firstname.trim().isEmpty() == false) && (lastname.trim().isEmpty() == false)
					&& (username.trim().isEmpty() == false) && (password.trim().isEmpty() == false)) {
				// Inserting the new user into the 'Users' table in the database.
				InsertRow.InsertUser(firstname, lastname, username, password);
				// Redirecting to the login screen after successful sign up.
				LoginScene login = new LoginScene();
				Stage stage = new Stage();
				stage.setTitle(login.getTitle());
				stage.setScene(login.getScene());
				stage.show();
				// Closing the current window (signup screen) after displaying the login screen.
				((Node) (event.getSource())).getScene().getWindow().hide();
			}
		}
	}
}