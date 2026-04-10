package com.javadayistanbul.patterns.modern.builder;

import java.math.BigDecimal;

/**
 * Birim maliyet, indirim/KDV yuzdeleri ve para birimi.
 */
public record PricingTerms(
        BigDecimal unitCost,
        BigDecimal discountPercent,
        BigDecimal vatPercent,
        String currencyCode
) {

    public PricingTerms {
        if (unitCost == null) {
            unitCost = BigDecimal.ZERO;
        }
        if (unitCost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Birim maliyet negatif olamaz");
        }
        if (discountPercent == null) {
            discountPercent = BigDecimal.ZERO;
        }
        if (discountPercent.compareTo(BigDecimal.ZERO) < 0
                || discountPercent.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("Indirim yuzdesi 0 ile 100 arasinda olmalidir");
        }
        if (vatPercent == null) {
            vatPercent = BigDecimal.ZERO;
        }
        if (vatPercent.compareTo(BigDecimal.ZERO) < 0
                || vatPercent.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("KDV yuzdesi 0 ile 100 arasinda olmalidir");
        }
        if (currencyCode == null) {
            currencyCode = "TRY";
        }
        if (currencyCode.length() != 3) {
            throw new IllegalArgumentException("Para birimi kodu tam 3 karakter olmalidir (ornegin TRY)");
        }
    }
}
