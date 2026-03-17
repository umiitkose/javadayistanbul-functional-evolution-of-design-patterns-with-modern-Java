package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class GiftWrapDecorator implements OrderService {
    private final OrderService wrapped;

    public GiftWrapDecorator(OrderService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Order process(Order order) {
        Order processed = wrapped.process(order);
        System.out.println("    + Hediye paketi eklendi (+15 TL)");
        return processed.addFeature("Hediye Paketi", new BigDecimal("15"));
    }
}
