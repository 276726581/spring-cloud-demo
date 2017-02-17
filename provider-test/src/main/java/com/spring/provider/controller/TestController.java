package com.spring.provider.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TimoRD on 2017/2/17.
 */
@RestController
public class TestController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        sleep(5 * 1000);

        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;

        stopWatch.stop();

        long time = stopWatch.getTotalTimeMillis();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r + ", time:" + time);

        return r;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
