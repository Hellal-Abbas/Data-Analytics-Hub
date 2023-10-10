import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ViewPostsController{
	
	@FXML
	private BorderPane borderpane;
	
	
	@FXML
	public void searchPostHandler(ActionEvent event) {
		
	}
	
	@FXML
	public void viewAllHandler(ActionEvent event) throws IOException {
		
		PostsTableScene postsTableScene = new PostsTableScene();
		borderpane.setCenter(postsTableScene.getScene());
		
	}
	
	@FXML
	public void deletePostHandler(ActionEvent event) {
		
	}
	
	@FXML
	public void exportPostHandler(ActionEvent event) {
		
	}
	
	

}