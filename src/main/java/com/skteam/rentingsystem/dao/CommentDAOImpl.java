package com.skteam.rentingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(comment);
	}

	@Override
	public Comment getComment(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Comment.class, id);
	}

	@Override
	public List<Comment> getCommentsAboutUser(User user) {
		Session session = sessionFactory.getCurrentSession();
        Query<Comment> query = session.createQuery("select c from comment c where c.owner.login=:ownerLogin",
				Comment.class);
        query.setParameter("ownerLogin", user.getUsername());
		return query.getResultList();
	}

	@Override
	public void deleteComment(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
        Query query = session.createQuery("delete from comment c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
