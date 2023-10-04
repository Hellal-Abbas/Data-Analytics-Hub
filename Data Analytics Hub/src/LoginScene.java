import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class LoginScene {
	
	public String getTitle() {
		return "Data Analytics Hub Login";
	}
	
	public Scene getScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_GUI.fxml"));
		
		GridPane pane = null;
		
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(pane);
		
		return scene;
		
	}

	public static void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	public static void setScene(Scene scene) {
		// TODO Auto-generated method stub
		
	}

}
