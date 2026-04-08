package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class GiftWrapDecorator extends OrderServiceDecorator {

    public GiftWrapDecorator(OrderService wrapped) {
        super(wrapped);
    }

    @Override
    public Order process(Order order) {
        // Once icteki zincir; sonra bu katman ozelligi ekler.
        Order processed = wrapped.process(order);
        System.out.println("    + Hediye paketi eklendi (+15 TL)");
        return processed.addFeature("Hediye Paketi", new BigDecimal("15"));
    }
}
