import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignupController {
	
	@FXML
	private TextField firstnameField;
	
	@FXML
	private TextField lastnameField;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label missingFirstnameOutput;
	
	@FXML
	private Label missingLastnameOutput;
	
	@FXML
	private Label missingUsernameOutput;
	
	@FXML
	private Label missingPasswordOutput;
	
	@FXML
	private Label existingUserOutput;
	
	

	@FXML
	public void SignupHandler(ActionEvent e) {
		
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();		
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		if (firstname.trim().isEmpty()) {
			missingFirstnameOutput.setText("Missing Firstname!");
		} else {
			missingFirstnameOutput.setText("");
		}
		
		if (lastname.trim().isEmpty()) {
			missingFirstnameOutput.setText("Missing Firstname!");
		} else {
			missingFirstnameOutput.setText("");
		}
		
		
		if (username.trim().isEmpty()) {
			missingFirstnameOutput.setText("Missing Firstname!");
		} else {
			missingFirstnameOutput.setText("");
		}
		
		
		if (password.trim().isEmpty()) {
			missingFirstnameOutput.setText("Missing Firstname!");
		} else {
			missingFirstnameOutput.setText("");
		}

		
	}

}
