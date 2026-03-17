package com.javadayistanbul.patterns.classic.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderClassicBuilder {
    private String id;
    private String customerId;
    private String customerName;
    private final List<String> items = new ArrayList<>();
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private String shippingAddress;
    private LocalDateTime createdAt;

    public OrderClassicBuilder id(String id) {
        this.id = id;
        return this;
    }

    public OrderClassicBuilder customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderClassicBuilder customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderClassicBuilder addItem(String item) {
        this.items.add(item);
        return this;
    }

    public OrderClassicBuilder items(List<String> items) {
        this.items.clear();
        this.items.addAll(items);
        return this;
    }

    public OrderClassicBuilder totalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public OrderClassicBuilder shippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public OrderClassicBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderClassic build() {
        if (id == null || id.isBlank()) {
            throw new IllegalStateException("Order ID zorunludur");
        }
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalStateException("Customer ID zorunludur");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Siparis en az bir urun icermelidir");
        }

        OrderClassic orderClassic = new OrderClassic();
        orderClassic.setId(id);
        orderClassic.setCustomerId(customerId);
        orderClassic.setCustomerName(customerName);
        orderClassic.setItems(new ArrayList<>(items));
        orderClassic.setTotalAmount(totalAmount);
        orderClassic.setShippingAddress(shippingAddress);
        orderClassic.setCreatedAt(createdAt != null ? createdAt : LocalDateTime.now());
        return orderClassic;
    }
}
