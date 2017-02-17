package com.spring.consumer.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by TimoRD on 2017/2/17.
 */
@Component
public class TestApiFallback implements TestApi {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -1;
    }
}
