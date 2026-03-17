package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;

public class DiscountVisitor implements OrderItemVisitor {
    private BigDecimal totalDiscount = BigDecimal.ZERO;

    @Override
    public void visit(BookItem book) {
        BigDecimal discount = book.getPrice().multiply(new BigDecimal("0.15"));
        totalDiscount = totalDiscount.add(discount);
        System.out.println("    Kitap indirimi (%15): " + book.getName() + " -> -" + discount + " TL");
    }

    @Override
    public void visit(ElectronicsItem electronics) {
        BigDecimal discount = electronics.getPrice().multiply(new BigDecimal("0.10"));
        totalDiscount = totalDiscount.add(discount);
        System.out.println("    Elektronik indirimi (%10): " + electronics.getName() + " -> -" + discount + " TL");
    }

    @Override
    public void visit(FoodItem food) {
        System.out.println("    Gida indirimi yok: " + food.getName());
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }
}
