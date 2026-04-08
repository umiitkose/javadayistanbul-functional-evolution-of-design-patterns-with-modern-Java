package com.javadayistanbul.patterns.classic.templatemethod;

public class HtmlReportGenerator extends AbstractReportGenerator {

    @Override
    protected void validateData(ReportData data) {
        System.out.println("  [HTML] Veri dogrulandi");
    }

    @Override
    protected String formatData(ReportData data) {
        var sb = new StringBuilder();
        sb.append("<tr>");
        for (var col : data.getColumns()) {
            sb.append("<th>").append(col).append("</th>");
        }
        sb.append("</tr>\n");
        for (var row : data.getRows()) {
            sb.append("<tr>");
            for (var cell : row) {
                sb.append("<td>").append(cell).append("</td>");
            }
            sb.append("</tr>\n");
        }
        System.out.println("  [HTML] Tablo satirlari olusturuldu");
        return sb.toString();
    }

    @Override
    protected String renderOutput(String formatted, String title) {
        String output = "<html><body><h1>" + title + "</h1><table>" + formatted + "</table></body></html>";
        System.out.println("  [HTML] HTML sayfasi olusturuldu");
        return output;
    }

    @Override
    protected void sendReport(String output) {
        System.out.println("  [HTML] Web sunucusuna yuklendi: /reports/rapor.html");
    }
}
