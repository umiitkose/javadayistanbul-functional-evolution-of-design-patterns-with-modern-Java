package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FoodItem implements OrderItem {
    private final String name;
    private final BigDecimal price;
    private final int quantity;
    private final LocalDate expiryDate;

    public FoodItem(String name, BigDecimal price, int quantity, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    @Override
    public void accept(OrderItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
