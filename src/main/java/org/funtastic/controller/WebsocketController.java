package org.funtastic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebsocketController {

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public void httpGreet(String text) {
        System.out.println("============HttpGreet=============");
        System.out.println(text + "=========text============");
    }

}
