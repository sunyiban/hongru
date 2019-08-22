package com.service.impl;

import com.SunhongruApplication;
import com.bean.request.Customer;
import com.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SunhongruApplication.class)
public class IndexServiceImplTest {

    @Autowired
    private IndexService indexService;

    @Test
    public void welcome() {
        Customer customer = new Customer();
        customer.setName("zhangsan");
        indexService.welcome(customer);
    }
}