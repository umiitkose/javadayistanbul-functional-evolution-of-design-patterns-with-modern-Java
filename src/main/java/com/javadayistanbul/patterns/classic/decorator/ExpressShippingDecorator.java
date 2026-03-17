package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class ExpressShippingDecorator implements OrderService {
    private final OrderService wrapped;

    public ExpressShippingDecorator(OrderService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Order process(Order order) {
        Order processed = wrapped.process(order);
        System.out.println("    + Hizli kargo secildi (+25 TL)");
        return processed.addFeature("Hizli Kargo", new BigDecimal("25"));
    }
}
