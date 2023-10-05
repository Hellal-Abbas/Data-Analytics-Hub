import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class DataAnalyticsHubScene {
	
	public String getTitle() {
		return "Data Analytics Hub";
	}
	
	public Scene getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data_Analytics_Hub_GUI.fxml"));
		
		Pane pane = null;
		
		pane = loader.load();

		Scene scene = new Scene(pane);
		
		return scene;
		
	}

}
