package com.javadayistanbul.patterns.modern.templatemethod;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public record ReportGenerator(
        Consumer<ReportData> dataValidator,
        Function<ReportData, String> dataFormatter,
        UnaryOperator<String> outputRenderer,
        Consumer<String> reportSender
) {
    public void generate(ReportData data) {
        dataValidator.accept(data);
        String formatted = dataFormatter.apply(data);
        String output = outputRenderer.apply(formatted);
        reportSender.accept(output);
    }

    private static String formatHeaders(ReportData data, String delimiter) {
        return String.join(delimiter, data.columns());
    }

    private static String formatRows(ReportData data, String delimiter) {
        var sb = new StringBuilder();
        for (var row : data.rows()) {
            sb.append(String.join(delimiter, row)).append("\n");
        }
        return sb.toString();
    }

    public static ReportGenerator pdf() {
        return new ReportGenerator(
                data -> {
                    if (data.rows().isEmpty())
                        throw new IllegalArgumentException("PDF icin en az bir satir gerekli");
                    IO.println("  [PDF] Dogrulandi: " + data.rows().size() + " satir");
                },
                data -> {
                    String headers = formatHeaders(data, " | ");
                    String rows = formatRows(data, " | ");
                    IO.println("  [PDF] Tablo formati olusturuldu");
                    return headers + "\n" + "-".repeat(40) + "\n" + rows;
                },
                formatted -> {
                    IO.println("  [PDF] PDF sayfasi olusturuldu");
                    return "[PDF_DOCUMENT]\n" + formatted;
                },
                output -> {
                    IO.println("  [PDF] Dosyaya yazildi: rapor.pdf");
                    IO.println("  [PDF] E-posta ile gonderildi");
                }
        );
    }

    public static ReportGenerator excel() {
        return new ReportGenerator(
                data -> {
                    if (data.columns().isEmpty())
                        throw new IllegalArgumentException("Excel icin en az bir kolon gerekli");
                    IO.println("  [Excel] Dogrulandi: " + data.columns().size() + " kolon");
                },
                data -> {
                    String headers = formatHeaders(data, ";");
                    String rows = formatRows(data, ";");
                    IO.println("  [Excel] Hucre formati olusturuldu");
                    return headers + "\n" + rows;
                },
                formatted -> {
                    IO.println("  [Excel] Calisma sayfasi olusturuldu");
                    return "[EXCEL_WORKBOOK]\n" + formatted;
                },
                output -> IO.println("  [Excel] Dosyaya yazildi: rapor.xlsx")
        );
    }

    public static ReportGenerator html() {
        return new ReportGenerator(
                data -> IO.println("  [HTML] Dogrulandi"),
                data -> {
                    var sb = new StringBuilder();
                    sb.append("<tr>");
                    data.columns().forEach(c -> sb.append("<th>").append(c).append("</th>"));
                    sb.append("</tr>\n");
                    data.rows().forEach(row -> {
                        sb.append("<tr>");
                        row.forEach(cell -> sb.append("<td>").append(cell).append("</td>"));
                        sb.append("</tr>\n");
                    });
                    IO.println("  [HTML] Tablo satirlari olusturuldu");
                    return sb.toString();
                },
                formatted -> {
                    IO.println("  [HTML] Sayfa olusturuldu");
                    return "<html><body><table>" + formatted + "</table></body></html>";
                },
                output -> IO.println("  [HTML] Web sunucusuna yuklendi: /reports/rapor.html")
        );
    }

    public static ReportGenerator email(String recipient) {
        return new ReportGenerator(
                data -> {
                    if (recipient == null || recipient.isBlank())
                        throw new IllegalArgumentException("Alici bos olamaz");
                    IO.println("  [Email] Dogrulandi, alici: " + recipient);
                },
                data -> {
                    String headers = formatHeaders(data, " | ");
                    String rows = formatRows(data, " | ");
                    IO.println("  [Email] Duz metin formati olusturuldu");
                    return headers + "\n" + rows;
                },
                formatted -> {
                    IO.println("  [Email] Govde olusturuldu");
                    return "Konu: Rapor\n\n" + formatted;
                },
                output -> IO.println("  [Email] Gonderildi -> " + recipient)
        );
    }

    public static ReportGenerator custom(
            Consumer<ReportData> validator,
            Function<ReportData, String> formatter,
            UnaryOperator<String> renderer,
            Consumer<String> sender
    ) {
        return new ReportGenerator(validator, formatter, renderer, sender);
    }
}
