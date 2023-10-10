import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchPostController {
	
	private String username;
	
	@FXML
	private Label postidOutput;
	
	@FXML
	private Label contentOutput;
	
	@FXML
	private Label authorOutput;
	
	@FXML
	private Label likesOutput;

	@FXML
	private Label sharesOutput;
	
	@FXML
	private Label datetimeOutput;
	
	@FXML
	private Label postidErrorOutput;
	
	@FXML
	private TextField postidField;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML
	public void searchPostHandler(ActionEvent event) throws IOException {
		
		username = dataSingleton.getUsername();
		
		String postidInput = postidField.getText();
		
		String postid, content, author, likes, shares, datetime;
		
		postid = UserDetails.getPost(username, postidInput, "postid");
		content = UserDetails.getPost(username, postidInput, "content");
		author = UserDetails.getPost(username, postidInput, "author");
		likes = UserDetails.getPost(username, postidInput, "likes");
		shares = UserDetails.getPost(username, postidInput, "shares");
		datetime = UserDetails.getPost(username, postidInput, "datetime");
		
		if (Objects.equals(postidInput, "") == true) {
			postidErrorOutput.setText("");
			postidOutput.setText("");
			contentOutput.setText("");
			authorOutput.setText("");
			likesOutput.setText("");
			sharesOutput.setText("");
			datetimeOutput.setText("");}
		else if (DataExists.postidExists(postidInput) == null) {
			postidErrorOutput.setText("Post ID does not exist");
			postidOutput.setText("");
			contentOutput.setText("");
			authorOutput.setText("");
			likesOutput.setText("");
			sharesOutput.setText("");
			datetimeOutput.setText("");}
		else {
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
