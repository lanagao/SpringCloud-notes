package com.angx.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//启动类不能直接放在java包下，需要放到java包下的包下
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class CloudProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001Application.class,args);
        log.info("start server");
    }
}
