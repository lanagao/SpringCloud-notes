package com.angx.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    /*
     * @description: create restTemplate bean
     * @return org.springframework.web.client.RestTemplate
     * @author Angx Gao
     * @create 2022/9/18
     **/
    @Bean
    //赋予RestTemplate负载均衡功能
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
