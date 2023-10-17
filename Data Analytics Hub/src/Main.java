import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import view.WelcomeScene;

public class Main extends Application {

	// Primary Stage that starts the application;
	// Shows the welcome window
	public void start(Stage WelcomeStage) throws IOException {

		WelcomeScene welcome = new WelcomeScene();
		WelcomeStage.setTitle(welcome.getTitle());
		WelcomeStage.setScene(welcome.getScene());
		WelcomeStage.show();

	}

	// Main that starts the Data Analytics Hub
	public static void main(String[] args) {
		launch(args);
	}

}