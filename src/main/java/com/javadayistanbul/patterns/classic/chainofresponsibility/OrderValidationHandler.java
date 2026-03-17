package com.javadayistanbul.patterns.classic.chainofresponsibility;

public abstract class OrderValidationHandler {
    private OrderValidationHandler next;

    public OrderValidationHandler setNext(OrderValidationHandler next) {
        this.next = next;
        return next;
    }

    public boolean validate(Order order) {
        if (!doValidate(order)) {
            return false;
        }
        if (next != null) {
            return next.validate(order);
        }
        return true;
    }

    protected abstract boolean doValidate(Order order);
}
