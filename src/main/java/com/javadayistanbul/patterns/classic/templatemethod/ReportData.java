package com.javadayistanbul.patterns.classic.templatemethod;

import java.util.List;

public class ReportData {
    private final String title;
    private final List<String> columns;
    private final List<List<String>> rows;

    public ReportData(String title, List<String> columns, List<List<String>> rows) {
        this.title = title;
        this.columns = columns;
        this.rows = rows;
    }

    public String getTitle() { return title; }
    public List<String> getColumns() { return columns; }
    public List<List<String>> getRows() { return rows; }
}
