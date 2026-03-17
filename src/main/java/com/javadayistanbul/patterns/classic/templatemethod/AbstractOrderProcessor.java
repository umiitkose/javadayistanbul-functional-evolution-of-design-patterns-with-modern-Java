package com.javadayistanbul.patterns.classic.templatemethod;

import java.math.BigDecimal;

public abstract class AbstractOrderProcessor {

    public final void process(Order order) {
        validateOrder(order);
        BigDecimal total = calculateTotal(order);
        applyDiscount(order, total);
        sendConfirmation(order);
    }

    protected abstract void validateOrder(Order order);

    protected abstract BigDecimal calculateTotal(Order order);

    protected abstract void applyDiscount(Order order, BigDecimal total);

    protected abstract void sendConfirmation(Order order);
}
