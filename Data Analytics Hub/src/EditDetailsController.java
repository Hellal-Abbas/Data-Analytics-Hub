import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDetailsController {
	
	private String username;
	
	@FXML
	private TextField firstnameField;
	
	@FXML
	private TextField lastnameField;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label firstnameOutput;
	
	@FXML
	private Label lastnameOutput;
	
	@FXML
	private Label usernameOutput;
	
	@FXML
	private Label passwordOutput;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML
	public void updateDetailsHandler(ActionEvent event) throws IOException {	
		
		username = dataSingleton.getUsername();
		
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();
//		String username = usernameField.getText();
		String password = passwordField.getText();
		
		if ((Objects.equals(firstname, "") == true)) {
			firstnameOutput.setText("");
			
		} else if ((Objects.equals(firstname, "") == false)) {
			
			UpdateTable.UpdateUserDetails("firstname", firstname, username);
			
			firstnameOutput.setText("Updated!");
			
			DataAnalyticsHubController dataAnalyticsHubController = new DataAnalyticsHubController();
			dataAnalyticsHubController.setWelcomeName(firstname, lastname);
		}
		
		
		

//		lastnameOutput.setText(lastname);
//		usernameOutput.setText(username);
//		passwordOutput.setText(password);


	}


}
