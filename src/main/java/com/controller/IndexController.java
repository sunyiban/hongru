package com.controller;

import com.bean.response.IndexResponse;
import com.config.Person;
import com.config.SystemConfig;
import com.interceptor.AuthRequired;
import com.interceptor.AuthType;
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
    private SystemConfig systemConfig;

    @AuthRequired(value = AuthType.LOGIN)
    @RequestMapping("/index/{id}/{name}")
    public Object index(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println("this is id " + id + "; this is name " + name);

//        测试全局异常捕获
//        if (name != null) {
//            throw new RuntimeException("this is a test exception");
//        }

        IndexResponse indexResponse = new IndexResponse();
        indexResponse.setCellphone("13229182827");
        indexResponse.setName("张三");

        return indexResponse;
     }

}
