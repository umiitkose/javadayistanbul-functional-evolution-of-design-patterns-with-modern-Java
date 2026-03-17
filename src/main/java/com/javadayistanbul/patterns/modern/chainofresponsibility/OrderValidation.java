package com.javadayistanbul.patterns.modern.chainofresponsibility;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class OrderValidation {

    public record Order(String id, String customerName, BigDecimal amount, String shippingAddress, int stockQuantity) {}

    public static final Predicate<Order> hasStock = order -> {
        boolean valid = order.stockQuantity() > 0;
        System.out.println(valid
                ? "    [OK] Stok kontrolu gecti: " + order.stockQuantity() + " adet"
                : "    [FAIL] Stok yetersiz: " + order.id());
        return valid;
    };

    public static final Predicate<Order> hasValidAmount = order -> {
        boolean valid = order.amount().compareTo(BigDecimal.ZERO) > 0;
        System.out.println(valid
                ? "    [OK] Odeme tutari gecerli: " + order.amount() + " TL"
                : "    [FAIL] Gecersiz tutar: " + order.amount());
        return valid;
    };

    public static final Predicate<Order> hasValidAddress = order -> {
        boolean valid = order.shippingAddress() != null && !order.shippingAddress().isBlank();
        System.out.println(valid
                ? "    [OK] Adres gecerli: " + order.shippingAddress()
                : "    [FAIL] Teslimat adresi bos!");
        return valid;
    };

    public static Predicate<Order> allValidations() {
        return hasStock.and(hasValidAmount).and(hasValidAddress);
    }
}
