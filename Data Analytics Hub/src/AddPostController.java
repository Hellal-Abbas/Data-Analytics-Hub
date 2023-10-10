import java.io.IOException;
import java.util.Objects;

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
		
		String postidfield = postidField.getText(); String contentfield = contentField.getText();
		String authorfield = authorField.getText(); String likesfield = likesField.getText();
		String sharesfield = sharesField.getText(); String datetimefield = datetimeField.getText();
		
		int postid = 0; String content = null; String author = null; 
		int likes = 0; int shares = 0; String datetime = null;
		
		boolean postidValidity = false; boolean contentValidity = false; boolean authorValidity = false;
		boolean likesValidity = false; boolean sharesValidity = false; boolean datetimeValidity = false;
		
		if (postidfield.trim().isEmpty()) {postidOutput.setText("Missing!");} 
		else {
			try {
			    postid  = Integer.valueOf(postidfield);
			    String postidExists = DataExists.postidExists(postidfield);
				
	            if (postid < 0) {postidOutput.setText("Must be greater than 0!");}
	            else if (Objects.equals(postidfield, postidExists) == true) {postidOutput.setText("PostID Taken!");}
	            else {
	            	postidOutput.setText("");
	            	postidValidity = true;
	            }				
			} catch (NumberFormatException e) {postidOutput.setText("Must be a number!");}
		}
		
		if (contentfield.trim().isEmpty()) {contentOutput.setText("Missing!");} 
		else {
			contentOutput.setText("");
			content = contentfield;
			contentValidity = true;}
		
		if (authorfield.trim().isEmpty()) {authorOutput.setText("Missing!");} 
		else {
			authorOutput.setText("");
			author = authorfield;
			authorValidity = true;}
		
		if (likesfield.trim().isEmpty()) {likesOutput.setText("Missing!");} 
		else {
			try {
				likes  = Integer.valueOf(likesfield);
	            if (likes < 0) {likesOutput.setText("Must be greater than 0!");}             
	            else {
	            	likesOutput.setText("");
	            	likesValidity = true;
	            }
			} catch (NumberFormatException e) {likesOutput.setText("Must be a number!");}
		}
		
		if (sharesfield.trim().isEmpty()) {sharesOutput.setText("Missing!");} 
		else {
			try {
				shares  = Integer.valueOf(sharesfield);
	            if (shares < 0) {sharesOutput.setText("Must be greater than 0!");}	            
	            else {
	            	sharesOutput.setText("");
	            	sharesValidity = true;
	            }
				
			} catch (NumberFormatException e) {sharesOutput.setText("Must be a number!");}
		}
		
		if (datetimefield.trim().isEmpty()) {datetimeOutput.setText("Missing!");} 
		else {
			if (DateTimeCheck.CheckValidity(datetimefield) == false) {datetimeOutput.setText("Incorrect Format!");}
			else if (DateTimeCheck.CheckValidity(datetimefield) == true) {
				datetimeOutput.setText("");
				datetime = datetimefield;
				datetimeValidity = true;}
			}
			
		if ((postidValidity)&&(contentValidity)&&(authorValidity)&&(likesValidity)&&(sharesValidity)&&(datetimeValidity)) {
			InsertRow.InsertPost(postid, content, author, likes, shares, datetime, username);
			postaddedOutput.setText("Post Added!");
		}		
	}
}


