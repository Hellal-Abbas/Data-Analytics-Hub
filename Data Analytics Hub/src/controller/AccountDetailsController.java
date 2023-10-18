package controller;

import java.net.URL;
import java.util.ResourceBundle;

import database.DataSingleton;
import helpers.UserDetails;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

//This class serves as the controller for the account details screen in the JavaFX application.
public class AccountDetailsController implements Initializable {
	// Private member variables to store user information and link with
	// corresponding UI components.
	private String firstname, lastname, username, password;

	@FXML
	private Label firstnameOutput, lastnameOutput, usernameOutput, passwordOutput;

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		// Getting the current username from the DataSingleton instance.
		DataSingleton dataSingleton = DataSingleton.getInstance();
		username = dataSingleton.getUsername();
		// Retrieving user details (firstname, lastname, password) based on the
		// username.
		firstname = UserDetails.getUserDetails(username, "firstname");
		lastname = UserDetails.getUserDetails(username, "lastname");
		password = UserDetails.getUserDetails(username, "password");
		// Capitalizing the first letter of firstname and lastname.
		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);
		// Setting the retrieved user details in the corresponding Label components.
		firstnameOutput.setText(firstname);
		lastnameOutput.setText(lastname);
		usernameOutput.setText(username);
		passwordOutput.setText(password);

	}

}
