package com.javadayistanbul.patterns.classic.chainofresponsibility;

public class StockValidationHandler extends OrderValidationHandler {
    @Override
    protected boolean doValidate(Order order) {
        if (order.stockQuantity() <= 0) {
            IO.println("    [FAIL] Stok yetersiz: " + order.id());
            return false;
        }
        IO.println("    [OK] Stok kontrolu gecti: " + order.stockQuantity() + " adet");
        return true;
    }
}
