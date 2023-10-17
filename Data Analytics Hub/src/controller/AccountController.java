package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import view.AccountDetailsScene;
import view.EditDetailsScene;

public class AccountController implements Initializable {

	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL url, ResourceBundle resource) {

		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		try {
			borderpane.setCenter(accountDetailsScene.getScene());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void AccountDetailsHandler(ActionEvent event) throws IOException {
		AccountDetailsScene accountDetailsScene = new AccountDetailsScene();
		borderpane.setCenter(accountDetailsScene.getScene());
	}

	@FXML
	public void EditDetailsHandler(ActionEvent event) throws IOException {
		EditDetailsScene editDetailsScene = new EditDetailsScene();
		borderpane.setCenter(editDetailsScene.getScene());
	}
}