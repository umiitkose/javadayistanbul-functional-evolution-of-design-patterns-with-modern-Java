package com.javadayistanbul.patterns.modern.iterator;

import java.math.BigDecimal;

public record OrderItem(String category, BigDecimal price, int quantity) {
}
