package com.example.designpatterns.structural.adapter;

public class ThirdPartyPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("[Adapter] Paid " + amount + " using ThirdPartyPaymentGateway.");
    }
}
