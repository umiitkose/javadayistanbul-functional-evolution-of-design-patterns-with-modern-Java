package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.adapter.*;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class AdapterDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  ADAPTER PATTERN");
        IO.println("  Java Feature: Method References & Lambda");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Wrapper Class) ---");
        IO.println("  [3 dosya: 1 legacy system + 1 interface + 1 adapter class]");
        IO.println();

        LegacyPaymentSystem legacy = new LegacyPaymentSystem();
        ModernPaymentGateway gateway = new PaymentAdapter(legacy);

        boolean result = gateway.pay("ORD-001", new BigDecimal("299.99"));
        IO.println("    Sonuc: " + (result ? "BASARILI" : "BASARISIZ"));
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Lambda / Method Reference) ---");
        IO.println("  [1 dosya: BiFunction + lambda ile adaptasyon]");
        IO.println("  Wrapper sinifi yok! Fonksiyonel adaptasyon!");
        IO.println();

        var legacy = new com.javadayistanbul.patterns.modern.adapter.PaymentAdapter.LegacyPaymentSystem("EskiSistem");
        BiFunction<String, BigDecimal, Boolean> modernGateway =
                com.javadayistanbul.patterns.modern.adapter.PaymentAdapter.adapt(legacy);

        boolean result = modernGateway.apply("ORD-001", new BigDecimal("299.99"));
        IO.println("    Sonuc: " + (result ? "BASARILI" : "BASARISIZ"));
    }

    public static void main(String[] args) {
        run();
    }
}
