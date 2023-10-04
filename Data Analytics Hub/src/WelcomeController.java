import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WelcomeController {
	

	@FXML
	public void GoToSignUpHandler(ActionEvent e) {
		
		
	}
	
	
	@FXML
	public void GoToLoginHandler(ActionEvent event) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_GUI.fxml"));
		
			
		GridPane pane = null;
		
		try {
			pane = loader.load();
			
			LoginScene login = new LoginScene();
			LoginScene.setTitle(login.getTitle());
			LoginScene.setScene(login.getScene());
			LoginScene.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(pane);
		

		
	}
	
	

}
