package com.service.impl;

import com.SunhongruApplication;
import com.bean.request.Customer;
import com.config.Person;
import com.config.SystemConfig;
import com.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SunhongruApplication.class)
public class IndexServiceImplTest {

    @Autowired
    private IndexService indexService;

    @Autowired
    private Person person;

    @Autowired
    private SystemConfig systemConfig;

    @Test
    public void welcome() {
        System.out.println(person.toString());

        System.out.println(systemConfig.getSecurity());
//
//        Customer customer = new Customer();
//        customer.setName("zhangsan");
//        indexService.welcome(customer);
    }
}