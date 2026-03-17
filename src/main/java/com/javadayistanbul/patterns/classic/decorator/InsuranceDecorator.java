package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class InsuranceDecorator implements OrderService {
    private final OrderService wrapped;

    public InsuranceDecorator(OrderService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Order process(Order order) {
        Order processed = wrapped.process(order);
        System.out.println("    + Kargo sigortasi eklendi (+10 TL)");
        return processed.addFeature("Kargo Sigortasi", new BigDecimal("10"));
    }
}
