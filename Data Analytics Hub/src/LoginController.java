import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;

	@FXML
	public void loginHandler(ActionEvent e) {
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		String usernameExists = DataExists.usernameExists(username);
		String passwordExists = DataExists.passwordExists(username, password);
		
		System.out.println(usernameExists);
		System.out.println(passwordExists);


//		
//		if ((Objects.equals(username, usernameExists) == true) && (Objects.equals(username, passwordExists) == true)) {
//			System.out.println("yep");
//		} else {
//			
//			System.out.println("nope");
//
//		}

		
		
	}
	
}
