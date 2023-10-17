package model;

//This class represents a model for storing post-related information.
public class PostsTableModel {

	int postid, likes, shares;

	String content, author, datetime, username;

	// Constructor for initializing the PostsTableModel object with post-related
	// information.
	public PostsTableModel(int postid, String content, String author, int likes, int shares, String datetime,
			String username) {
		this.postid = postid;
		this.content = content;
		this.author = author;
		this.likes = likes;
		this.shares = shares;
		this.datetime = datetime;
		this.username = username;
	}

	// Getter method to retrieve the post ID.
	public int getPostid() {
		return postid;
	}

	// Setter method to update the post ID with a new value.
	public void setPostid(int postid) {
		this.postid = postid;
	}

	// Getter method to retrieve the content.
	public String getContent() {
		return content;
	}

	// Setter method to update the content with a new value.
	public void setContent(String content) {
		this.content = content;
	}

	// Getter method to retrieve the author.
	public String getAuthor() {
		return author;
	}

	// Setter method to update the author with a new value.
	public void setAuthor(String author) {
		this.author = author;
	}

	// Getter method to retrieve the likes.
	public int getLikes() {
		return likes;
	}

	// Setter method to update the likes with a new value.
	public void setLikes(int likes) {
		this.likes = likes;
	}

	// Getter method to retrieve the shares.
	public int getShares() {
		return shares;
	}

	// Setter method to update the shares with a new value.
	public void setShares(int shares) {
		this.shares = shares;
	}

	// Getter method to retrieve the date time.
	public String getDatetime() {
		return datetime;
	}

	// Setter method to update the date time with a new value.
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	// Getter method to retrieve the username.
	public String getUsername() {
		return username;
	}

	// Setter method to update the username with a new value.
	public void setUsername(String username) {
		this.username = username;
	}
}
