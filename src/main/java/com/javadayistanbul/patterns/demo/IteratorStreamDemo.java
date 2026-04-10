package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.iterator.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class IteratorStreamDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  ITERATOR / STREAM PATTERN");
        IO.println("  Java Feature: Stream API (Imperative vs Declarative)");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (External Iteration / for-loop) ---");
        var items = classicSampleItems();

        BigDecimal total = com.javadayistanbul.patterns.classic.iterator.OrderAnalytics.totalBookRevenue(items);
        var byCategory = com.javadayistanbul.patterns.classic.iterator.OrderAnalytics.revenueByCategory(items);

        IO.println("  [Classic] BOOK toplam ciro: " + total + " TL");
        IO.println("  [Classic] Kategori bazli ciro: " + byCategory);
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Declarative Stream Pipeline) ---");
        var items = modernSampleItems();

        BigDecimal total = com.javadayistanbul.patterns.modern.iterator.OrderAnalytics.totalBookRevenue(items);
        var byCategory = com.javadayistanbul.patterns.modern.iterator.OrderAnalytics.revenueByCategory(items);

        IO.println("  [Modern] BOOK toplam ciro: " + total + " TL");
        IO.println("  [Modern] Kategori bazli ciro: " + byCategory);
    }

    private static List<OrderItem> classicSampleItems() {
        return List.of(
                new OrderItem("BOOK", new BigDecimal("150"), 2),
                new OrderItem("ELECTRONICS", new BigDecimal("1200"), 1),
                new OrderItem("BOOK", new BigDecimal("90"), 3)
        );
    }

    private static List<com.javadayistanbul.patterns.modern.iterator.OrderItem> modernSampleItems() {
        return List.of(
                new com.javadayistanbul.patterns.modern.iterator.OrderItem("BOOK", new BigDecimal("150"), 2),
                new com.javadayistanbul.patterns.modern.iterator.OrderItem("ELECTRONICS", new BigDecimal("1200"), 1),
                new com.javadayistanbul.patterns.modern.iterator.OrderItem("BOOK", new BigDecimal("90"), 3)
        );
    }
}
