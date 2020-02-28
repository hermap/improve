package com.pzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/user/getUser")
    public List<String> getUser() {
        return new ArrayList(){{
           add("userName:Herman Peng");
           add("telephone:17862700000");
           add("email:17862700000@163.com");
        }};
    }
}
