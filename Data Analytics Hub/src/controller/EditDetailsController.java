package controller;

import java.io.IOException;
import java.util.Objects;

import database.DataSingleton;
import database.UpdateTable;
import helpers.DataExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//This class serves as the controller for the functionality related to editing user details in the Data Analytics Hub application.
public class EditDetailsController {

	private String username;

	@FXML
	private TextField firstnameField, lastnameField, usernameField, passwordField;

	@FXML
	private Label firstnameOutput, lastnameOutput, usernameOutput, passwordOutput;
	// Creating an instance of DataSingleton to manage user session data.
	DataSingleton dataSingleton = DataSingleton.getInstance();

	DataAnalyticsHubController dataAnalyticsHubController = new DataAnalyticsHubController();

	// Event handler method for the "Update Details" button.
	@FXML
	public void updateDetailsHandler(ActionEvent event) throws IOException {
		// Retrieving the current user's username from the dataSingleton.
		username = dataSingleton.getUsername();
		// Retrieving user input for firstname, lastname, username, and password fields.
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();
		String AccountUsername = usernameField.getText();
		String password = passwordField.getText();
		// Checking if the new username already exists in the database.
		String UsernameExists = DataExists.usernameExists(AccountUsername);
		// Checking if the firstname field is empty. If not, updating the firstname in
		// the database.
		if (Objects.equals(firstname, "") == true) {
			firstnameOutput.setText("");
		} else if ((Objects.equals(firstname, "") == false)) {
			UpdateTable.UpdateUserDetails("firstname", firstname, username);
			firstnameOutput.setText("Updated!");
		}
		// Checking if the lastname field is empty. If not, updating the lastname in the
		// database.
		if (Objects.equals(lastname, "") == true) {
			lastnameOutput.setText("");
		} else if ((Objects.equals(lastname, "") == false)) {
			UpdateTable.UpdateUserDetails("lastname", lastname, username);
			lastnameOutput.setText("Updated!");
		}
		// Checking if the username field is empty.
		if (Objects.equals(AccountUsername, "") == true) {
			usernameOutput.setText("");
		} else if (Objects.equals(AccountUsername, "") == false) {
			if ((Objects.equals(AccountUsername, UsernameExists) == true)
					|| (Objects.equals(UsernameExists, null) == false)) {
				usernameOutput.setText("Username Taken!");
				// If the username is not taken, updating the username in the database and
				// updating posts with the new username.
			} else if ((Objects.equals(UsernameExists, null) == true) && (AccountUsername != "")) {
				UpdateTable.UpdateUserDetails("username", AccountUsername, username);
				UpdateTable.UpdatePostsUsername("username", AccountUsername, username);
				usernameOutput.setText("Updated!");
				// Updating the username in the dataSingleton for the current session.
				dataSingleton.setUsername(AccountUsername);
			}
		}
		// Checking if the password field is empty. If not, updating the password in the
		// database.
		if (Objects.equals(password, "") == true) {
			passwordOutput.setText("");
		} else if (Objects.equals(password, "") == false) {
			UpdateTable.UpdateUserDetails("password", password, username);
			passwordOutput.setText("Updated!");
		}
	}
}
