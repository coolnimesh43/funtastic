/**
 * 
 */
package org.funtastic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.User;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author eyeshield
 *
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

	private static final Logger LOG = LogManager.getLogger(DashboardController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpSession session) {
		LOG.debug("Inside DashboardController#get method.");
		ModelAndView mv = new ModelAndView("loginSignup");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user = this.userService.findById(user.getId());
			List<Group> groups = user.getGroups();
			// Group currentGroup = !groups.isEmpty() ? groups.get(0) : null;
			// List<Status> groupStatus = new ArrayList<>();
			// if (currentGroup != null) {
			// List<User> gUsers = currentGroup.getGroupUsers();
			// for (User u : gUsers) {
			// groupStatus.addAll(this.statusService.findAllByUser(u.getId()));
			// }
			// }
			mv.setViewName("management");
			mv.addObject("user", user);
			// mv.addObject("statuses",
			// this.statusService.findAllByUser(user.getId()));
			mv.addObject("groups", groups);
			// mv.addObject("statuses", groupStatus);
		}
		return mv;
	}

}
