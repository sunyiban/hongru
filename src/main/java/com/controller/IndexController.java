package com.controller;

import com.config.Person;
import com.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @Autowired
    private SystemConfig systemConfig;

    @RequestMapping("/index/{id}/{name}")
    public String index(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println(person.toString());
        System.out.println("this is id " + id + "; this is name " + name);

        System.out.println(systemConfig);

        if (name != null) {
            throw new RuntimeException("this is a test exception");
        }
        return "index";
     }

}
