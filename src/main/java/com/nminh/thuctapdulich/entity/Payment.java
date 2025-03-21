package com.nminh.thuctapdulich.entity;

import com.nminh.thuctapdulich.enums.PaymentStatus;
// 1-1 voi tour
public class Payment {
    private Long id ;
    private PaymentStatus paymentStatus ;

    public Payment() {}
    public Payment(Long id, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
