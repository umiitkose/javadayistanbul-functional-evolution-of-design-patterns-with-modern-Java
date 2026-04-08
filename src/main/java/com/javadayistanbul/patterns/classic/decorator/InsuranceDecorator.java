package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;

public class InsuranceDecorator extends OrderServiceDecorator {

    public InsuranceDecorator(OrderService wrapped) {
        super(wrapped);
    }

    @Override
    public Order process(Order order) {
        // Once icteki zincir; sonra bu katman ozelligi ekler.
        Order processed = wrapped.process(order);
        System.out.println("    + Kargo sigortasi eklendi (+10 TL)");
        return processed.addFeature("Kargo Sigortasi", new BigDecimal("10"));
    }
}
