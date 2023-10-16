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

	}

	@FXML
	public void submitHandler(ActionEvent event) throws IOException {

		postidColumn.setCellValueFactory(new PropertyValueFactory<>("Postid"));
		contentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
		likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
		sharesColumn.setCellValueFactory(new PropertyValueFactory<>("Shares"));
		datetimeColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

		String numPosts = nPostsDisplayField.getText();
		String usernameFilter = filterByUsernameField.getText();

//		if (numPosts.trim().isEmpty()) {likesOutput.setText("Missing!");} 
//		else {
//			try {
//				numOfPosts  = Integer.valueOf(numPosts);
//	            if (likes < 0) {likesOutput.setText("Must be greater than 0!");}             
//	            else {
//	            	likesOutput.setText("");
//	            	likesValidity = true;
//	            }
//			} catch (NumberFormatException e) {likesOutput.setText("Must be a number!");}
//		}
//		
		String UsernameExists = DataExists.usernameExists(usernameFilter);

		if (Objects.equals(usernameFilter, UsernameExists) == true) {

			userOutput.setText("Not a User!");

		} else if (Objects.equals(usernameFilter, UsernameExists) == false) {

		}

		if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == true)) {
			postsTable.setItems(TopLikedPostsQuery.AllPosts(""));
		} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == true)) {
			postsTable.setItems(TopLikedPostsQuery.NumOfPosts(Integer.parseInt(numPosts)));
		} else if ((Objects.equals(numPosts, "") == true) && (Objects.equals(usernameFilter, "") == false)) {
			postsTable.setItems(TopLikedPostsQuery.Usernameonly(usernameFilter));
		} else if ((Objects.equals(numPosts, "") == false) && (Objects.equals(usernameFilter, "") == false)) {
			postsTable.setItems(TopLikedPostsQuery.NumOfPostsWithUsername(usernameFilter, Integer.parseInt(numPosts)));
		}

	}

}
