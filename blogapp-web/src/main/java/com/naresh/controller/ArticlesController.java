package com.naresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhuvana.dao.ArticlesDAO;
import com.bhuvana.dao.CategoryDAO;
import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.Articles;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Category;
import com.bhuvana.model.CommentDetails;
import com.bhuvana.service.ArticlesService;
import com.bhuvana.service.AuthorDetailsService;
import com.bhuvana.service.CategoryService;
import com.bhuvana.service.CommentDetailsService;

@Controller
@RequestMapping("/articles")
public class ArticlesController {
	@GetMapping("/publish")
	public String publish(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("authorid") int authorid, @RequestParam("category") String category) {
		Articles article = new Articles();
		Category category1=new Category();
		AuthorDetails userDetail=new AuthorDetails();
		userDetail.setId( authorid);
		article.setAuthorId(userDetail);
		article.setTitle(title);
		article.setContent(content);
		category1.setCategoryName(category);
		category1.setCategoryAuthorId(userDetail);
		ArticlesDAO articleDAO=new ArticlesDAO();
		CategoryDAO categoryDAO=new CategoryDAO();
		ArticlesService articleService = new ArticlesService();
		articleService.postArticleService(article, category1, articleDAO, categoryDAO);
		return "../register.jsp";
}
	@GetMapping("viewArticles")
	public String viewArticles(ModelMap modelMap, HttpSession session) {
		ArticlesService articleService=new ArticlesService();
		AuthorDetails userDetail=new AuthorDetails();
		userDetail.setId(Integer.parseInt(session.getAttribute("LOGGED_USER").toString()));
		List<Articles> articleList =articleService.provideListAllUsers();
		modelMap.addAttribute("update", 0);
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "../articlesList.jsp";
	}
	@GetMapping("update")
	public String updateArticle(HttpSession session,@RequestParam("articleId")int articleId,@RequestParam("title")String Title,@RequestParam("content")String content,ModelMap modelMap){
		ArticlesService articleService=new ArticlesService();
		Articles article=new Articles();
		article.setId(articleId);
		article.setTitle(Title);
		article.setContent(content);
		try{
		articleService.provideUpdate(article);
		}
		catch(ServiceException e){
			modelMap.addAttribute("UPDATE_ERROR",e.getMessage());
		}
		return "../articles/viewArticles";
	}
	  @GetMapping("delete")
	 	public String deleteArticle(HttpSession session,@RequestParam("articleId")int articleId,ModelMap modelMap){
	 		ArticlesService articleService=new ArticlesService();
	 		Articles article=new Articles();
	 		article.setId(articleId);
	 		try{
	 		articleService.provideDelete(article);
	 		}
	 		catch(ServiceException e){
	 			modelMap.addAttribute("DELETE_ERROR",e.getMessage());
	 		}
	 		return "../articles/viewArticles";
		}
	  @GetMapping("viewAll")
	 	public String viewAllArticles(ModelMap modelMap) {
	 		ArticlesService articleService=new ArticlesService();
	 		List<Articles> articlesList =articleService.serviceListAllArticles();
	  		modelMap.addAttribute("ARTICLES_LIST", articlesList);
	 		return "../listarticle.jsp";
	 	}
}
