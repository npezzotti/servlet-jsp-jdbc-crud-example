package com.nathan.userManagement.dao;

import java.util.List;

import com.nathan.userManagement.beans.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getCommentsByPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createComment(int userId, int postId, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateComment(String content, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
