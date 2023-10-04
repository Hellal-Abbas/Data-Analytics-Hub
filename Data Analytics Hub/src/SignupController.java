import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	private TextField existingUserField;

	@FXML
	public void SignupHandler(ActionEvent e) {
		
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();		
		String username = usernameField.getText();
		String password = passwordField.getText();
		String existingUser = existingUserField.getText();
		
	}

}
