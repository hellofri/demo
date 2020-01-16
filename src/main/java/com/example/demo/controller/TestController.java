package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * https://blog.csdn.net/bicheng4769/article/details/86668209
 */
@RequestMapping("/test")
@Controller
public class TestController {
    @RequiresPermissions("user:list")
    @ResponseBody
    @RequestMapping("/show")
    public String show() {
        return "show-test";
    }
}
