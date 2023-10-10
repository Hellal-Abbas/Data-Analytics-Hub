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
	}

}
