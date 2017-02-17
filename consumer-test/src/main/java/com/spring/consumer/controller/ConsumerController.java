package com.spring.consumer.controller;

import com.spring.consumer.api.TestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TimoRD on 2017/2/17.
 */
@RestController
public class ConsumerController {

    @Autowired
    private TestApi testApi;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        Integer integer = testApi.add(1, 2);
        return integer.toString();
    }
}