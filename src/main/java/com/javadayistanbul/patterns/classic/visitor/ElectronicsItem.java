package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;

public class ElectronicsItem implements OrderItem {
    private final String name;
    private final BigDecimal price;
    private final int quantity;
    private final String warranty;

    public ElectronicsItem(String name, BigDecimal price, int quantity, String warranty) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
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

    public String getWarranty() {
        return warranty;
    }
}
