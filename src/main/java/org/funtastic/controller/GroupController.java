package org.funtastic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.funtastic.entity.Group;
import org.funtastic.entity.User;
import org.funtastic.pojo.ResponsePOJO;
import org.funtastic.service.GroupService;
import org.funtastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/group")
public class GroupController {

    private static final Logger LOG = LogManager.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Group>> getAll(HttpSession session) {
        LOG.debug("GroupController#getAll");
        User user = (User) session.getAttribute("user");
        List<Group> groups = new ArrayList<>();
        if (user != null) {
            groups = user.getGroups();
        }
        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{group_id}", produces = "application/json")
    public Boolean delete(@PathVariable("group_id") Long groupId, HttpSession session) {
        LOG.debug("GroupController#getAll");
        Group group = groupService.findById(groupId);
        groupService.delete(group);
        return Boolean.TRUE;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{group_id}", produces = "application/json")
    public ResponseEntity<Group> get(@PathVariable("group_id") Long groupId, HttpSession session) {
        LOG.debug("GroupController#getAll");
        Group group = groupService.findById(groupId);
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponsePOJO> add(HttpSession session, @Valid @ModelAttribute Group group) {
        LOG.debug("GroupController#add Group: {}", group);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            user = this.userService.findById(user.getId());
            group.setCreatedBy(user.getId());
            group.setUpdatedBy(user.getId());
            // group.getGroupUsers().add(user);
            // group = this.groupService.save(group);
            user.getGroups().add(group);
            this.userService.save(user);
            return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.TRUE, ""), HttpStatus.OK);
        }
        return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.FALSE, "Invalid data for group"), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponsePOJO> addUser(HttpSession session, @RequestParam("groupId") Long groupId,
            @RequestParam("userId") Long userId) {
        LOG.debug("GroupController#addUser. Group : {} User: {}", groupId, userId);
        User loggedIn = (User) session.getAttribute("user");
        if (loggedIn != null) {
            Group eGroup = this.groupService.findById(groupId);
            if (eGroup != null) {
                User eUser = this.userService.findById(userId);
                if (eUser != null) {
                    // eGroup.getGroupUsers().add(eUser);
                    // eGroup = this.groupService.save(group);
                    eUser.getGroups().add(eGroup);
                    this.userService.save(eUser);
                    return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.TRUE, ""), HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<ResponsePOJO>(new ResponsePOJO(Boolean.FALSE, "Invalid data"), HttpStatus.BAD_REQUEST);
    }
}
