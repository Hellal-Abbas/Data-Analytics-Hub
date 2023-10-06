import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DashboardScene {
	
	public AnchorPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Data_Analytics_Hub_GUI.fxml"));
		
		AnchorPane pane = null;
		
		pane = loader.load();

//		Scene scene = new Scene(pane);
		
		return pane;
		
	}

}
