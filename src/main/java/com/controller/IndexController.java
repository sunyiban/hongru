package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor sunyiban
 * @date 2019/7/24 10:04
 * @descrpition
 */
@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {


    @RequestMapping("/index")
    public String index(String name) {
        return "index";
    }

}
