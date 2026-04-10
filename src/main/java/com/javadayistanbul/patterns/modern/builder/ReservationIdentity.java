package com.javadayistanbul.patterns.modern.builder;

/**
 * Rezervasyonun depo ve urun baglamini tanimlar ({@link StockReservationClassic} ile ayni uc alan).
 */
public record ReservationIdentity(String reservationId, String warehouseId, String sku) {

    public ReservationIdentity {
        if (reservationId == null || reservationId.isBlank()) {
            throw new IllegalArgumentException("Rezervasyon ID zorunludur");
        }
        if (warehouseId == null || warehouseId.isBlank()) {
            throw new IllegalArgumentException("Depo ID zorunludur");
        }
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU zorunludur");
        }
    }
}
