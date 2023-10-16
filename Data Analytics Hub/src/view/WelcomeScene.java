package view;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class WelcomeScene {
	
	public String getTitle() {
		return "Welcome to Data Analytics Hub";
	}
	
	public Scene getScene() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Welcome_GUI.fxml"));

		GridPane pane = null;
		
		pane = loader.load();

		Scene scene = new Scene(pane);
		
		return scene;
		
		
	}

}
