package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ViewPostsScene {

	// Returns the Scene for the View Posts GUI
	public BorderPane getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_Post_GUI.fxml"));
		BorderPane borderpane = null;
		borderpane = loader.load();
		return borderpane;
	}
}
