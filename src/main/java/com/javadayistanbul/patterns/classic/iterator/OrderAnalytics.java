package com.javadayistanbul.patterns.classic.iterator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OrderAnalytics {

    private OrderAnalytics() {
    }

    public static BigDecimal totalBookRevenue(List<OrderItem> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            if ("BOOK".equals(item.category())) {
                BigDecimal lineTotal = item.price().multiply(BigDecimal.valueOf(item.quantity()));
                total = total.add(lineTotal);
            }
        }
        return total;
    }

    public static Map<String, BigDecimal> revenueByCategory(List<OrderItem> items) {
        Map<String, BigDecimal> totals = new HashMap<>();
        for (OrderItem item : items) {
            BigDecimal lineTotal = item.price().multiply(BigDecimal.valueOf(item.quantity()));
            totals.merge(item.category(), lineTotal, BigDecimal::add);
        }
        return totals;
    }
}
