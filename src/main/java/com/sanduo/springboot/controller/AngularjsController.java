package com.sanduo.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanduo.springboot.entity.Person;

/**
 * bootStrap+AngularJs+bootStrap实战
 * 
 * @author sanduo
 * @date 2018/07/01
 */
@Controller
public class AngularjsController {

    // TOD0:BootStrap+AngularJs 实战没有完成

    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Person search() {
        return new Person("spring", 5, "美国");
    }
}
