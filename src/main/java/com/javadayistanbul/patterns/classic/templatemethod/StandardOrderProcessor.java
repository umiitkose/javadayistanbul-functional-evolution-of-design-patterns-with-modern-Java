package com.javadayistanbul.patterns.classic.templatemethod;

import java.math.BigDecimal;

public class StandardOrderProcessor extends AbstractOrderProcessor {

    @Override
    protected void validateOrder(Order order) {
        System.out.println("  [Standart] Siparis dogrulanıyor: stok kontrolu yapiliyor...");
    }

    @Override
    protected BigDecimal calculateTotal(Order order) {
        BigDecimal total = order.items().stream()
                .map(Order.Item::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("  [Standart] Toplam hesaplandi: " + total + " TL");
        return total;
    }

    @Override
    protected void applyDiscount(Order order, BigDecimal total) {
        System.out.println("  [Standart] Indirim yok (standart musteri)");
    }

    @Override
    protected void sendConfirmation(Order order) {
        System.out.println("  [Standart] E-posta ile onay gonderildi: " + order.customerName());
    }
}
