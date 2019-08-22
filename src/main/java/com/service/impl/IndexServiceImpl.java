package com.service.impl;

import com.bean.request.Customer;
import com.service.IndexService;
import org.springframework.stereotype.Service;

/**
 * @autor sunyiban
 * @date 2019/7/24 10:13
 * @descrpition
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    public void welcome(Customer customer) {
        System.out.println("hello <<" + customer.getName() + ">>, appreciate you user our system.");
    }

}
