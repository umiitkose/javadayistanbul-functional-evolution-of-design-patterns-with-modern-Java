package com.javadayistanbul.patterns.classic.strategy;

import java.math.BigDecimal;

public class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(BigDecimal amount) {
        strategy.pay(amount);
    }
}
