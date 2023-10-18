package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import helpers.DataExists;
import helpers.TopLikedPostsQuery;
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

//This class serves as the controller for the top liked posts screen of the Data Analytics Hub application.
public class TopLikedPostsController implements Initializable {

	@FXML
	private TextField nPostsDisplayField, filterByUsernameField;

	@FXML
	private Label numberOutput, userOutput;

	@FXML
	private TableView<AllUsersModel> userTable;

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
	// ObservableLists to store data for the user and posts tables.
	ObservableList<PostsTableModel> Postslistview = FXCollections.observableArrayList();
	ObservableList<AllUsersModel> Userslistview = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// Setting up cell value factories for columns in the user and posts tables.
		users.setCellValueFactory(new PropertyValueFactory<>("username"));
		postidColumn.setCellValueFactory(new PropertyValueFactory<>("Postid"));
		contentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
		likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
		sharesColumn.setCellValueFactory(new PropertyValueFactory<>("Shares"));
		datetimeColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		// Populating the user table with all users and the posts table with all posts
		// initially.
		postsTable.setItems(TopLikedPostsQuery.AllPosts(""));
		userTable.setItems(TopLikedPostsQuery.AllUsers(""));

	}

	// Event handler method for the "Submit" button.
	@FXML
	public void submitHandler(ActionEvent event) throws IOException {
		// Retrieving input from the number of posts and username filter fields.
		String numPosts = nPostsDisplayField.getText();
		String usernameFilter = filterByUsernameField.getText();
		// Variables to track the validity of input values.
		boolean numPostsValidity = false;
		boolean usernameFilterValidity = false;
		// Validating the number of posts input.
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
		// Validating the username filter input.
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
		// Processing the input and updating the posts table accordingly.
		if ((numPostsValidity == true) && (usernameFilterValidity == true)) {
			// Show all posts if both fields empty.
			if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == true)) {
				postsTable.setItems(TopLikedPostsQuery.AllPosts(""));
				// Show chosen number of posts, but show all users.
			} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == true)) {
				postsTable.setItems(TopLikedPostsQuery.NumOfPosts(Integer.parseInt(numPosts)));
				// Show specific users posts.
			} else if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == false)) {
				postsTable.setItems(TopLikedPostsQuery.Usernameonly(usernameFilter));
				// Show specific number of posts and for a specific user.
			} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == false)) {
				postsTable.setItems(
						TopLikedPostsQuery.NumOfPostsWithUsername(usernameFilter, Integer.parseInt(numPosts)));
			}
		}

	}

}
