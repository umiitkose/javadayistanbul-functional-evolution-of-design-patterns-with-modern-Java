package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;

public class BookItem implements OrderItem {
    private final String name;
    private final BigDecimal price;
    private final int quantity;
    private final String isbn;

    public BookItem(String name, BigDecimal price, int quantity, String isbn) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }
}
