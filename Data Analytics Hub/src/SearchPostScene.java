import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SearchPostScene {
	
	public AnchorPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Search_Post_GUI.fxml"));
		
		AnchorPane anchorpane = null;
		
		anchorpane = loader.load();
		
		return anchorpane;
		
	}

}
