package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DataSingleton;
import helpers.UserDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.AccountScene;
import view.DashboardScene;
import view.LoginScene;

//This class serves as the main controller for the Data Analytics Hub application.
public class DataAnalyticsHubController implements Initializable {

	@FXML
	private BorderPane borderpane;
	// Private member variables to store user information.
	private String firstname, lastname, username;

	DataSingleton dataSingleton = DataSingleton.getInstance();

	@FXML
	Label welcomeOutput;

	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		// Getting the current username from the DataSingleton instance.
		username = dataSingleton.getUsername();
		// Retrieving user details and capitalizing the first letter of firstname and
		// lastname.
		firstname = UserDetails.getUserDetails(username, "firstname");
		lastname = UserDetails.getUserDetails(username, "lastname");

		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);
		// Setting the welcome message with the formatted user's name.
		welcomeOutput.setText("Welcome " + firstname + " " + lastname + ".");
		// Setting the initial view to the dashboard screen.
		DashboardScene dashboardScene = new DashboardScene();
		try {
			borderpane.setCenter(dashboardScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event handler method for the "Dashboard" button.
	@FXML
	public void showDashBoardHandler(ActionEvent event) throws IOException {
		// Creating an instance of DashboardScene and setting it as the view in the
		// BorderPane.
		DashboardScene dashboardScene = new DashboardScene();
		borderpane.setCenter(dashboardScene.getScene());

	}

	// Event handler method for the "Account" button.
	@FXML
	public void accountHandler(ActionEvent event) throws IOException {
		// Creating an instance of AccountScene and setting it as the view in the
		// BorderPane.
		AccountScene accountScene = new AccountScene();
		borderpane.setCenter(accountScene.getScene());
	}

	// Event handler method for the "Logout" button.
	@FXML
	public void logoutHandler(ActionEvent event) throws IOException {
		// Creating an instance of LoginScene and displaying it as a new stage for user
		// login.
		LoginScene login = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(login.getTitle());
		stage.setScene(login.getScene());
		stage.show();
		// Closing the current window upon logout.
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

}
