package com.naresh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private Articles article = new Articles();

	private ArticlesService articleService = new ArticlesService();
/*
	@GetMapping
	public String index(ModelMap modelMap) {
		List<Articles> articleList;
		articleList = articleService.provideListAllUsers();
		CategoryService categoryService = new CategoryService();
		List<Category> categoryList = categoryService.provideListAllCategories();
		modelMap.addAttribute("CATEGORY_LIST", categoryList);
		modelMap.addAttribute("update", 0);
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "articlelist.jsp";
	}

	@GetMapping("viewbycategory")
	public String indexByCategory(ModelMap modelMap, @RequestParam("category") String category) {
		CategoryService categoryService = new CategoryService();
		List<Articles> articleList = categoryService.viewByCategoryService(category);
		modelMap.addAttribute("update", 0);
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "../articlelist.jsp";
	}

	@GetMapping("comments")
	public String indexComments(ModelMap modelMap, @RequestParam("articleId") int articleId) {
		CommentDetailsService commentService = new CommentDetailsService();
		List<CommentDetails> commentList = commentService.listByArticleIdService(articleId);
		modelMap.addAttribute("update", 0);
		modelMap.addAttribute("COMMENT_LIST", commentList);
		return "../commentlist.jsp";
	}

	@GetMapping("/other")
	public String indexOtherUsers(ModelMap modelMap, @RequestParam("userId") int userId) {
		List<Articles> articleList = null;
		try {
			articleList = articleService.listOtherUserService(userId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("update", 0);
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "../articlelist.jsp";
	}

	@GetMapping("/user")
	public String index(ModelMap modelMap, @RequestParam("userName") String name) {
		AuthorDetailsService userService = new AuthorDetailsService();
		List<Articles> articleList = null;
		int roleId = 0;
		int userId = 0;
		try {
			roleId = userService.functionGetRoleId(name);
			userId = userService.functionGetUserId(name);
			articleList = articleService.listByUserService(userService.functionGetUserId(name));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("roleId", roleId);
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("update", 1);
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "../articlelist.jsp";
	}

	@GetMapping("/publish")
	public String publish(@RequestParam("title") String name, @RequestParam("content") String content,
			@RequestParam("userId") int userId) {
		article.setTitle(name);
		article.setContent(content);

		AuthorDetails user = new AuthorDetails();
		user.setId(userId);
		article.setAuthorId(user);
		try {

			articleService.postArticlesService(article, user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "../publishcategory.jsp";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") int id) {
		article.setId(id);
		article.getId();
		return "../updatearticle.jsp";
	}

	@GetMapping("/updateArticle")
	public String update(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("articleId") int articleId) {
		article.setTitle(title);
		article.setContent(content);
		article.setId(articleId);
		String userName = articleService.getUserIdByArticleId(articleId);
		try {
			articleService.updateByIdService(article);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "redirect:../articles/user?userName=" + userName;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		article.setId(id);
		String userName = articleService.getUserIdByArticleId(id);
		try {
			articleService.deleteArticleService(article);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "redirect:../articles/user?userName=" + userName;
	}*/

}
