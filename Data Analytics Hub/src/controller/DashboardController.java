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

public class DashboardController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {

		ViewPostsScene viewPostsScene = new ViewPostsScene();
		try {
			borderpane.setCenter(viewPostsScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void ViewPostsHandler(ActionEvent event) throws IOException {
		ViewPostsScene viewPostsScene = new ViewPostsScene();
		borderpane.setCenter(viewPostsScene.getScene());
	}

	@FXML
	public void AddPostHandler(ActionEvent event) throws IOException {
		AddPostScene addPostScene = new AddPostScene();
		borderpane.setCenter(addPostScene.getScene());
	}
}
