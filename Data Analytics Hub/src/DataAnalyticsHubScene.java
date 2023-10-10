import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class DataAnalyticsHubScene {
	
	public String getTitle() {
		return "Data Analytics Hub";
	}
	
	public Scene getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data_Analytics_Hub_GUI.fxml"));
		
		BorderPane borderpane = null;
		
		borderpane = loader.load();

		Scene scene = new Scene(borderpane);
		
		return scene;
		
	}

}
