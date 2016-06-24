package org.funtastic.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		LOG.debug("Inside LoginController#get method.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginSignup");
		return mv;
	}
}
