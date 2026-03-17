package com.javadayistanbul.patterns.modern.visitor;

import java.math.BigDecimal;
import java.time.LocalDate;

public sealed interface OrderItem {

    String name();
    BigDecimal price();
    int quantity();

    record BookItem(String name, BigDecimal price, int quantity, String isbn)
            implements OrderItem {}

    record ElectronicsItem(String name, BigDecimal price, int quantity, String warranty)
            implements OrderItem {}

    record FoodItem(String name, BigDecimal price, int quantity, LocalDate expiryDate)
            implements OrderItem {}

    static BigDecimal calculateTax(OrderItem item) {
        return switch (item) {
            case BookItem b -> {
                var tax = b.price().multiply(new BigDecimal("0.08"));
                System.out.println("    Kitap KDV (%8): " + b.name() + " -> " + tax + " TL");
                yield tax;
            }
            case ElectronicsItem e -> {
                var tax = e.price().multiply(new BigDecimal("0.18"));
                System.out.println("    Elektronik KDV (%18): " + e.name() + " -> " + tax + " TL");
                yield tax;
            }
            case FoodItem f -> {
                var tax = f.price().multiply(new BigDecimal("0.01"));
                System.out.println("    Gida KDV (%1): " + f.name() + " -> " + tax + " TL");
                yield tax;
            }
        };
    }

    static BigDecimal calculateDiscount(OrderItem item) {
        return switch (item) {
            case BookItem b -> {
                var discount = b.price().multiply(new BigDecimal("0.15"));
                System.out.println("    Kitap indirimi (%15): " + b.name() + " -> -" + discount + " TL");
                yield discount;
            }
            case ElectronicsItem e -> {
                var discount = e.price().multiply(new BigDecimal("0.10"));
                System.out.println("    Elektronik indirimi (%10): " + e.name() + " -> -" + discount + " TL");
                yield discount;
            }
            case FoodItem f -> {
                System.out.println("    Gida indirimi yok: " + f.name());
                yield BigDecimal.ZERO;
            }
        };
    }
}
