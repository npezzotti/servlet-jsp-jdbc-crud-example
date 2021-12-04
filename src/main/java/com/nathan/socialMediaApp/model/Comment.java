package com.nathan.socialMediaApp.model;

import java.sql.Timestamp;

public class Comment {

	int id;
	int userId;
	int postId;
	String content;
	Timestamp createdAt;
	
	public Comment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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
		return "Comment [id=" + id + ", userId=" + userId + ", postId=" + postId + ", content=" + content
				+ ", createdAt=" + createdAt + "]";
	}
}
