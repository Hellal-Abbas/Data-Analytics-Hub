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
		
		
	}
	
}