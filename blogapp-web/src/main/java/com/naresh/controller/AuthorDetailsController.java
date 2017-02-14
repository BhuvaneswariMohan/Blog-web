package com.naresh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhuvana.exception.ServiceException;
import com.bhuvana.model.AuthorDetails;
import com.bhuvana.model.Roles;
import com.bhuvana.service.AuthorDetailsService;

@Controller
@RequestMapping("/users")
public class AuthorDetailsController {
	private AuthorDetails user = new AuthorDetails();

	private AuthorDetailsService userService = new AuthorDetailsService();

	@GetMapping
	public String index(ModelMap modelMap) {
		List<AuthorDetails> userList = userService.provideListAllUsers();
		modelMap.addAttribute("USER_LIST", userList);
		return "userlist.jsp";
}
	@GetMapping("/save")
	public String store(@RequestParam("Name") String name,@RequestParam("Password") String password,
			@RequestParam("Emailid") String emailid,@RequestParam("Roleid") int role){
		user.setName(name);
		user.setPassword(password);
		user.setEmailid(emailid);
		Roles roleid=new Roles();
		roleid.setId(role);
		user.setRole(roleid);

		try {
			userService.provideSave(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "redirect:../";
	}
	@GetMapping("/login")
	public String store(@RequestParam("Emailid") String emailid, @RequestParam("password") String password) {
		user.setEmailid(emailid);
		user.setPassword(password);
		
		try {
			Integer authorid=userService.provideLogin(user);
			return "redirect:../publisharticle.jsp?authorid="+authorid;
		} catch (ServiceException e) {
			e.printStackTrace();
			return "redirect:../register.jsp";
		}
	
		
	}
}