package com.javadayistanbul.patterns.classic.templatemethod;

public class PdfReportGenerator extends AbstractReportGenerator {

    @Override
    protected void validateData(ReportData data) {
        if (data.getRows().isEmpty()) {
            throw new IllegalArgumentException("PDF raporu icin en az bir satir gerekli");
        }
        System.out.println("  [PDF] Veri dogrulandi: " + data.getRows().size() + " satir");
    }

    @Override
    protected String formatData(ReportData data) {
        var sb = new StringBuilder();
        sb.append(String.join(" | ", data.getColumns())).append("\n");
        sb.append("-".repeat(40)).append("\n");
        for (var row : data.getRows()) {
            sb.append(String.join(" | ", row)).append("\n");
        }
        System.out.println("  [PDF] Tablo formati olusturuldu");
        return sb.toString();
    }

    @Override
    protected String renderOutput(String formatted, String title) {
        String output = "=== PDF: " + title + " ===\n" + formatted;
        System.out.println("  [PDF] PDF sayfasi olusturuldu");
        return output;
    }

    @Override
    protected void sendReport(String output) {
        System.out.println("  [PDF] Dosyaya yazildi: " + "rapor.pdf");
        System.out.println("  [PDF] Kullaniciya e-posta ile gonderildi");
    }
}
