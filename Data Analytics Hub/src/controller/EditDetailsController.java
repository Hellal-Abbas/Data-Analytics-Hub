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

public class EditDetailsController {

	private String username;

	@FXML
	private TextField firstnameField;

	@FXML
	private TextField lastnameField;

	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@FXML
	private Label firstnameOutput;

	@FXML
	private Label lastnameOutput;

	@FXML
	private Label usernameOutput;

	@FXML
	private Label passwordOutput;

	DataSingleton dataSingleton = DataSingleton.getInstance();

	@FXML
	public void updateDetailsHandler(ActionEvent event) throws IOException {

		username = dataSingleton.getUsername();

		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();
		String AccountUsername = usernameField.getText();
		String password = passwordField.getText();

		String UsernameExists = DataExists.usernameExists(AccountUsername);

		DataAnalyticsHubController dataAnalyticsHubController = new DataAnalyticsHubController();

		if (Objects.equals(firstname, "") == true) {
			firstnameOutput.setText("");
		} else if ((Objects.equals(firstname, "") == false)) {
			UpdateTable.UpdateUserDetails("firstname", firstname, username);
			firstnameOutput.setText("Updated!");
		}

		if (Objects.equals(lastname, "") == true) {
			lastnameOutput.setText("");
		} else if ((Objects.equals(lastname, "") == false)) {
			UpdateTable.UpdateUserDetails("lastname", lastname, username);
			lastnameOutput.setText("Updated!");
		}

		if (Objects.equals(AccountUsername, "") == true) {
			usernameOutput.setText("");
		} else if (Objects.equals(AccountUsername, "") == false) {

			if ((Objects.equals(AccountUsername, UsernameExists) == true)
					|| (Objects.equals(UsernameExists, null) == false)) {
				usernameOutput.setText("Username Taken!");

			} else if ((Objects.equals(UsernameExists, null) == true) && (AccountUsername != "")) {
				UpdateTable.UpdateUserDetails("username", AccountUsername, username);
				UpdateTable.UpdatePostsUsername("username", AccountUsername, username);
				usernameOutput.setText("Updated!");
				dataSingleton.setUsername(AccountUsername);
			}
		}

		if (Objects.equals(password, "") == true) {
			passwordOutput.setText("");
		} else if (Objects.equals(password, "") == false) {
			UpdateTable.UpdateUserDetails("password", password, username);
			passwordOutput.setText("Updated!");
		}
	}

}
