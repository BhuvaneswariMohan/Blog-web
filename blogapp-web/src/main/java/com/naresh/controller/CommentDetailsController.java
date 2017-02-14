//package com.naresh.controller;
//
//
//	import org.springframework.stereotype.Controller;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.RequestMapping;
//	import org.springframework.web.bind.annotation.RequestParam;
//
//import com.bhuvana.exception.ServiceException;
//import com.bhuvana.model.Articles;
//import com.bhuvana.model.AuthorDetails;
//import com.bhuvana.model.CommentDetails;
//import com.bhuvana.service.AuthorDetailsService;
//import com.bhuvana.service.CommentDetailsService;
//
//
//
//	@Controller
//	@RequestMapping("/comment")
//	public class CommentDetailsController{
//		CommentDetails comment = new CommentDetails();
//		CommentDetailsService commentService = new CommentDetailsService();
//
//		@GetMapping("/save")
//		public String store(@RequestParam("comment") String comments, @RequestParam("id") int articleId,
//				@RequestParam("userId") int userId) {
//			Articles article = new Articles();
//			AuthorDetailsService userService = new AuthorDetailsService();
//			AuthorDetails user = new AuthorDetails();
//			article.setId(articleId);
//			user.setId(userId);
//			comment.setCommentArticleId(article);
//			comment.setCommentText(comments);
//			comment.setCommentUserId(user);
//			try {
//				user.setEmailId(userService.functionGetUserEmail(userId));
//				user.setUserName(userService.functionGetUserName(userId));
//				commentService.saveService(comment);
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}
//			return "redirect:../articles/other?userId=" + userId;
//		}
//	}
//
