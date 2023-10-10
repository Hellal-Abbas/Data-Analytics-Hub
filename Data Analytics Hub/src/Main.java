import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void start(Stage WelcomeStage) throws IOException {
		
		WelcomeScene welcome = new WelcomeScene();
		WelcomeStage.setTitle(welcome.getTitle());
		WelcomeStage.setScene(welcome.getScene());
		WelcomeStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
