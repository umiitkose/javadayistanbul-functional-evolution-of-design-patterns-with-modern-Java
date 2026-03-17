package com.javadayistanbul.patterns.classic.chainofresponsibility;

import java.math.BigDecimal;

public record Order(String id, String customerName, BigDecimal amount, String shippingAddress, int stockQuantity) {}
