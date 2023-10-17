package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import database.DataSingleton;
import database.TopLikedPostsQuery;
import helpers.DataExists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AllUsersModel;
import model.PostsTableModel;

public class TopLikedPostsController implements Initializable {

	private String username;

	@FXML
	private TextField nPostsDisplayField;

	@FXML
	private TextField filterByUsernameField;

	@FXML
	private TableView<AllUsersModel> userTable;

	@FXML
	private Label numberOutput;

	@FXML
	private Label userOutput;

	@FXML
	private TableColumn<AllUsersModel, String> users;

	@FXML
	private TableView<PostsTableModel> postsTable;

	@FXML
	private TableColumn<PostsTableModel, Integer> postidColumn;

	@FXML
	private TableColumn<PostsTableModel, String> contentColumn;

	@FXML
	private TableColumn<PostsTableModel, String> authorColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> likesColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> sharesColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> datetimeColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> usernameColumn;

	ObservableList<PostsTableModel> Postslistview = FXCollections.observableArrayList();
	ObservableList<AllUsersModel> Userslistview = FXCollections.observableArrayList();

	DataSingleton dataSingleton = DataSingleton.getInstance();

	@Override
	public void initialize(URL url, ResourceBundle resource) {

		username = dataSingleton.getUsername();

		users.setCellValueFactory(new PropertyValueFactory<>("username"));

		userTable.setItems(TopLikedPostsQuery.AllUsers(""));

		postidColumn.setCellValueFactory(new PropertyValueFactory<>("Postid"));
		contentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
		likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
		sharesColumn.setCellValueFactory(new PropertyValueFactory<>("Shares"));
		datetimeColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

		postsTable.setItems(TopLikedPostsQuery.AllPosts(""));

	}

	@FXML
	public void submitHandler(ActionEvent event) throws IOException {

		String numPosts = nPostsDisplayField.getText();
		String usernameFilter = filterByUsernameField.getText();

		boolean numPostsValidity = false;
		boolean usernameFilterValidity = false;

		if (Objects.equals(numPosts, "") == true) {
			numberOutput.setText("");
			numPostsValidity = true;
		} else {
			try {
				int numOfPosts = Integer.valueOf(numPosts);
				if (numOfPosts < 0) {
					numberOutput.setText("Must be positive!");
				} else {
					numberOutput.setText("");
					numPostsValidity = true;
				}
			} catch (NumberFormatException e) {
				numberOutput.setText("Number Required");
			}
		}

		String UsernameExists = DataExists.usernameExists(usernameFilter);

		if (Objects.equals(usernameFilter, "") == true) {
			userOutput.setText("");
			usernameFilterValidity = true;
		} else if (Objects.equals(usernameFilter, UsernameExists) == false) {
			userOutput.setText("User not in records!");
			usernameFilterValidity = false;
		} else if (Objects.equals(usernameFilter, UsernameExists) == true) {
			userOutput.setText("");
			usernameFilterValidity = true;
		}

		if ((numPostsValidity == true) && (usernameFilterValidity == true)) {
			if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == true)) {
				postsTable.setItems(TopLikedPostsQuery.AllPosts(""));
			} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == true)) {
				postsTable.setItems(TopLikedPostsQuery.NumOfPosts(Integer.parseInt(numPosts)));
			} else if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == false)) {
				postsTable.setItems(TopLikedPostsQuery.Usernameonly(usernameFilter));
			} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == false)) {
				postsTable.setItems(
						TopLikedPostsQuery.NumOfPostsWithUsername(usernameFilter, Integer.parseInt(numPosts)));
			}
		}

	}

}
