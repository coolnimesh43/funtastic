package org.funtastic.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.pojo.UserDTO;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/signup")
public class SignupController {

	private static Logger LOG = LogManager.getLogger(SignupController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute UserDTO user, BindingResult bindingResult) {
		LOG.debug("Inside SignupController#create method. User is : {}", user);
		ModelAndView mv = new ModelAndView();
		boolean isValid = this.userService.validateUser(user) || bindingResult.hasErrors();
		if (isValid) {
			User newUser = this.userService.create(user);
			if (newUser != null) {
				mv.setViewName("dashboard");
				mv.addObject("user", newUser);
			}
		}
		mv.addObject("error", Boolean.TRUE);
		mv.setViewName("signup");
		return mv;
	}
}
