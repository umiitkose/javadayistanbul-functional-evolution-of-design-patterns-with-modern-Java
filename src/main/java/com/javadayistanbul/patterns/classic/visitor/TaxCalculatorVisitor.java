package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;

public class TaxCalculatorVisitor implements OrderItemVisitor {
    private BigDecimal totalTax = BigDecimal.ZERO;

    @Override
    public void visit(BookItem book) {
        BigDecimal tax = book.getPrice().multiply(new BigDecimal("0.08"));
        totalTax = totalTax.add(tax);
        System.out.println("    Kitap KDV (%8): " + book.getName() + " -> " + tax + " TL");
    }

    @Override
    public void visit(ElectronicsItem electronics) {
        BigDecimal tax = electronics.getPrice().multiply(new BigDecimal("0.18"));
        totalTax = totalTax.add(tax);
        System.out.println("    Elektronik KDV (%18): " + electronics.getName() + " -> " + tax + " TL");
    }

    @Override
    public void visit(FoodItem food) {
        BigDecimal tax = food.getPrice().multiply(new BigDecimal("0.01"));
        totalTax = totalTax.add(tax);
        System.out.println("    Gida KDV (%1): " + food.getName() + " -> " + tax + " TL");
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }
}
