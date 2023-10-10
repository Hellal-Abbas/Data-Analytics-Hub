import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class DashboardController {

	@FXML
	private BorderPane borderpane;
	
	@FXML
	public void ViewPostsHandler(ActionEvent event) throws IOException {	
		
		ViewPostsScene viewPostsScene = new ViewPostsScene();
//		borderpane.setCenter(viewPostsScene.getScene());
		
	}
	
	@FXML
	public void AddPostHandler(ActionEvent event) throws IOException {		
		
		AddPostScene addPostScene = new AddPostScene();
		borderpane.setCenter(addPostScene.getScene());

	}	
	
	
}
