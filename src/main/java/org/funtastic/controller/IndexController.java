package org.funtastic.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

	private static final Logger LOG = LogManager.getLogger(IndexController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getIndexPage() {
		LOG.debug("Inside IndexController#getIndexPage method.");
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
}
