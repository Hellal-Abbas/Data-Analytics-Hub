import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DataAnalyticsHubController {
	
	@FXML
	private Label welcomeOutput;
	
	@FXML
	public void showDashBoard(ActionEvent event) throws IOException {
		LoginController loginController = new LoginController();
		welcomeOutput.setText("Welcome " + loginController.getUsername() + "!");
		
	}
	





}
