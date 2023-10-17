package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class WelcomeScene {

	// Returns the Title for the Welcome Window
	public String getTitle() {
		return "Welcome to Data Analytics Hub";
	}

	// Returns the Scene for the Welcome GUI
	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Welcome_GUI.fxml"));
		GridPane pane = null;
		pane = loader.load();
		Scene scene = new Scene(pane);
		return scene;
	}
}
