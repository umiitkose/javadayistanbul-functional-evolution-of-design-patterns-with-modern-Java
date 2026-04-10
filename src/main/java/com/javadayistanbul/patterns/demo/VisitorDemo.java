package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.visitor.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VisitorDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  VISITOR PATTERN");
        IO.println("  Java Feature: Sealed Classes & Pattern Matching");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Double Dispatch) ---");
        IO.println("  [8 dosya: 1 item interface + 3 item class + 1 visitor interface + 2 visitor + accept()]");
        IO.println("  Yeni item tipi eklemek = TUM visitor'lari guncellemek!");
        IO.println();

        List<OrderItem> items = List.of(
                new BookItem("Java in Action", new BigDecimal("75.00"), 1, "978-1617294945"),
                new ElectronicsItem("Kulaklik", new BigDecimal("450.00"), 1, "2 yil"),
                new FoodItem("Cikolata", new BigDecimal("25.00"), 3, LocalDate.now().plusMonths(6))
        );

        IO.println("  >> KDV Hesaplama:");
        var taxVisitor = new TaxCalculatorVisitor();
        items.forEach(item -> item.accept(taxVisitor));
        IO.println("    Toplam KDV: " + taxVisitor.getTotalTax() + " TL");
        IO.println();

        IO.println("  >> Indirim Hesaplama:");
        var discountVisitor = new DiscountVisitor();
        items.forEach(item -> item.accept(discountVisitor));
        IO.println("    Toplam Indirim: " + discountVisitor.getTotalDiscount() + " TL");
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Sealed + Pattern Matching) ---");
        IO.println("  [1 dosya: sealed interface + 3 record + switch expression]");
        IO.println("  Visitor interface yok! Double dispatch yok!");
        IO.println("  Compiler exhaustiveness kontrolu yapar!");
        IO.println();

        List<com.javadayistanbul.patterns.modern.visitor.OrderItem> items = List.of(
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.BookItem(
                        "Java in Action", new BigDecimal("75.00"), 1, "978-1617294945"),
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.ElectronicsItem(
                        "Kulaklik", new BigDecimal("450.00"), 1, "2 yil"),
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.FoodItem(
                        "Cikolata", new BigDecimal("25.00"), 3, LocalDate.now().plusMonths(6))
        );

        IO.println("  >> KDV Hesaplama:");
        var totalTax = items.stream()
                .map(com.javadayistanbul.patterns.modern.visitor.OrderItem::calculateTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        IO.println("    Toplam KDV: " + totalTax + " TL");
        IO.println();

        IO.println("  >> Indirim Hesaplama:");
        var totalDiscount = items.stream()
                .map(com.javadayistanbul.patterns.modern.visitor.OrderItem::calculateDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        IO.println("    Toplam Indirim: " + totalDiscount + " TL");
    }

    public static void main(String[] args) {
        run();
    }
}
