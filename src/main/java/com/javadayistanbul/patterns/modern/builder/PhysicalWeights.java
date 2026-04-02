package com.javadayistanbul.patterns.modern.builder;

import java.math.BigDecimal;

/**
 * Opsiyonel brut/net agirlik; net brutu asamaz.
 */
public record PhysicalWeights(BigDecimal grossWeightKg, BigDecimal netWeightKg) {

    public static PhysicalWeights none() {
        return new PhysicalWeights(null, null);
    }

    public PhysicalWeights {
        if (grossWeightKg != null && grossWeightKg.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Brut agirlik sifirdan buyuk olmalidir");
        }
        if (netWeightKg != null && grossWeightKg != null
                && netWeightKg.compareTo(grossWeightKg) > 0) {
            throw new IllegalArgumentException("Net agirlik brut agirligi asamaz");
        }
    }
}
