import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class WelcomeController {
	

	@FXML
	public void GoToSignUpHandler(ActionEvent event) {
		
        LoginScene signup = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(signup.getTitle());
		stage.setScene(signup.getScene());
		stage.show();
		
		
		// Hide this current window (if this is what you want)
		((Node)(event.getSource())).getScene().getWindow().hide();
		
		
	}
	
	
	@FXML
	public void GoToLoginHandler(ActionEvent event) {
		
        LoginScene login = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(login.getTitle());
		stage.setScene(login.getScene());
		stage.show();
		
		
		// Hide this current window (if this is what you want)
		((Node)(event.getSource())).getScene().getWindow().hide();

	}
	
	

}
