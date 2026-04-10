package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.decorator.*;
import com.javadayistanbul.patterns.modern.decorator.OrderEnhancer;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public class DecoratorDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  DECORATOR PATTERN");
        IO.println("  Java Feature: UnaryOperator & Function Composition");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Wrapper Classes) ---");
        IO.println("  [7 dosya: 1 interface + 1 soyut decorator + 1 concrete + 3 decorator + 1 Order]");
        IO.println("  Her yeni ozellik icin yeni bir wrapper sinifi!");
        IO.println();
        IO.println("  Not: new'ler dis->ic (Express en dis); process() ic->dis calisir:");
        IO.println("       BasicOrderService -> GiftWrap -> Insurance -> ExpressShipping");
        IO.println();

        OrderService service = new ExpressShippingDecorator(
                new InsuranceDecorator(
                        new GiftWrapDecorator(
                                new BasicOrderService()
                        )
                )
        );

        var order = new com.javadayistanbul.patterns.classic.decorator.Order(
                "ORD-001", new BigDecimal("200"));
        var result = service.process(order);
        IO.println();
        IO.println("  Ozellikler: " + result.features());
        IO.println("  Toplam: " + result.totalPrice() + " TL (baz: " + result.basePrice() + " TL)");
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Function Composition) ---");
        IO.println("  [2 dosya: 1 Order + 1 Enhancer (UnaryOperator + andThen)]");
        IO.println("  Decorator sinifi yok! andThen() ile zincirleme!");
        IO.println();

        var enhance = OrderEnhancer.giftWrap()
                .andThen(OrderEnhancer.insurance())
                .andThen(OrderEnhancer.expressShipping());


        var order = new com.javadayistanbul.patterns.modern.decorator.Order(
                "ORD-001", new BigDecimal("200"));
        IO.println("  Siparis isleniyor: #" + order.id());
        var result = enhance.apply(order);
        IO.println();
        IO.println("  Ozellikler: " + result.features());
        IO.println("  Toplam: " + result.totalPrice() + " TL (baz: " + result.basePrice() + " TL)");
    }

    public static void main(String[] args) {
        run();
    }
}
