package com.javadayistanbul.patterns.modern.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * {@link com.javadayistanbul.patterns.classic.builder.StockReservationClassic} ile ayni 20 alanin
 * record kompozisyonu: kurallar alt value type'larin compact constructor'larinda toplanir.
 */
public record StockReservation(
        ReservationIdentity identity,
        QuantityAllocation quantities,
        PricingTerms pricing,
        StorageSlot storageSlot,
        PhysicalWeights physicalWeights,
        LotTraceability traceability,
        ComplianceNotes compliance
) {}
