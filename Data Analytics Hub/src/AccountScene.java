import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class AccountScene {
	
	public BorderPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Account_GUI.fxml"));
		
		BorderPane borderpane = null;
		
		borderpane = loader.load();
		
		return borderpane;
		
	}
}
