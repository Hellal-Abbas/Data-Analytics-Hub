import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AccountDetailsController implements Initializable {
	
	private String firstname;
	
	private String lastname;
	
	private String username;
	
	private String password;
	
	@FXML
	private Label firstnameOutput;
	
	@FXML
	private Label lastnameOutput;
	
	@FXML
	private Label usernameOutput;
	
	@FXML
	private Label passwordOutput;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		
		username = dataSingleton.getUsername();
		
		firstname = userDetails.getUserDetails(username, "firstname");
		lastname = userDetails.getUserDetails(username, "lastname");
		password = userDetails.getUserDetails(username, "password");

		firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
		lastname = lastname.substring(0, 1).toUpperCase()  + lastname.substring(1);

		firstnameOutput.setText(firstname);
		lastnameOutput.setText(lastname);
		usernameOutput.setText(username);
		passwordOutput.setText(password);
		
	}
}
