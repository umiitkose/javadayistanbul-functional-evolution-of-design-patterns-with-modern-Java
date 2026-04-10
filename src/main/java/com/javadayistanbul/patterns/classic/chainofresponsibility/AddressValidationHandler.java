package com.javadayistanbul.patterns.classic.chainofresponsibility;

public class AddressValidationHandler extends OrderValidationHandler {
    @Override
    protected boolean doValidate(Order order) {
        if (order.shippingAddress() == null || order.shippingAddress().isBlank()) {
            IO.println("    [FAIL] Teslimat adresi bos!");
            return false;
        }
        IO.println("    [OK] Adres gecerli: " + order.shippingAddress());
        return true;
    }
}
