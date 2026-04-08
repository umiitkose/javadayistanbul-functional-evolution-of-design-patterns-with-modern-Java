package com.javadayistanbul.patterns.classic.templatemethod;

public class EmailReportGenerator extends AbstractReportGenerator {

    private final String recipient;

    public EmailReportGenerator(String recipient) {
        this.recipient = recipient;
    }

    @Override
    protected void validateData(ReportData data) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("E-posta alicisi bos olamaz");
        }
        System.out.println("  [Email] Veri dogrulandi, alici: " + recipient);
    }

    @Override
    protected String formatData(ReportData data) {
        var sb = new StringBuilder();
        sb.append("Rapor: ").append(data.getTitle()).append("\n\n");
        for (int i = 0; i < data.getColumns().size(); i++) {
            sb.append(data.getColumns().get(i)).append(": ");
            for (var row : data.getRows()) {
                if (i < row.size()) sb.append(row.get(i)).append("  ");
            }
            sb.append("\n");
        }
        System.out.println("  [Email] Duz metin formati olusturuldu");
        return sb.toString();
    }

    @Override
    protected String renderOutput(String formatted, String title) {
        String output = "Konu: " + title + "\n\n" + formatted;
        System.out.println("  [Email] E-posta govdesi olusturuldu");
        return output;
    }

    @Override
    protected void sendReport(String output) {
        System.out.println("  [Email] Gonderildi -> " + recipient);
    }
}
