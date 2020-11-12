package com.fegh.springata.controller;

import com.fegh.springata.entity.User;
import com.fegh.springata.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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

	@GetMapping(value = "/addUser")
	public ModelAndView displayNewUserForm() {
		ModelAndView mv = new ModelAndView("addUser");
		mv.addObject("headerMessage", "Add User Details");
		mv.addObject("user", new User());
		return mv;
	}

	@PostMapping(value = "/addUser")
	public ModelAndView saveNewUser(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		userService.Inserisci(user);
		mv.addObject("message", "New user successfully added");
		return mv;
	}

	@GetMapping(value = "/editUser/{name}")
	public ModelAndView displayEditUserForm(@PathVariable String name) {
		ModelAndView mv = new ModelAndView("/editUser");
		User user = userService.userByEmail(name);
		mv.addObject("headerMessage", "Edit User Details");
		mv.addObject("user", user);
		return mv;
	}

	@PostMapping(value = "/editUser/{name}")
	public ModelAndView saveEditedUser(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("headerMessage", "User edited");
		userService.Aggiorna(user);
		return mv;
	}

	@GetMapping(value = "/deleteUser/{name}")
	public ModelAndView deleteUserById(@PathVariable String name) {
		userService.eliminaByEmail(name);
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("headerMessage", "User deleted");
		return mv;
	}

}
