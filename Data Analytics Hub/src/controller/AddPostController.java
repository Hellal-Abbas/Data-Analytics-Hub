package controller;

import java.io.IOException;
import java.util.Objects;

import database.CheckTableExist;
import database.CreateTable;
import database.DataSingleton;
import database.InsertRow;
import helpers.DataExists;
import helpers.DateTimeCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//This class serves as the controller for adding posts in the Data Analytics Hub application.
public class AddPostController {

	private String username;

	@FXML
	private TextField postidField, authorField, likesField, sharesField, datetimeField;

	@FXML
	private TextArea contentField;

	@FXML
	private Label postidOutput, contentOutput, authorOutput, likesOutput, sharesOutput, datetimeOutput;

	@FXML
	private Label postaddedOutput;
	// Singleton instance of DataSingleton for managing shared data.
	DataSingleton dataSingleton = DataSingleton.getInstance();

	// Event handler method for the "Add Post" button.
	@FXML
	public void addPostHandler(ActionEvent event) throws IOException {
		// Retrieve the username of the currently logged-in user.
		username = dataSingleton.getUsername();
		// Check if the 'SocialMediaPosts' table exists in the database. If not, create
		// the table.
		if (CheckTableExist.CheckSocialMediaPosts() == false) {
			CreateTable.SocialMediaPostsTable();
		}
		// Retrieve values from input fields for post attributes.
		String postidfield = postidField.getText();
		String contentfield = contentField.getText();
		String authorfield = authorField.getText();
		String likesfield = likesField.getText();
		String sharesfield = sharesField.getText();
		String datetimefield = datetimeField.getText();
		// Initialize variables for storing parsed values of post attributes.
		int postid = 0;
		String content = null;
		String author = null;
		int likes = 0;
		int shares = 0;
		String datetime = null;
		// Flags for input validation.
		boolean postidValidity = false;
		boolean contentValidity = false;
		boolean authorValidity = false;
		boolean sharesValidity = false;
		boolean likesValidity = false;
		boolean datetimeValidity = false;
		// Validate and parse post ID.
		if (postidfield.trim().isEmpty()) {
			postidOutput.setText("Missing!");
		} else {
			try {
				postid = Integer.valueOf(postidfield);
				String postidExists = DataExists.postidExists(postidfield);

				if (postid < 0) {
					postidOutput.setText("Must be greater than 0!");
				} else if (Objects.equals(postidfield, postidExists) == true) {
					postidOutput.setText("PostID Taken!");
				} else {
					postidOutput.setText("");
					postidValidity = true;
				}
			} catch (NumberFormatException e) {
				postidOutput.setText("Must be a number!");
			}
		}
		// Validate content input.
		if (contentfield.trim().isEmpty()) {
			contentOutput.setText("Missing!");
		} else {
			contentOutput.setText("");
			content = contentfield;
			contentValidity = true;
		}
		// Validate author input.
		if (authorfield.trim().isEmpty()) {
			authorOutput.setText("Missing!");
		} else {
			authorOutput.setText("");
			author = authorfield;
			authorValidity = true;
		}
		// Validate likes input.
		if (likesfield.trim().isEmpty()) {
			likesOutput.setText("Missing!");
		} else {
			try {
				likes = Integer.valueOf(likesfield);
				if (likes < 0) {
					likesOutput.setText("Must be greater than 0!");
				} else {
					likesOutput.setText("");
					likesValidity = true;
				}
			} catch (NumberFormatException e) {
				likesOutput.setText("Must be a number!");
			}
		}
		// Validate shares input.
		if (sharesfield.trim().isEmpty()) {
			sharesOutput.setText("Missing!");
		} else {
			try {
				shares = Integer.valueOf(sharesfield);
				if (shares < 0) {
					sharesOutput.setText("Must be greater than 0!");
				} else {
					sharesOutput.setText("");
					sharesValidity = true;
				}

			} catch (NumberFormatException e) {
				sharesOutput.setText("Must be a number!");
			}
		}
		// Validate datetime input.
		if (datetimefield.trim().isEmpty()) {
			datetimeOutput.setText("Missing!");
		} else {
			if (DateTimeCheck.CheckValidity(datetimefield) == false) {
				datetimeOutput.setText("Incorrect Format!");
			} else if (DateTimeCheck.CheckValidity(datetimefield) == true) {
				datetimeOutput.setText("");
				datetime = datetimefield;
				datetimeValidity = true;
			}
		}
		// If all input is valid, insert the post into the 'SocialMediaPosts' table and
		// display a success message.
		if ((postidValidity) && (contentValidity) && (authorValidity) && (likesValidity) && (sharesValidity)
				&& (datetimeValidity)) {
			InsertRow.InsertPost(postid, content, author, likes, shares, datetime, username);
			postaddedOutput.setText("Post Added!");
		}
	}
}
