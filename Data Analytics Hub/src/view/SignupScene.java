package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class SignupScene {

	// Returns the Title for the Sign Up Window
	public String getTitle() {
		return "Data Analytics Hub Signup";
	}

	// Returns the Scene for the Sign Up GUI
	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Signup_GUI.fxml"));
		GridPane pane = null;
		pane = loader.load();
		Scene scene = new Scene(pane);
		return scene;
	}
}
