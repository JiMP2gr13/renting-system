package com.skteam.rentingsystem.dao;

import java.util.List;

import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

public interface CommentDAO {
	public void saveComment(Comment comment);

	public Comment getComment(int id);

	public List<Comment> getCommentsAboutUser(User user);

	public void deleteComment(int id);
}
