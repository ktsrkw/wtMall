package com.wt.mall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WtmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallCouponApplication.class, args);
    }

}
