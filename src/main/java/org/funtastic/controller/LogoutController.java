package org.funtastic.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/logout")
@Secured("IS_AUTHENTICATED_FULLY")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(Boolean.FALSE);
		return "redirect:/login";
	}
}
