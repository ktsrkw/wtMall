package com.wt.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtmallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallGatewayApplication.class, args);
    }

}
