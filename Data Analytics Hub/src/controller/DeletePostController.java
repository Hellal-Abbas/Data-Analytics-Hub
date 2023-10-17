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

public class DeletePostController {

	@FXML
	private TextField postidField;

	@FXML
	private Label deleteOutput;

	DataSingleton dataSingleton = DataSingleton.getInstance();

	@FXML
	public void DeletePostHandler(ActionEvent event) throws IOException {

		String postid = postidField.getText();

		if (Objects.equals(postid, "") == true) {
			deleteOutput.setText("");
		} else if (DataExists.postidExists(postid) == null) {
			deleteOutput.setText("Post ID not in records!");
		} else {
			DeleteRow.removePost(postid);
			deleteOutput.setText("Post Removed!");
		}

	}
}
