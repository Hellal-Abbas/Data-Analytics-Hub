package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.LoginScene;
import view.SignupScene;

public class WelcomeController {

	@FXML
	public void GoToSignUpHandler(ActionEvent event) throws IOException {

		SignupScene signup = new SignupScene();
		Stage stage = new Stage();
		stage.setTitle(signup.getTitle());
		stage.setScene(signup.getScene());
		stage.show();

		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	public void GoToLoginHandler(ActionEvent event) throws IOException {

		LoginScene login = new LoginScene();
		Stage stage = new Stage();
		stage.setTitle(login.getTitle());
		stage.setScene(login.getScene());
		stage.show();

		((Node) (event.getSource())).getScene().getWindow().hide();
	}
}
