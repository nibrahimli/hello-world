package com.nibrahim.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nibrahim.blog.dao.ArticleDao;
import com.nibrahim.blog.entity.Article;

@Controller
public class HelloWorldController {
	
	@Autowired
	ArticleDao articleDao;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView wellcome(ModelAndView mav){
		
		List<Article> listArticle = articleDao.getAll(); 
		mav.addObject("message", "Wellcome to my blog, it's nibrahimli's blog. We'll talk about Testing Git push method");
		mav.addObject("listArticle", listArticle);
		mav.setViewName("/index");
		return mav ;		
	}
	
	
	@RequestMapping(value="/newArticle", method=RequestMethod.GET)
	public String addArticle(){
		Article article = new Article();
		
		article.setTitle("A1");
		article.setResume("How to use Git");
		article.setText("we'l see this topic");
		
		articleDao.create(article);
		
		return "redirect:/";
	}
	
	
	
	
	
}
