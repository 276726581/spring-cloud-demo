package com.spring.consumer;

import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsumerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerTestApplication.class, args);
    }

    /**
     * feign超时时间
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        Request.Options options = new Request.Options(30 * 1000, 30 * 1000);
        return options;
    }
}
