package com.angx.cloud.service.impl;

import com.angx.cloud.dao.PaymentDao;
import com.angx.cloud.entities.Payment;
import com.angx.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @description: service调用dao, dao专注crud，service多重复合使用dao
 * @author Angx Gao
 * @create 2022/9/10
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
