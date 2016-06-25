package org.funtastic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.funtastic.entity.User;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> getAll(HttpSession session) {
        List<User> users = new ArrayList<>();
        users = userService.getAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

}
