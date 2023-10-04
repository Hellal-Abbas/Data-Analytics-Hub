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
			missingFirstnameOutput.setText("Missing!");
		} else {
			missingFirstnameOutput.setText("");
		}
		
		if (lastname.trim().isEmpty()) {
			missingLastnameOutput.setText("Missing!");
		} else {
			missingLastnameOutput.setText("");
		}
		
		
		if (username.trim().isEmpty()) {
			missingUsernameOutput.setText("Missing!");
		} else {
			missingUsernameOutput.setText("");
		}
		
		
		if (password.trim().isEmpty()) {
			missingPasswordOutput.setText("Missing!");
		} else {
			missingPasswordOutput.setText("");
		}
		
		if (CheckTableExist.CheckUsers() == true) {
			
			InsertRow.InsertUser(firstname, lastname, username, password);
			
		} else {
			CreateTable.UsersTable();
			InsertRow.InsertUser(firstname, lastname, username, password);

			
		}
		
		

		
	}

}
