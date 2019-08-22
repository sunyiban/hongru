package com.controller;

import com.config.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Person person;

    @RequestMapping("/index")
    public String index(String name) {
        System.out.println(person.toString());

        if (name != null) {
            throw new RuntimeException("this is a test exception");
        }
        return "index";
     }

}
