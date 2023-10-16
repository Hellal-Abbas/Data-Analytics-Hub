package view;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class AccountDetailsScene {
	
	public AnchorPane getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Account_Details_GUI.fxml"));
		
		AnchorPane anchorpane = null;
		
		anchorpane = loader.load();
		
		return anchorpane;
		
	}

}
