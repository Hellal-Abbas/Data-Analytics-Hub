import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccountDetailsController {
	
	@FXML
	private Label firstname;
	
	@FXML
	private Label lastname;
	
	@FXML
	private Label username;
	
	@FXML
	private Label password;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
//		username.setText(dataSingleton.getUsername());
		
//		firstname = userDetails.getUserDetails(username, "firstname");
//		lastname = userDetails.getUserDetails(username, "lastname");
//		password = userDetails.getUserDetails(username, "password");
//
//		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
//		lastname = lastname.substring(0, 1).toUpperCase()  + lastname.substring(1);
//
//		welcomeOutput.setText("Welcome " + firstname + " " + lastname + ".");
	}
}
