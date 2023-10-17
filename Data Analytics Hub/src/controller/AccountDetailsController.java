package controller;

import java.net.URL;
import java.util.ResourceBundle;

import database.DataSingleton;
import helpers.UserDetails;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AccountDetailsController implements Initializable {

	private String firstname, lastname, username, password;

	@FXML
	private Label firstnameOutput, lastnameOutput, usernameOutput, passwordOutput;

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {

		DataSingleton dataSingleton = DataSingleton.getInstance();
		username = dataSingleton.getUsername();

		firstname = UserDetails.getUserDetails(username, "firstname");
		lastname = UserDetails.getUserDetails(username, "lastname");
		password = UserDetails.getUserDetails(username, "password");

		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);

		firstnameOutput.setText(firstname);
		lastnameOutput.setText(lastname);
		usernameOutput.setText(username);
		passwordOutput.setText(password);

	}

}
