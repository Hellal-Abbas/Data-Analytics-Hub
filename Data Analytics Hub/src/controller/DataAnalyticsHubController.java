package controller;
import database.*;
import helpers.*;
import view.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DataAnalyticsHubController implements Initializable {
	
	@FXML
	private BorderPane borderpane;
	
	private String firstname;
	
	private String lastname;
	
	private String username;

	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML Label welcomeOutput;
	
    public void setWelcomeName(String firstname, String lastname) {
		welcomeOutput.setText("Welcome " + firstname + " " + lastname + ".");
    }
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
		username = dataSingleton.getUsername();
		
		firstname = UserDetails.getUserDetails(username, "firstname");
		lastname = UserDetails.getUserDetails(username, "lastname");

		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase()  + lastname.substring(1);

		welcomeOutput.setText("Welcome " + firstname + " " + lastname + ".");
		
		DashboardScene dashboardScene = new DashboardScene();
		try {
			borderpane.setCenter(dashboardScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void showDashBoardHandler(ActionEvent event) throws IOException {		
		
		DashboardScene dashboardScene = new DashboardScene();
		borderpane.setCenter(dashboardScene.getScene());

	}
	
	@FXML
	public void accountHandler(ActionEvent event) throws IOException {
		
		AccountScene accountScene = new AccountScene();
		borderpane.setCenter(accountScene.getScene());
	}
	
	@FXML
	public void logoutHandler(ActionEvent event) throws IOException {	
		
        LoginScene login = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(login.getTitle());
		stage.setScene(login.getScene());
		stage.show();
		
		((Node)(event.getSource())).getScene().getWindow().hide();
			
	}
	
}
