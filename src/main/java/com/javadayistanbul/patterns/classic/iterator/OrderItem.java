package com.javadayistanbul.patterns.classic.iterator;

import java.math.BigDecimal;

public record OrderItem(String category, BigDecimal price, int quantity) {
}
