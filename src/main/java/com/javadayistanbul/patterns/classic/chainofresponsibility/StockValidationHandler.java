package com.javadayistanbul.patterns.classic.chainofresponsibility;

public class StockValidationHandler extends OrderValidationHandler {
    @Override
    protected boolean doValidate(Order order) {
        if (order.stockQuantity() <= 0) {
            System.out.println("    [FAIL] Stok yetersiz: " + order.id());
            return false;
        }
        System.out.println("    [OK] Stok kontrolu gecti: " + order.stockQuantity() + " adet");
        return true;
    }
}
