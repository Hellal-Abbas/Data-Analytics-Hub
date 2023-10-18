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

//This class serves as the controller for the functionality related to exporting posts in the Data Analytics Hub application.
public class ExportPostController {

	@FXML
	private TextField postIDField;

	@FXML
	private Label exportOutput;

	// Event handler method for the "Export Post" button.
	@FXML
	public void exportPostHandler(ActionEvent event) throws IOException {
		// Retrieving the post ID entered by the user.
		String postID = postIDField.getText();

		String postidExists = DataExists.postidExists(postID);

		String postid, content, author, likes, shares, datetime, post;
		// Retrieving post details (post ID, content, author, likes, shares, and
		// datetime) from the database.
		postid = ViewPostsQuery.PostDetailsExport("postid", postID);
		content = ViewPostsQuery.PostDetailsExport("content", postID);
		author = ViewPostsQuery.PostDetailsExport("author", postID);
		likes = ViewPostsQuery.PostDetailsExport("likes", postID);
		shares = ViewPostsQuery.PostDetailsExport("shares", postID);
		datetime = ViewPostsQuery.PostDetailsExport("datetime", postID);
		// Constructing a CSV-formatted string containing post details.
		post = postid + ", " + content + ", " + author + ", " + likes + ", " + shares + ", " + datetime + ", ";
		// Checking if the post ID field is empty. If yes, displaying an empty message.
		if (Objects.equals(postID, "") == true) {
			exportOutput.setText("");
			// Checking if the entered post ID does not exist in the records. If yes,
			// displaying an error message.
		} else if (Objects.equals(postID, postidExists) == false) {
			exportOutput.setText("Post ID not in record!");
			// If the post ID exists, allowing the user to choose a location to save the
			// post details as a CSV file.
		} else if (Objects.equals(postID, postidExists) == true) {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save post");
			fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV files (*.csv)", "*.csv"));
			File file = fileChooser.showSaveDialog(null);
			// If the user selects a location, save the post details to the chosen file and
			// display a success message.
			if (file != null) {
				SaveFile.saveTextToFile(post, file);
			}
			exportOutput.setText("Post Exported!");
		}
	}
}
