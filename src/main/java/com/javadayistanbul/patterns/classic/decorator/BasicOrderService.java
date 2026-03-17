package com.javadayistanbul.patterns.classic.decorator;

public class BasicOrderService implements OrderService {

    @Override
    public Order process(Order order) {
        System.out.println("  Temel siparis isleniyor: #" + order.id());
        return order;
    }
}
