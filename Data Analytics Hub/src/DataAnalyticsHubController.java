import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DataAnalyticsHubController implements Initializable {
	
	private String username;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML
	private Label welcomeOutput;
	
	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		username = dataSingleton.getUsername();
	}
	
	@FXML
	public void showDashBoard(ActionEvent event) throws IOException {		
		welcomeOutput.setText("Welcome " + username + "!");
	}
	
}
