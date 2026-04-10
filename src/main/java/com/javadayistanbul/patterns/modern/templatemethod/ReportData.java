package com.javadayistanbul.patterns.modern.templatemethod;

import java.util.List;
import java.util.Objects;

public record ReportData(String title, List<String> columns, List<List<String>> rows) {

    public ReportData {
        Objects.requireNonNull(title, "Baslik zorunludur");
        Objects.requireNonNull(columns, "Kolon listesi zorunludur");
        Objects.requireNonNull(rows, "Satir listesi zorunludur");
        if (title.isBlank()) throw new IllegalArgumentException("Baslik bos olamaz");
        columns = List.copyOf(columns);
        rows = rows.stream().map(List::copyOf).toList();
    }
}
