package com.javadayistanbul.patterns.classic.chainofresponsibility;

public class AddressValidationHandler extends OrderValidationHandler {
    @Override
    protected boolean doValidate(Order order) {
        if (order.shippingAddress() == null || order.shippingAddress().isBlank()) {
            System.out.println("    [FAIL] Teslimat adresi bos!");
            return false;
        }
        System.out.println("    [OK] Adres gecerli: " + order.shippingAddress());
        return true;
    }
}
