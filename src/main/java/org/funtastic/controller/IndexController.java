package org.funtastic.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.User;
import org.funtastic.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	private static final Logger LOG = LogManager.getLogger(IndexController.class);

	@Autowired
	private UserAuthService userAuthService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		LOG.debug("Inside IndexController#getIndexPage method.");
		ModelAndView mv = new ModelAndView();
		User loggedInUser = this.userAuthService.getLoggedInUser();
		if (loggedInUser == null) {
			mv.setViewName("loginSignup");
		}
		mv.setViewName("dashboard");
		mv.addObject("user", loggedInUser);
		return mv;
	}
}
