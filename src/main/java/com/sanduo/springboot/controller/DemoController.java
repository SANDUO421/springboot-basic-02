package com.sanduo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanduo.springboot.entity.AuthorSetting;

/**
 * 测试controller
 * 
 * @author sanduo
 * @date 2018/06/04
 */
@RestController
public class DemoController {

    @Autowired
    AuthorSetting authorSetting;

    @RequestMapping("/")
    public String index() {
        return "Hello SpringBoot";
    }

    @RequestMapping("/author")
    public String getAuthor() {

        return "author name is " + authorSetting.getName() + " and author age is " + authorSetting.getAge();
    }
}
