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
	

	EventHandler<javafx.stage.WindowEvent> eventHandler = new EventHandler<javafx.stage.WindowEvent>() { 
		
		@Override
		public void handle(WindowEvent e) {
			welcomeOutput.setText("Welcome");
			System.out.println("Hey");
	    } 
    };  


}
