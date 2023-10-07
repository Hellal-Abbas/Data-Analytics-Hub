import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class EditDetailsScene {
	
	public AnchorPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit_Details_GUI.fxml"));
		
		AnchorPane anchorpane = null;
		
		anchorpane = loader.load();
		
		return anchorpane;
		
	}

}
