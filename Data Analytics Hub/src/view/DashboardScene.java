package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class DashboardScene {

	public BorderPane getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard_GUI.fxml"));
		BorderPane borderpane = null;
		borderpane = loader.load();
		return borderpane;
	}
}
