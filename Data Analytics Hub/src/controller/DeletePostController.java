package controller;

import java.io.IOException;
import java.util.Objects;

import database.DataSingleton;
import database.DeleteRow;
import helpers.DataExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//This class serves as the controller for the functionality related to deleting posts in the Data Analytics Hub application.
public class DeletePostController {

	@FXML
	private TextField postidField;

	@FXML
	private Label deleteOutput;
	// Creating an instance of DataSingleton to manage user session data.
	DataSingleton dataSingleton = DataSingleton.getInstance();

	// Event handler method for the "Delete Post" button.
	@FXML
	public void DeletePostHandler(ActionEvent event) throws IOException {
		// Retrieving the post ID entered by the user.
		String postid = postidField.getText();
		// Checking if the post ID is empty. If yes, clearing the deleteOutput label.
		if (Objects.equals(postid, "") == true) {
			deleteOutput.setText("");
			// If the post ID is not in the records, output an error message to the user.
		} else if (DataExists.postidExists(postid) == null) {
			deleteOutput.setText("Post ID not in records!");
			// If the post ID exists in the records, deleting the post and displaying a
			// success message.
		} else {
			DeleteRow.removePost(postid);
			deleteOutput.setText("Post Removed!");
		}
	}
}
