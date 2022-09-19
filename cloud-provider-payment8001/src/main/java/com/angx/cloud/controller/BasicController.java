package com.angx.cloud.controller;

import com.angx.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.angx.cloud.entities.CommonResult;
import com.angx.cloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class BasicController {
    @Resource
    private PaymentService paymentService;

    /*
     * @description: 区分微服务不同 provider
     * @author Angx Gao
     * @create 2022/9/19
     **/
    @Value("${server.port}")
    private String serverPort;

    /*
     * @description:
     * @return springcloud.entity.CommonResult
     * @author Angx Gao
     * @create 2022/9/18
     **/
    @GetMapping("/get/{id}")
    public CommonResult cloud8001_get(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        //log.info("outcome:"+payment);

        if(payment != null){
            return new CommonResult(200,"search successfully,port:"+serverPort,payment.getSerial());
        }else return new CommonResult(400,"fail");
    }

    /*
     * @description:
     * @return springcloud.entity.CommonResult
     * @author Angx Gao
     * @create 2022/9/18
     **/
    // TODO ...> receive 'payment' from request which order controller sent
    //how to receive the object from request? --> @RequestBody annotation...
    //@RequestBody是作用在形参列表上，用于将前台发送过来固定格式的数据 [xml 格式或者 json等]封装为对应的 JavaBean 对象，
    // 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上。
    @PostMapping("/insert")
    public CommonResult cloud8001_insert(@RequestBody Payment payment){
        if (payment != null){
            int callback = paymentService.create(payment);
            return new CommonResult(200,"insert successfully and the serial is data-->"+payment.getSerial()+" port: "+serverPort,callback);
        }else return new CommonResult(400,"fail");
    }
}
