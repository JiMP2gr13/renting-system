package com.skteam.rentingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skteam.rentingsystem.dao.CommentDAO;
import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Transactional
	@Override
	public void saveComment(Comment comment) {
		commentDAO.saveComment(comment);
	}

	@Transactional
	@Override
	public Comment getComment(int id) {
		return commentDAO.getComment(id);
	}

	@Transactional
	@Override
	public List<Comment> getCommentsAboutUser(User user) {
		return commentDAO.getCommentsAboutUser(user);
	}

	@Transactional
	@Override
	public void deleteComment(int id) {
		commentDAO.deleteComment(id);
	}

}
