package com.angx.cloud.service;

import com.angx.cloud.entities.Payment;

public interface PaymentService {
    public int create (Payment payment);

    public Payment getPaymentById(Integer id);
}
