package com.github.kotall.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zpwang
 * @version 1.0.0
 */
@RestController
public class UserController {

    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }

//    @GetMapping("/user")
//    public Principal user(Principal user){
//        return user;
//    }

    @GetMapping("/hello")
    public String Hello() {
        return "hello word!";
    }
}
