package com.javadayistanbul.patterns.modern.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public record Order(
        String id,
        String customerId,
        String customerName,
        List<String> items,
        BigDecimal totalAmount,
        String shippingAddress,
        LocalDateTime createdAt
) {
    public Order {
        Objects.requireNonNull(id, "Order ID zorunludur");
        Objects.requireNonNull(customerId, "Customer ID zorunludur");
        Objects.requireNonNull(items, "Urun listesi zorunludur");
        if (id.isBlank()) {
            throw new IllegalArgumentException("Order ID bos olamaz");
        }
        if (customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID bos olamaz");
        }
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Siparis en az bir urun icermelidir");
        }
        items = List.copyOf(items);
        if (totalAmount == null) totalAmount = BigDecimal.ZERO;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Order withShippingAddress(String shippingAddress) {
        return new Order(id, customerId, customerName, items, totalAmount, shippingAddress, createdAt);
    }

    public Order withTotalAmount(BigDecimal totalAmount) {
        return new Order(id, customerId, customerName, items, totalAmount, shippingAddress, createdAt);
    }
}
