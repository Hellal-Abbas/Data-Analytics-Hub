import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class AccountController {
	
	@FXML
	private BorderPane borderpane;
	
	@FXML
	public void AccountDetailsHandler(ActionEvent event) throws IOException {	
		
		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		borderpane.setCenter(accountDetailsScene.getScene());
		
	}
	
	@FXML
	public void EditDetailsHandler(ActionEvent event) throws IOException {		
		


	}

}
