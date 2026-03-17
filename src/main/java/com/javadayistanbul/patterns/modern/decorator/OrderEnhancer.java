package com.javadayistanbul.patterns.modern.decorator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public class OrderEnhancer {

    public static UnaryOperator<Order> giftWrap() {
        return order -> {
            System.out.println("    + Hediye paketi eklendi (+15 TL)");
            return order.addFeature("Hediye Paketi", new BigDecimal("15"));
        };
    }

    public static UnaryOperator<Order> insurance() {
        return order -> {
            System.out.println("    + Kargo sigortasi eklendi (+10 TL)");
            return order.addFeature("Kargo Sigortasi", new BigDecimal("10"));
        };
    }

    public static UnaryOperator<Order> expressShipping() {
        return order -> {
            System.out.println("    + Hizli kargo secildi (+25 TL)");
            return order.addFeature("Hizli Kargo", new BigDecimal("25"));
        };
    }
}
