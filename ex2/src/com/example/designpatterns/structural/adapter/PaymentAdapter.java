package com.example.designpatterns.structural.adapter;

public class PaymentAdapter implements PaymentProcessor {
    private ThirdPartyPaymentGateway gateway;

    public PaymentAdapter(ThirdPartyPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
