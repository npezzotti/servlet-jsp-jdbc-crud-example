package com.nathan.socialMediaApp.model;

import java.sql.Timestamp;

public class Post {

	int id;
	int userId;
	String content;
	Timestamp createdAt;

	public Post() {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setPostId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
}
