package org.funtastic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Status;
import org.funtastic.entity.User;
import org.funtastic.pojo.ResponsePOJO;
import org.funtastic.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/status")
public class StatusController {

	private static final Logger LOG = LogManager.getLogger(StatusController.class);

	@Autowired
	private StatusService statusService;

	public ModelAndView get(HttpSession session) {
		LOG.debug("StatusController#get");
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		List<Status> statusList = new ArrayList<>();
		if (user != null) {
			statusList = this.statusService.findAllByUser(user.getId());
		}
		mv.setViewName("dashboard");
		mv.addObject("statuses", statusList);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponsePOJO> add(HttpSession session, @ModelAttribute Status status) {
		LOG.debug("StatusController#add");
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Status saved = this.statusService.save(status);
			if (saved != null) {
				return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.TRUE, ""), HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.FALSE, "Invalid status data"),
				HttpStatus.BAD_REQUEST);
	}
}
