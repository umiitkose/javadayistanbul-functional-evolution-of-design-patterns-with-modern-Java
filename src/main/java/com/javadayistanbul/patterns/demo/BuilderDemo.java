package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.builder.OrderClassic;

import java.math.BigDecimal;
import java.util.List;

public class BuilderDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  BUILDER PATTERN");
        IO.println("  Java Feature: Records & Compact Constructors");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (POJO + Builder) ---");
        IO.println("  [1 dosya: POJO + nested static Builder]");
        IO.println("  Zorunlu alanlar: id, customerId, items");
        IO.println("  ~90 satir boilerplate kod!");
        IO.println();

        var order = new OrderClassic.Builder("ORD-001","CUST-42")
                .addItem("Java in Action")
                .addItem("Design Patterns")
                .build();


        IO.println("  Siparis: " + order);
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Record + Immutable update) ---");
        IO.println("  [1 dosya: record + compact constructor]");
        IO.println("  Zorunlu alanlar: id, customerId, items");
        IO.println("  toString/equals/hashCode otomatik!");
        IO.println("  Immutable by default!");
        IO.println();

        var order = new com.javadayistanbul.patterns.modern.builder.Order(
                "ORD-001",
                "CUST-42",
                null,
                List.of("Java in Action", "Design Patterns"),
                null,
                null,
                null
        );

        IO.println("  Siparis: " + order);

        var withAddress = order.withShippingAddress("Istanbul, Kadikoy");
        IO.println("  Adresli: " + withAddress);

        var withNewTotal = withAddress.withTotalAmount(new BigDecimal("129.90"));
        IO.println("  Indirimli: " + withNewTotal);
    }

    public static void main(String[] args) {
        run();
    }
}
