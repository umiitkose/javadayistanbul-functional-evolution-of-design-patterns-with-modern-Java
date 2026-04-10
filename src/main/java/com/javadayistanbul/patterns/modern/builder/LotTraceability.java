package com.javadayistanbul.patterns.modern.builder;

import java.time.LocalDate;

/**
 * Parti / seri ve son kullanma; alanlar opsiyoneldir.
 */
public record LotTraceability(LocalDate bestBeforeDate, String batchNumber, String lotSerial) {

    public static LotTraceability empty() {
        return new LotTraceability(null, null, null);
    }

    public LotTraceability {
        if (bestBeforeDate != null && bestBeforeDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Son kullanma tarihi gecmis olamaz");
        }
    }
}
