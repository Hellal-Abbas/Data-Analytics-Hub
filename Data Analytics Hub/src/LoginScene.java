import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class LoginScene {
	
	public String getTitle() {
		return "Data Analytics Hub Login";
	}
	
	public Scene getScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_GUI.fxml"));
		
		GridPane pane = null;
		
		pane = loader.load();

		Scene scene = new Scene(pane);
		
		return scene;
		
	}

}
