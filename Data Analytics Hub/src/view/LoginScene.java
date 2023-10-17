package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class LoginScene {

	// Returns the Title for the Login Window
	public String getTitle() {
		return "Data Analytics Hub Login";
	}

	// Returns the Scene for the Login GUI
	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login_GUI.fxml"));
		GridPane pane = null;
		pane = loader.load();
		Scene scene = new Scene(pane);
		return scene;
	}
}
