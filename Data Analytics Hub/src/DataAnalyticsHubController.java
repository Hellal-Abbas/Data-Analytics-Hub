import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.WindowEvent;

public class DataAnalyticsHubController {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	@FXML
	private Label welcomeOutput;
	
	public void showWelcome() {
		welcomeOutput.setText("Hey");
	}
	
    



}
