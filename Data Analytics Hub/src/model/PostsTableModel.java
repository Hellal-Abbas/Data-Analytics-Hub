package model;

public class PostsTableModel {

	int postid, likes, shares;

	String content, author, datetime, username;

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

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
