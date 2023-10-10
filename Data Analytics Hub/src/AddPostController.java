import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddPostController {
	
	private String username;
	
	@FXML
	private TextField postidField;
	
	@FXML
	private TextArea contentField;
	
	@FXML
	private TextField authorField;
	
	@FXML
	private TextField likesField;
	
	@FXML
	private TextField sharesField;
	
	@FXML
	private TextField datetimeField;
	
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
	private Label postaddedOutput;
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	@FXML
	public void addPostHandler(ActionEvent event) throws IOException {	
		
		username = dataSingleton.getUsername();
		
		if (CheckTableExist.CheckSocialMediaPosts() == false) {CreateTable.SocialMediaPostsTable();}
		
		String postid = postidField.getText();
		String content = contentField.getText();
		String author = authorField.getText();
		String likes = likesField.getText();
		String shares = sharesField.getText();
		String datetime = datetimeField.getText();
		
		if (postid.trim().isEmpty()) {postidOutput.setText("Missing!");} else {postidOutput.setText("");}
		
		if (content.trim().isEmpty()) {contentOutput.setText("Missing!");} else {contentOutput.setText("");}
		
		if (author.trim().isEmpty()) {authorOutput.setText("Missing!");} else {authorOutput.setText("");}
		
		if (likes.trim().isEmpty()) {likesOutput.setText("Missing!");} else {likesOutput.setText("");}
		
		if (shares.trim().isEmpty()) {sharesOutput.setText("Missing!");} else {sharesOutput.setText("");}
		
		if (datetime.trim().isEmpty()) {datetimeOutput.setText("Missing!");} else {datetimeOutput.setText("");}
		
		InsertRow.InsertPost(postid, content, author, likes, shares, datetime, username);
		
	}

}
