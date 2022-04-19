package com.wt.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallOrderApplication.class, args);
    }

}
