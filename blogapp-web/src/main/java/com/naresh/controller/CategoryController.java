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
import com.bhuvana.service.AuthorDetailsService;
import com.bhuvana.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	CategoryService categoryService = new CategoryService();

	@GetMapping("/list")
	public String index(ModelMap modelMap, @RequestParam("userId") int userId) {
		List<Category> categoryList = categoryService.listByUserIdService(userId);
		modelMap.addAttribute("CATEGORY_LIST", categoryList);
		return "../categorylist.jsp";
	}

	@GetMapping("/publish")
	public String publish(@RequestParam("category") String category, @RequestParam("userId") int userId,
			@RequestParam("title") String title) {
		AuthorDetailsService service = new AuthorDetailsService();
		String userName = null;
		Category category = new Category();
		category.setName(category);
		AuthorDetails user = new AuthorDetails();
		user.setId(userId);
		category.setId(user);
		Articles article = new Articles();
		article.setTitle(title);
		article.setId(user);
		try {
			userName = service.functionGetUserName(userId);
			categoryService.insertCategory(article, cate);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "../articles/user?userName=" + userName;
	}

}
