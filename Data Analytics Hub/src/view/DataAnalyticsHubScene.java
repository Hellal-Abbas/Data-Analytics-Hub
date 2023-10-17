package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class DataAnalyticsHubScene {

	// Returns the Title for the Data Analytics Hub Window
	public String getTitle() {
		return "Data Analytics Hub";
	}

	// Returns the Scene for the Data Analytics Hub GUI
	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Data_Analytics_Hub_GUI.fxml"));
		BorderPane borderpane = null;
		borderpane = loader.load();
		Scene scene = new Scene(borderpane);
		return scene;
	}
}
