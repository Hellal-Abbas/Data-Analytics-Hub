package controller;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import helpers.DataExists;
import helpers.SaveFile;
import helpers.ViewPostsQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ExportPostController {

	@FXML
	private TextField postIDField;

	@FXML
	private Label exportOutput;

	@FXML
	public void exportPostHandler(ActionEvent event) throws IOException {

		String postID = postIDField.getText();

		String postidExists = DataExists.postidExists(postID);

		String postid, content, author, likes, shares, datetime, post;

		postid = ViewPostsQuery.PostDetailsExport("postid", postID);
		content = ViewPostsQuery.PostDetailsExport("content", postID);
		author = ViewPostsQuery.PostDetailsExport("author", postID);
		likes = ViewPostsQuery.PostDetailsExport("likes", postID);
		shares = ViewPostsQuery.PostDetailsExport("shares", postID);
		datetime = ViewPostsQuery.PostDetailsExport("datetime", postID);

		post = postid + ", " + content + ", " + author + ", " + likes + ", " + shares + ", " + datetime + ", ";

		if (Objects.equals(postID, "") == true) {
			exportOutput.setText("");
		} else if (Objects.equals(postID, postidExists) == false) {
			exportOutput.setText("Post ID not in record!");
		} else if (Objects.equals(postID, postidExists) == true) {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save post");
			fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV files (*.csv)", "*.csv"));
			File file = fileChooser.showSaveDialog(null);

			if (file != null) {
				SaveFile.saveTextToFile(post, file);
			}
			exportOutput.setText("Post Exported!");
		}
	}
}
