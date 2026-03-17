package com.javadayistanbul.patterns.classic.templatemethod;

import java.math.BigDecimal;

public class PremiumOrderProcessor extends AbstractOrderProcessor {

    @Override
    protected void validateOrder(Order order) {
        System.out.println("  [Premium] VIP musteri dogrulamasi + stok kontrolu yapiliyor...");
    }

    @Override
    protected BigDecimal calculateTotal(Order order) {
        BigDecimal total = order.items().stream()
                .map(Order.Item::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("  [Premium] Toplam hesaplandi: " + total + " TL");
        return total;
    }

    @Override
    protected void applyDiscount(Order order, BigDecimal total) {
        BigDecimal discounted = total.multiply(new BigDecimal("0.90"));
        System.out.println("  [Premium] %10 VIP indirimi uygulandi: " + discounted + " TL");
    }

    @Override
    protected void sendConfirmation(Order order) {
        System.out.println("  [Premium] SMS + E-posta ile onay gonderildi: " + order.customerName());
    }
}
