package com.nibrahim.blog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nibrahim.blog.dao.ArticleDao;
import com.nibrahim.blog.entity.Article;


@Repository
public class ArticleImpl implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory ;
	
	@Transactional
	public void create(Article article) {
		getSessionFactory().save(article);
	}

	@Transactional
	public void delete(Article article) {
		getSessionFactory().delete(article);
	}

	@Transactional
	public List<Article> getAll() {
		Criteria crt = getSessionFactory().createCriteria(Article.class);
		@SuppressWarnings("unchecked")
		List<Article> list = (List<Article>)crt.list();
		return list;
	}
		
	@Transactional
	public Session getSessionFactory() {
		return sessionFactory.openSession();
	}
	
	@Transactional
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
