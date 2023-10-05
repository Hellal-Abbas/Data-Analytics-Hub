import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
	public void loginHandler(ActionEvent event) throws IOException {
		
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
			
			DataAnalyticsHubController dataAnalyticsHubController = new DataAnalyticsHubController();
			dataAnalyticsHubController.setUsername(username);
			
			DataAnalyticsHubScene dataAnalyticsHub = new DataAnalyticsHubScene();
			Stage stage = new Stage();
			stage.setTitle(dataAnalyticsHub.getTitle());
			stage.setScene(dataAnalyticsHub.getScene());
			stage.show();
			
			final EventHandler<WindowEvent> shownHandler = new EventHandler<WindowEvent>() {
				  @Override
				  public void handle(WindowEvent event) {
				    System.out.println("Shown");
				  }
				};
			
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		}
		
	}
	
}
