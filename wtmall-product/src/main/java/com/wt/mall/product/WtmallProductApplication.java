package com.wt.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.wt.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class WtmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtmallProductApplication.class, args);
    }

}
