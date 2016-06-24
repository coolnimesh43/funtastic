package org.funtastic.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	private static final Logger LOG = LogManager.getLogger(DashboardController.class);

	@Autowired
	private UserAuthService userAuthService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		LOG.debug("Inside DashboardController#get method.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		mv.addObject("user", this.userAuthService.getLoggedInUser());
		return mv;
	}
}