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

//This class serves as the controller for the view posts screen of the Data Analytics Hub application.
public class ViewPostsController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// Creating a new PostsTableScene and setting it as the center of the
		// BorderPane.
		PostsTableScene postsTableScene = new PostsTableScene();
		try {
			borderpane.setCenter(postsTableScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event handler method for the "View All" button.
	@FXML
	public void viewAllHandler(ActionEvent event) throws IOException {
		// Creating a new PostsTableScene and setting it as the center of the
		// BorderPane.
		PostsTableScene postsTableScene = new PostsTableScene();
		borderpane.setCenter(postsTableScene.getScene());
	}

	// Event handler method for the "Search Post" button.
	@FXML
	public void searchPostHandler(ActionEvent event) throws IOException {
		// Creating a new SearchPostScene and setting it as the center of the
		// BorderPane.
		SearchPostScene searchPostScene = new SearchPostScene();
		borderpane.setCenter(searchPostScene.getScene());
	}

	// Event handler method for the "Top Liked Posts" button.
	@FXML
	public void toplikedPostsHandler(ActionEvent event) throws IOException {
		// Creating a new TopLikedPostsScene and setting it as the center of the
		// BorderPane.
		TopLikedPostsScene topLikedPostsScene = new TopLikedPostsScene();
		borderpane.setCenter(topLikedPostsScene.getScene());
	}

	// Event handler method for the "Delete Post" button.
	@FXML
	public void deletePostHandler(ActionEvent event) throws IOException {
		// Creating a new DeletePostScene and setting it as the center of the
		// BorderPane.
		DeletePostScene deletePostScene = new DeletePostScene();
		borderpane.setCenter(deletePostScene.getScene());
	}

	// Event handler method for the "Export Post" button.
	@FXML
	public void exportPostHandler(ActionEvent event) throws IOException {
		// Creating a new ExportPostScene and setting it as the center of the
		// BorderPane.
		ExportPostScene exportPostScene = new ExportPostScene();
		borderpane.setCenter(exportPostScene.getScene());
	}
}