package com.angx.cloud.controller;

import com.angx.cloud.entities.CommonResult;
import com.angx.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    // TODO: 微服务地址不能写死,对外暴露微服务地址，并且需要结合RestTemplate的负载均衡功能，否则无法确定访问哪个地址
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /*
     * @description: insertPayment
     * @return com.angx.cloud.entities.CommonResult<com.angx.cloud.entities.Payment>
     * @author Angx Gao
     * @create 2022/9/19
     **/
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        payment = new Payment(null,"test");
        //destination url...
        //send 'payment' to destination...
        return restTemplate.postForObject(PAYMENT_URL+"/insert",payment,CommonResult.class);
    }

    /*
     * @description: getPayment
     * @return com.angx.cloud.entities.CommonResult<com.angx.cloud.entities.Payment>
     * @author Angx Gao
     * @create 2022/9/18
     **/
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("remote invoke");
        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id,CommonResult.class);
    }
}
