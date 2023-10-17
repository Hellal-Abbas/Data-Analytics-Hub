package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class SignupScene {

	public String getTitle() {
		return "Data Analytics Hub Signup";
	}

	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Signup_GUI.fxml"));
		GridPane pane = null;
		pane = loader.load();
		Scene scene = new Scene(pane);
		return scene;
	}
}
