import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AccountScene {
	
	public BorderPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Account_GUI.fxml"));
		
		BorderPane borderpane = null;
		
		borderpane = loader.load();
		
		return borderpane;
		
	}
}
