package org.funtastic.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.pojo.UserDTO;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		LOG.debug("Inside LoginController#get method.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginSignup");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String auth(HttpSession session, @ModelAttribute UserDTO userDTO) {
		LOG.debug("Inside LoginController#auth method. User is: {}", userDTO);
		User user = this.userService.findByEmail(userDTO.getEmail());
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getPassword().equals(userDTO.getPassword())) {
			session.setAttribute("user", user);
			return "redirect:/dashboard";
		}
		return "redirect:/login";
	}
}
