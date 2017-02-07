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
import com.bhuvana.service.RolesService;

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

//	@GetMapping("/save")
//	public String store(@RequestParam("userName") String name, @RequestParam("password") String password,
//			@RequestParam("emailId") String emailid) {
//		user.setName(name);
//		user.setPassword(password);
//		user.setEmailid(emailid);
//		try {
//			userService.provideSave(user);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		return "redirect:../";
//	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam("id") int id) {
//		user.setId(id);
//		try {
//			userService.provideDelete(id);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		return "redirect:../users";
//	}
//
//	@GetMapping("/update")
//	public String update(ModelMap modelMap, @RequestParam("id") int id) {
//		user.setId(id);
//		RolesService roleService = new RolesService();
//		List<Roles> roleList = roleService.listService();
//		modelMap.addAttribute("ROLE_LIST", roleList);
//		return "../updateuser.jsp";
//	}
//
//	@GetMapping("/updateUser")
//	public String update(@RequestParam("userName") String name, @RequestParam("password") String password,
//			@RequestParam("emailId") String emailid, @RequestParam("role") int roleId) {
//		user.setName(name);
//		user.setPassword(password);
//		user.setEmailid(emailid);
//		Roles role = new Roles();
//		role.setId(roleId);
//		user.setRole(role);
//		try {
//			userService.provideUpdate(user);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		return "redirect:../users";
//	}
//
//	@GetMapping("/login")
//	public String store(@RequestParam("userName") String name, @RequestParam("password") String password) {
//		user.setName(name);
//		user.setPassword(password);
//		boolean result = false;
//		int roleid = 0;
//		try {
//			roleid = userService.functionGetRoleId(name);
//			result = userService.functionLoginService(user);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		if (result) {
//			if (roleid == 1) {
//				return "redirect:../users";
//
//			} else {
//				return "redirect:../articles/user?userName=" + name;
//			}
//		} else
//			return "redirect:../?success=0";
//	}
}
