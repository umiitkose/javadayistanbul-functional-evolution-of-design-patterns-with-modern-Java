package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.adapter.*;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class AdapterDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  ADAPTER PATTERN");
        System.out.println("  Java Feature: Method References & Lambda");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Wrapper Class) ---");
        System.out.println("  [3 dosya: 1 legacy system + 1 interface + 1 adapter class]");
        System.out.println();

        LegacyPaymentSystem legacy = new LegacyPaymentSystem();
        ModernPaymentGateway gateway = new PaymentAdapter(legacy);

        boolean result = gateway.pay("ORD-001", new BigDecimal("299.99"));
        System.out.println("    Sonuc: " + (result ? "BASARILI" : "BASARISIZ"));
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Lambda / Method Reference) ---");
        System.out.println("  [1 dosya: BiFunction + lambda ile adaptasyon]");
        System.out.println("  Wrapper sinifi yok! Fonksiyonel adaptasyon!");
        System.out.println();

        var legacy = new com.javadayistanbul.patterns.modern.adapter.PaymentAdapter.LegacyPaymentSystem("EskiSistem");
        BiFunction<String, BigDecimal, Boolean> modernGateway =
                com.javadayistanbul.patterns.modern.adapter.PaymentAdapter.adapt(legacy);

        boolean result = modernGateway.apply("ORD-001", new BigDecimal("299.99"));
        System.out.println("    Sonuc: " + (result ? "BASARILI" : "BASARISIZ"));
    }

    public static void main(String[] args) {
        run();
    }
}
