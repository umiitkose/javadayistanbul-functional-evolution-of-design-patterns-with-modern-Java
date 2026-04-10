package com.javadayistanbul.patterns.classic.chainofresponsibility;

import java.math.BigDecimal;

public class PaymentValidationHandler extends OrderValidationHandler {
    @Override
    protected boolean doValidate(Order order) {
        if (order.amount().compareTo(BigDecimal.ZERO) <= 0) {
            IO.println("    [FAIL] Gecersiz tutar: " + order.amount());
            return false;
        }
        IO.println("    [OK] Odeme tutari gecerli: " + order.amount() + " TL");
        return true;
    }
}
