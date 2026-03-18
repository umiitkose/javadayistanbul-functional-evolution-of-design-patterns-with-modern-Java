package com.javadayistanbul.patterns.classic.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderClassic {
    private String id;
    private String customerId;
    private String customerName;
    private List<String> items;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private LocalDateTime createdAt;

    public OrderClassic() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        private String id;
        private String customerId;
        private String customerName;
        private final List<String> items = new ArrayList<>();
        private BigDecimal totalAmount = BigDecimal.ZERO;
        private String shippingAddress;
        private LocalDateTime createdAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
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
            orderClassic.id = id;
            orderClassic.customerId = customerId;
            orderClassic.customerName = customerName;
            orderClassic.items = new ArrayList<>(items);
            orderClassic.totalAmount = totalAmount;
            orderClassic.shippingAddress = shippingAddress;
            orderClassic.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
            return orderClassic;
        }
    }
}
