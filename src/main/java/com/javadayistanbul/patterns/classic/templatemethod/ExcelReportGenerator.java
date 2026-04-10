package com.javadayistanbul.patterns.classic.templatemethod;

public class ExcelReportGenerator extends AbstractReportGenerator {

    @Override
    protected void validateData(ReportData data) {
        if (data.getColumns().isEmpty()) {
            throw new IllegalArgumentException("Excel raporu icin en az bir kolon gerekli");
        }
        IO.println("  [Excel] Veri dogrulandi: " + data.getColumns().size() + " kolon");
    }

    @Override
    protected String formatData(ReportData data) {
        var sb = new StringBuilder();
        sb.append(String.join(";", data.getColumns())).append("\n");
        for (var row : data.getRows()) {
            sb.append(String.join(";", row)).append("\n");
        }
        IO.println("  [Excel] Hucre formati olusturuldu");
        return sb.toString();
    }

    @Override
    protected String renderOutput(String formatted, String title) {
        String output = "EXCEL_WORKBOOK[" + title + "]:\n" + formatted;
        IO.println("  [Excel] Calisma sayfasi olusturuldu");
        return output;
    }

    @Override
    protected void sendReport(String output) {
        IO.println("  [Excel] Dosyaya yazildi: " + "rapor.xlsx");
        IO.println("  [Excel] Paylasim linki olusturuldu");
    }
}
