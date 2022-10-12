package com.wl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangliang on 2018/4/14.
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "hello springboot";
    }

}
