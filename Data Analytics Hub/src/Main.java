import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage loginStage) throws IOException {
		
		LoginScene login = new LoginScene();
		
		loginStage.setTitle(login.getTitle());
		loginStage.setScene(login.getScene());
		loginStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
