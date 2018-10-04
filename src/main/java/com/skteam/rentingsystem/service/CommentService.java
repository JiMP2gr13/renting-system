package com.skteam.rentingsystem.service;

import java.util.List;

import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

public interface CommentService {
	public void saveComment(Comment comment);

	public Comment getComment(int id);

	public List<Comment> getCommentsAboutUser(User user);

	public void deleteComment(int id);
}
