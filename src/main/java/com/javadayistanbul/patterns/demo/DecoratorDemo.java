package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.decorator.BasicOrderService;
import com.javadayistanbul.patterns.classic.decorator.ExpressShippingDecorator;
import com.javadayistanbul.patterns.classic.decorator.GiftWrapDecorator;
import com.javadayistanbul.patterns.classic.decorator.InsuranceDecorator;
import com.javadayistanbul.patterns.classic.decorator.OrderService;
import com.javadayistanbul.patterns.modern.decorator.OrderEnhancer;

import java.math.BigDecimal;

public class DecoratorDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  DECORATOR PATTERN");
        System.out.println("  Java Feature: UnaryOperator & Function Composition");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Wrapper Classes) ---");
        System.out.println("  [6 dosya: 1 interface + 1 base + 3 decorator + 1 Order]");
        System.out.println("  Her yeni ozellik icin yeni bir wrapper sinifi!");
        System.out.println();

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
        System.out.println();
        System.out.println("  Ozellikler: " + result.features());
        System.out.println("  Toplam: " + result.totalPrice() + " TL (baz: " + result.basePrice() + " TL)");
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Function Composition) ---");
        System.out.println("  [2 dosya: 1 Order + 1 Enhancer (UnaryOperator + andThen)]");
        System.out.println("  Decorator sinifi yok! andThen() ile zincirleme!");
        System.out.println();

        var enhance = OrderEnhancer.giftWrap()
                .andThen(OrderEnhancer.insurance())
                .andThen(OrderEnhancer.expressShipping());

        var order = new com.javadayistanbul.patterns.modern.decorator.Order(
                "ORD-001", new BigDecimal("200"));
        System.out.println("  Siparis isleniyor: #" + order.id());
        var result = enhance.apply(order);
        System.out.println();
        System.out.println("  Ozellikler: " + result.features());
        System.out.println("  Toplam: " + result.totalPrice() + " TL (baz: " + result.basePrice() + " TL)");
    }

    public static void main(String[] args) {
        run();
    }
}
