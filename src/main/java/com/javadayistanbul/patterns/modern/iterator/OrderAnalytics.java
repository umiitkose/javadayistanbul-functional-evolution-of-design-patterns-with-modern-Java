package com.javadayistanbul.patterns.modern.iterator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OrderAnalytics {

    private OrderAnalytics() {
    }

    public static BigDecimal totalBookRevenue(List<OrderItem> items) {
        return items.stream()
                .filter(item -> "BOOK".equals(item.category()))
                .map(item -> item.price().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Map<String, BigDecimal> revenueByCategory(List<OrderItem> items) {
        return items.stream()
                .collect(Collectors.groupingBy(
                        OrderItem::category,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                item -> item.price().multiply(BigDecimal.valueOf(item.quantity())),
                                BigDecimal::add
                        )
                ));
    }
}
