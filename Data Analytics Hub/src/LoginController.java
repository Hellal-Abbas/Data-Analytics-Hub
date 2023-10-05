import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label incorrectUsernameOutput;
	
	@FXML
	private Label incorrectPasswordOutput;
	
	@FXML
	public void goBackHandler(ActionEvent event) throws IOException {
		
		WelcomeScene welcomeScene = new WelcomeScene();
		Stage stage = new Stage();
		stage.setTitle(welcomeScene.getTitle());
		stage.setScene(welcomeScene.getScene());
		stage.show();
		
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}

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
			
			DataSingleton dataSingleton = DataSingleton.getInstance();
			dataSingleton.setUsername(username);
			
			DataAnalyticsHubScene dataAnalyticsHub = new DataAnalyticsHubScene();
			Stage stage = new Stage();
			stage.setTitle(dataAnalyticsHub.getTitle());
			stage.setScene(dataAnalyticsHub.getScene());
			stage.show();
			
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		}
		
	}
	
}
