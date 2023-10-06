import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DataAnalyticsHubController implements Initializable {
	
	private String firstname;
	
	private String lastname;
	
	private String username;
	
	private String password;

	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML
	private Label welcomeOutput;
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
		username = dataSingleton.getUsername();
		
		firstname = userDetails.getUserDetails(username, "firstname");
		lastname = userDetails.getUserDetails(username, "lastname");
		password = userDetails.getUserDetails(username, "password");

		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase()  + lastname.substring(1);

		welcomeOutput.setText("Welcome " + firstname + " " + lastname + ".");
	}
	
	@FXML
	public void showDashBoardHandler(ActionEvent event) throws IOException {		
	}
	
	@FXML
	public void accountHandler(ActionEvent event) throws IOException {		
	}
	
	@FXML
	public void logoutHandler(ActionEvent event) throws IOException {		
	}
	
}
