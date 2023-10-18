package controller;

import java.io.IOException;
import java.util.Objects;

import database.DataSingleton;
import helpers.DataExists;
import helpers.UserDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//This class serves as the controller for searching posts in the Data Analytics Hub application.
public class SearchPostController {

	private String username;

	@FXML
	private Label postidOutput, contentOutput, authorOutput, likesOutput, sharesOutput, datetimeOutput;

	@FXML
	private Label postidErrorOutput;

	@FXML
	private TextField postidField;
	// Instance of DataSingleton for accessing user data.
	DataSingleton dataSingleton = DataSingleton.getInstance();

	// Helper method to clear output labels.
	private void clearOutputLabels() {
		postidOutput.setText("");
		contentOutput.setText("");
		authorOutput.setText("");
		likesOutput.setText("");
		sharesOutput.setText("");
		datetimeOutput.setText("");
	}

	// This method handles the search post action when the search button is clicked.
	@FXML
	public void searchPostHandler(ActionEvent event) throws IOException {
		// Retrieving the username of the current user from DataSingleton.
		username = dataSingleton.getUsername();
		// Getting the input post ID from the TextField.
		String postidInput = postidField.getText();
		// Variables to store post details retrieved from the database.
		String postid, content, author, likes, shares, datetime;
		// Retrieving post details using the UserDetails helper class based on the post
		// ID and username.
		postid = UserDetails.getPost(username, postidInput, "postid");
		content = UserDetails.getPost(username, postidInput, "content");
		author = UserDetails.getPost(username, postidInput, "author");
		likes = UserDetails.getPost(username, postidInput, "likes");
		shares = UserDetails.getPost(username, postidInput, "shares");
		datetime = UserDetails.getPost(username, postidInput, "datetime");
		// Handling different scenarios based on the search result and updating UI
		// components.
		if (Objects.equals(postidInput, "") == true) {
			// If the post ID is empty, clear the error message and output labels.
			postidErrorOutput.setText("");
			clearOutputLabels();
		} else if (DataExists.postidExists(postidInput) == null) {
			// If the post ID does not exist in the records, display an error message and
			// clear output labels.
			postidErrorOutput.setText("Post ID not in records!");
			clearOutputLabels();
		} else {
			// If the post ID exists, clear the error message and update the output labels
			// with post details.
			postidErrorOutput.setText("");
			postidOutput.setText(postid);
			contentOutput.setText(content);
			authorOutput.setText(author);
			likesOutput.setText(likes);
			sharesOutput.setText(shares);
			datetimeOutput.setText(datetime);
		}

	}
}
