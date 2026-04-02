package com.javadayistanbul.patterns.modern.builder;

/**
 * Talep ve rezerve miktar; capraz kural: rezerve talebi asamaz.
 */
public record QuantityAllocation(int requestedQuantity, int reservedQuantity) {

    public QuantityAllocation {
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("Talep miktari sifirdan buyuk olmalidir");
        }
        if (reservedQuantity < 0) {
            throw new IllegalArgumentException("Rezerve miktar negatif olamaz");
        }
        if (reservedQuantity > requestedQuantity) {
            throw new IllegalArgumentException("Rezerve miktar talep miktarini asamaz");
        }
    }
}
