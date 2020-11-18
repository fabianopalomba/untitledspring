package com.fegh.springata.controller;

import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import com.fegh.springata.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/login")
	public ModelAndView displayLoginForm() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("headerMessage", "Show login form");
		mv.addObject("user", new User());
		return mv;
	}

	@PostMapping(value = "/login")
	public ModelAndView loginUser(@ModelAttribute User user, HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/home");
		if(userService.validate(user.getEmail(),user.getPassword())){
			session.setAttribute("email", user.getEmail());
		}
		else {
			mv.addObject("message","login failed");
			mv.addObject("email","");
		}
		return mv;
	}

	@GetMapping(value = {"/addUser","/editUser"})
	public ModelAndView displayNewUserForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("email") == null){
			mv.setViewName("addUser");
			mv.addObject("headerMessage", "Add User Details");
			mv.addObject("user", new User()); }
		else {
			User user = userService.userByEmail((String)session.getAttribute("email"));
			mv.setViewName("editUser");
			mv.addObject("headerMessage", "Edit User Details");
			mv.addObject("user", user);

		}
		return mv;
	}

	@PostMapping(value = {"/addUser","/editUser"})
	public ModelAndView saveNewUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		if(session.getAttribute("email") == null) {
			if(result.hasErrors()) { mv.setViewName("addUser"); return mv;}
			userService.Insert(user);
			session.setAttribute("email", user.getEmail());
			mv.addObject("message", "New user successfully added");
		} else {
			if (result.hasErrors()){ mv.setViewName("editUser"); return mv;}
			mv.addObject("headerMessage", "User edited");
			userService.Update(user);
		}
		return mv;
	}

	@GetMapping(value = "/deleteUser")
	public ModelAndView deleteUserById(HttpSession session) {
		userService.DeleteByEmail((String)session.getAttribute("email"));
		ModelAndView mv = new ModelAndView("redirect:/index");
		session.removeAttribute("email");
		mv.addObject("headerMessage", "User deleted");
		return mv;
	}

	@GetMapping(value = "/viewUser")
	public ModelAndView displayUserData(@ModelAttribute String email, HttpSession session) {
		ModelAndView mv = new ModelAndView("viewUser");
		User user = userService.userByEmail(((String)session.getAttribute("email")));
		System.out.println(session.getAttribute("email"));
		List<Rent> rents = userService.rentByEmail(((String)session.getAttribute("email")));
		mv.addObject("headerMessage", "Edit User Details");
		mv.addObject("user", user);
		mv.addObject("rents",rents);
		return mv;
	}
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/index");
		session.removeAttribute("email");
		mv.addObject("headerMessage", "Logout successful");
		return mv;
	}

}
