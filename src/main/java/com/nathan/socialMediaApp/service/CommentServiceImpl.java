package com.nathan.socialMediaApp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nathan.socialMediaApp.dao.CommentDaoImpl;
import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.model.Post;

public class CommentServiceImpl implements CommentService {

	private CommentDaoImpl commentDaoImpl = new CommentDaoImpl();

	@Override
	public List<Comment> getCommentsByPost(Post post) {
		List<Comment> comments = new ArrayList<Comment>();
		try {
			comments = commentDaoImpl.getCommentsByPost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public boolean createComment(Comment comment) {
		boolean created = false;
		try {
			created = commentDaoImpl.createComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public boolean updateComment(Comment comment) {
		boolean updated = false;
		try {
			updated = commentDaoImpl.updateComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		boolean deleted = false;
		try {
			commentDaoImpl.deleteComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}

}
