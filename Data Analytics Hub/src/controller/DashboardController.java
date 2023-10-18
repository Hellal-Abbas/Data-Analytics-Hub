package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import view.AddPostScene;
import view.ViewPostsScene;

//This class serves as the controller for the dashboard screen in the JavaFX application.
public class DashboardController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// Creating an instance of ViewPostsScene and setting it as the initial view in
		// the BorderPane.
		ViewPostsScene viewPostsScene = new ViewPostsScene();
		try {
			borderpane.setCenter(viewPostsScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event handler method for the "View Posts" button.
	@FXML
	public void ViewPostsHandler(ActionEvent event) throws IOException {
		// Creating an instance of ViewPostsScene and setting it as the view in the
		// BorderPane.
		ViewPostsScene viewPostsScene = new ViewPostsScene();
		borderpane.setCenter(viewPostsScene.getScene());
	}

	// Event handler method for the "Add Post" button.
	@FXML
	public void AddPostHandler(ActionEvent event) throws IOException {
		// Creating an instance of AddPostScene and setting it as the view in the
		// BorderPane.
		AddPostScene addPostScene = new AddPostScene();
		borderpane.setCenter(addPostScene.getScene());
	}
}
