package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class ExpressShippingDecorator extends OrderServiceDecorator {

    public ExpressShippingDecorator(OrderService wrapped) {
        super(wrapped);
    }

    @Override
    public Order process(Order order) {
        // Once icteki zincir; sonra bu katman ozelligi ekler.
        Order processed = wrapped.process(order);
        System.out.println("    + Hizli kargo secildi (+25 TL)");
        return processed.addFeature("Hizli Kargo", new BigDecimal("25"));
    }
}
