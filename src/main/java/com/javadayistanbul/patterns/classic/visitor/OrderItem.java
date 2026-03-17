package com.javadayistanbul.patterns.classic.visitor;

import java.math.BigDecimal;

public interface OrderItem {
    void accept(OrderItemVisitor visitor);

    String getName();

    BigDecimal getPrice();

    int getQuantity();
}
