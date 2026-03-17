package com.javadayistanbul.patterns.modern.templatemethod;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public record OrderProcessor(
        Consumer<Order> validator,
        Function<Order, BigDecimal> totalCalculator,
        BiConsumer<Order, BigDecimal> discountApplier,
        Consumer<Order> confirmationSender
) {
    public void process(Order order) {
        validator.accept(order);
        BigDecimal total = totalCalculator.apply(order);
        discountApplier.accept(order, total);
        confirmationSender.accept(order);
    }

    public static OrderProcessor standard() {
        return new OrderProcessor(
                order -> System.out.println("  [Standart] Stok kontrolu yapiliyor..."),
                order -> {
                    var total = order.items().stream()
                            .map(Order.Item::total)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    System.out.println("  [Standart] Toplam: " + total + " TL");
                    return total;
                },
                (order, total) -> System.out.println("  [Standart] Indirim yok"),
                order -> System.out.println("  [Standart] E-posta onayi: " + order.customerName())
        );
    }

    public static OrderProcessor premium() {
        return new OrderProcessor(
                order -> System.out.println("  [Premium] VIP + stok kontrolu yapiliyor..."),
                order -> {
                    var total = order.items().stream()
                            .map(Order.Item::total)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    System.out.println("  [Premium] Toplam: " + total + " TL");
                    return total;
                },
                (order, total) -> {
                    var discounted = total.multiply(new BigDecimal("0.90"));
                    System.out.println("  [Premium] %10 VIP indirimi: " + discounted + " TL");
                },
                order -> System.out.println("  [Premium] SMS + E-posta onayi: " + order.customerName())
        );
    }
}
