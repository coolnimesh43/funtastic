package org.funtastic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.User;
import org.funtastic.service.StatusService;
import org.funtastic.service.UserService;
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
	private StatusService statusService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpSession session) {
		LOG.debug("Inside DashboardController#get method.");
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		user = this.userService.findById(user.getId());
		List<Group> groups = user.getGroups();
		mv.setViewName("dashboard");
		mv.addObject("user", user);
		mv.addObject("statuses", this.statusService.findAllByUser(user.getId()));
		mv.addObject("groups", groups);
		return mv;
	}
}
