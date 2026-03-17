package com.javadayistanbul.patterns.modern.templatemethod;

import java.math.BigDecimal;
import java.util.List;

public record Order(String id, String customerName, List<Item> items) {

    public record Item(String name, BigDecimal price, int quantity) {
        public BigDecimal total() {
            return price.multiply(BigDecimal.valueOf(quantity));
        }
    }
}
