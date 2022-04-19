package com.wt.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.wt.mall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class WtmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallMemberApplication.class, args);
    }

}
