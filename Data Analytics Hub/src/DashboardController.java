import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class DashboardController {

	@FXML
	private BorderPane borderpane;
	
	@FXML
	public void ViewPostsHandler(ActionEvent event) throws IOException {	
		
		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		borderpane.setCenter(accountDetailsScene.getScene());
		
	}
	
	@FXML
	public void AddPostHandler(ActionEvent event) throws IOException {		
		
		EditDetailsScene editDetailsScene = new EditDetailsScene();
		borderpane.setCenter(editDetailsScene.getScene());

	}	
	
	
}
