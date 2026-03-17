package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.visitor.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VisitorDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  VISITOR PATTERN");
        System.out.println("  Java Feature: Sealed Classes & Pattern Matching");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Double Dispatch) ---");
        System.out.println("  [8 dosya: 1 item interface + 3 item class + 1 visitor interface + 2 visitor + accept()]");
        System.out.println("  Yeni item tipi eklemek = TUM visitor'lari guncellemek!");
        System.out.println();

        List<OrderItem> items = List.of(
                new BookItem("Java in Action", new BigDecimal("75.00"), 1, "978-1617294945"),
                new ElectronicsItem("Kulaklik", new BigDecimal("450.00"), 1, "2 yil"),
                new FoodItem("Cikolata", new BigDecimal("25.00"), 3, LocalDate.now().plusMonths(6))
        );

        System.out.println("  >> KDV Hesaplama:");
        var taxVisitor = new TaxCalculatorVisitor();
        items.forEach(item -> item.accept(taxVisitor));
        System.out.println("    Toplam KDV: " + taxVisitor.getTotalTax() + " TL");
        System.out.println();

        System.out.println("  >> Indirim Hesaplama:");
        var discountVisitor = new DiscountVisitor();
        items.forEach(item -> item.accept(discountVisitor));
        System.out.println("    Toplam Indirim: " + discountVisitor.getTotalDiscount() + " TL");
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Sealed + Pattern Matching) ---");
        System.out.println("  [1 dosya: sealed interface + 3 record + switch expression]");
        System.out.println("  Visitor interface yok! Double dispatch yok!");
        System.out.println("  Compiler exhaustiveness kontrolu yapar!");
        System.out.println();

        List<com.javadayistanbul.patterns.modern.visitor.OrderItem> items = List.of(
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.BookItem(
                        "Java in Action", new BigDecimal("75.00"), 1, "978-1617294945"),
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.ElectronicsItem(
                        "Kulaklik", new BigDecimal("450.00"), 1, "2 yil"),
                new com.javadayistanbul.patterns.modern.visitor.OrderItem.FoodItem(
                        "Cikolata", new BigDecimal("25.00"), 3, LocalDate.now().plusMonths(6))
        );

        System.out.println("  >> KDV Hesaplama:");
        var totalTax = items.stream()
                .map(com.javadayistanbul.patterns.modern.visitor.OrderItem::calculateTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("    Toplam KDV: " + totalTax + " TL");
        System.out.println();

        System.out.println("  >> Indirim Hesaplama:");
        var totalDiscount = items.stream()
                .map(com.javadayistanbul.patterns.modern.visitor.OrderItem::calculateDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("    Toplam Indirim: " + totalDiscount + " TL");
    }

    public static void main(String[] args) {
        run();
    }
}
