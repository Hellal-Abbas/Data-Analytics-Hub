package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import view.DeletePostScene;
import view.ExportPostScene;
import view.PostsTableScene;
import view.SearchPostScene;
import view.TopLikedPostsScene;

public class ViewPostsController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {

		PostsTableScene postsTableScene = new PostsTableScene();
		try {
			borderpane.setCenter(postsTableScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void viewAllHandler(ActionEvent event) throws IOException {

		PostsTableScene postsTableScene = new PostsTableScene();
		borderpane.setCenter(postsTableScene.getScene());

	}

	@FXML
	public void searchPostHandler(ActionEvent event) throws IOException {

		SearchPostScene searchPostScene = new SearchPostScene();
		borderpane.setCenter(searchPostScene.getScene());

	}

	@FXML
	public void toplikedPostsHandler(ActionEvent event) throws IOException {

		TopLikedPostsScene topLikedPostsScene = new TopLikedPostsScene();
		borderpane.setCenter(topLikedPostsScene.getScene());

	}

	@FXML
	public void deletePostHandler(ActionEvent event) throws IOException {

		DeletePostScene deletePostScene = new DeletePostScene();
		borderpane.setCenter(deletePostScene.getScene());

	}

	@FXML
	public void exportPostHandler(ActionEvent event) throws IOException {

		ExportPostScene exportPostScene = new ExportPostScene();
		borderpane.setCenter(exportPostScene.getScene());

	}

}