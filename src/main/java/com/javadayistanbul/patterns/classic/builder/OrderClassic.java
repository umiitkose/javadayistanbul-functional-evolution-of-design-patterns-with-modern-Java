package com.javadayistanbul.patterns.classic.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderClassic {
    private final String id;
    private final String customerId;
    private final String customerName;
    private final List<String> items;
    private final BigDecimal totalAmount;
    private final String shippingAddress;
    private final LocalDateTime createdAt;

    private OrderClassic(Builder builder) {
        id = builder.id;
        customerId = builder.customerId;
        customerName = builder.customerName;
        items = builder.items;
        totalAmount = builder.totalAmount;
        shippingAddress = builder.shippingAddress;
        createdAt = builder.createdAt;
    }

    public String getId() {
        return id;
    }


    public String getCustomerId() {
        return customerId;
    }


    public String getCustomerName() {
        return customerName;
    }


    public List<String> getItems() {
        return items;
    }


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }


    public String getShippingAddress() {
        return shippingAddress;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderClassic orderClassic = (OrderClassic) o;
        return Objects.equals(id, orderClassic.id) &&
                Objects.equals(customerId, orderClassic.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId);
    }

    public static class Builder {
        private final String id;
        private final String customerId;
        private String customerName;
        private final List<String> items = new ArrayList<>();
        private BigDecimal totalAmount = BigDecimal.ZERO;
        private String shippingAddress;
        private LocalDateTime createdAt;

        public Builder(String id, String customerId) {
            this.id = id;
            this.customerId = customerId;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder addItem(String item) {
            this.items.add(item);
            return this;
        }

        public Builder items(List<String> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
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

            return new OrderClassic(this);
        }
    }
}
