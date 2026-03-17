package com.javadayistanbul.patterns.classic.adapter;

import java.math.BigDecimal;

public interface ModernPaymentGateway {
    boolean pay(String orderId, BigDecimal amount);
}
