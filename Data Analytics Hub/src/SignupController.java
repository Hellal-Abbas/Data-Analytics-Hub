import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {
	
	@FXML
	private TextField firstnameField;
	
	@FXML
	private TextField lastnameField;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label missingFirstnameOutput;
	
	@FXML
	private Label missingLastnameOutput;
	
	@FXML
	private Label missingUsernameOutput;
	
	@FXML
	private Label missingPasswordOutput;
	
	@FXML
	private Label existingUserOutput;
	
	
	@FXML
	public void SignupHandler(ActionEvent event) throws IOException {
		
		if (CheckTableExist.CheckUsers() == false) {
			CreateTable.UsersTable();
		}
		
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();		
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		if (firstname.trim().isEmpty()) {missingFirstnameOutput.setText("Missing!");
		} else { missingFirstnameOutput.setText("");}
		
		if (lastname.trim().isEmpty()) {missingLastnameOutput.setText("Missing!");
		} else {missingLastnameOutput.setText("");}
		
		if (username.trim().isEmpty()) {missingUsernameOutput.setText("Missing!");
		} else {missingUsernameOutput.setText("");}
		
		if (password.trim().isEmpty()) {missingPasswordOutput.setText("Missing!");
		} else {missingPasswordOutput.setText("");}
		
		
		
		
		int idk = DataExists.UserExists(username);
		
		System.out.println(idk);
		
		
//		if (DataExists.UserExists(username)) {
//			
//			existingUserOutput.setText("Username Taken!");
//			
//		} else if (DataExists.UserExists(username)) {	
//			existingUserOutput.setText("");
//				
//
//		} else if ((firstname.trim().isEmpty() == false) 
//				&& (lastname.trim().isEmpty() == false) 
//				&& (username.trim().isEmpty() == false) 
//				&& (password.trim().isEmpty() == false)) {
//			
//			InsertRow.InsertUser(firstname, lastname, username, password);
//	        LoginScene login = new LoginScene();
//			Stage stage = new Stage();
//			stage.setTitle(login.getTitle());
//			stage.setScene(login.getScene());
//			stage.show();
//			
//			((Node)(event.getSource())).getScene().getWindow().hide();
//			
//		}
		
	}

}
