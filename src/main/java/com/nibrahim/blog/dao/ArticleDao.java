package com.nibrahim.blog.dao;

import java.util.List;

import com.nibrahim.blog.entity.Article;


public interface ArticleDao {
	
	public void create(Article article);
	public void delete(Article article);
	public List<Article> getAll();

}
