package com.nathan.userManagement.beans;

import java.sql.Timestamp;

public class Post {

	int postId;
	int userId;
	String content;
	Timestamp createdAt;

	public Post() {
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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
		return "Post [postId=" + postId + ", userId=" + userId + ", content=" + content + ", createdAt=" + createdAt
				+ "]";
	}
}
