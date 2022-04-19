package com.wt.mall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallWareApplication.class, args);
    }

}
