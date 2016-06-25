package org.funtastic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.Status;
import org.funtastic.entity.User;
import org.funtastic.pojo.ResponsePOJO;
import org.funtastic.service.GroupService;
import org.funtastic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/status")
public class StatusController {

	private static final Logger LOG = LogManager.getLogger(StatusController.class);

	@Autowired
	private StatusService statusService;

	@Autowired
	private GroupService groupService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Status>> get(HttpSession session, @RequestParam("groupId") Long groupId) {
		LOG.debug("StatusController#get");
		Group group = this.groupService.findById(groupId);
		LOG.debug("Group is: {}", group);
		if (group != null) {
			List<Status> status = new ArrayList<>();
			List<User> gUsers = group.getGroupUsers();
			for (User u : gUsers) {
				status.addAll(this.statusService.findAllByUser(u.getId()));
			}
			return new ResponseEntity<List<Status>>(status, HttpStatus.OK);
		}

		return new ResponseEntity<List<Status>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponsePOJO> add(HttpSession session, @ModelAttribute Status status) {
		LOG.debug("StatusController#add");
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			status.setCreatedBy(user.getId());
			status.setUpdatedBy(user.getId());
			Status saved = this.statusService.save(status);
			if (saved != null) {
				return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.TRUE, ""), HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.FALSE, "Invalid status data"),
				HttpStatus.BAD_REQUEST);
	}
}
