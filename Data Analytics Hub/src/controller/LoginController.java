package controller;

import java.io.IOException;
import java.util.Objects;

import database.CheckTableExist;
import database.CreateTable;
import database.DataSingleton;
import helpers.DataExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.DataAnalyticsHubScene;
import view.WelcomeScene;

//This class serves as the controller for the login screen of the Data Analytics Hub application.
public class LoginController {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	@FXML
	private TextField usernameField, passwordField;

	@FXML
	private Label incorrectUsernameOutput, incorrectPasswordOutput;
	// Accessing the singleton instance of DataSingleton class.
	DataSingleton dataSingleton = DataSingleton.getInstance();

	// Event handler method for the "Go Back" button.
	@FXML
	public void goBackHandler(ActionEvent event) throws IOException {
		// Creating a WelcomeScene and displaying it, hiding the current window.
		WelcomeScene welcomeScene = new WelcomeScene();
		Stage stage = new Stage();
		stage.setTitle(welcomeScene.getTitle());
		stage.setScene(welcomeScene.getScene());
		stage.show();

		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	// Event handler method for the "Login" button.
	@FXML
	public void loginHandler(ActionEvent event) throws IOException {
		// Checking if the Users table exists in the database. If not, create it.
		if (CheckTableExist.CheckUsers() == false) {
			CreateTable.UsersTable();
		}
		// Getting the input from the username and password fields.
		String username = usernameField.getText();
		String password = passwordField.getText();
		// Checking if the entered username and password exist in the database.
		String usernameExists = DataExists.usernameExists(username);
		String passwordExists = DataExists.passwordExists(username, password);
		// Handling incorrect username or password scenarios.
		if ((Objects.equals(username, usernameExists) == false)
				|| (Objects.equals(password, passwordExists) == false)) {
			incorrectUsernameOutput.setText("Incorrect username");
			incorrectPasswordOutput.setText("or password!");
			// Handling successful login scenario.
		} else if ((Objects.equals(username, usernameExists) == true)
				&& (Objects.equals(password, passwordExists) == true)) {
			incorrectUsernameOutput.setText("");
			incorrectPasswordOutput.setText("");
			// Setting the username in the DataSingleton instance.
			dataSingleton.setUsername(username);
			// Creating a DataAnalyticsHubScene and displaying it, hiding the current
			// window.
			DataAnalyticsHubScene dataAnalyticsHub = new DataAnalyticsHubScene();
			Stage stage = new Stage();
			stage.setTitle(dataAnalyticsHub.getTitle());
			stage.setScene(dataAnalyticsHub.getScene());
			stage.show();
			// Closing the current window after logging in.
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
	}
}
