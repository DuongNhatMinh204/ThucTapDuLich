package com.nminh.thuctapdulich.entity;

import com.nminh.thuctapdulich.enums.PaymentStatus;
// 1-1 voi tour
public class Payment {
    private Long id ;
    private PaymentStatus paymentStatus ;
    private Tour tour ;

    public Payment() {}
    public Payment(Long id, PaymentStatus paymentStatus, Tour tour) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.tour = tour;
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

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
