import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label incorrectUsernameOutput;
	
	@FXML
	private Label incorrectPasswordOutput;

	@FXML
	public void loginHandler(ActionEvent e) {
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		String usernameExists = DataExists.usernameExists(username);
		String passwordExists = DataExists.passwordExists(username, password);
		
		if ((Objects.equals(username, usernameExists) == false) 
		 || (Objects.equals(password, passwordExists) == false)) {
			incorrectUsernameOutput.setText("Incorrect username");
			incorrectPasswordOutput.setText("or password!");

			
		} else if ((Objects.equals(username, usernameExists) == true) 
				&& (Objects.equals(password, passwordExists) == true)) {
			incorrectUsernameOutput.setText("");
			incorrectPasswordOutput.setText("");
			
			
			
		}
		
		
	}
	
}
