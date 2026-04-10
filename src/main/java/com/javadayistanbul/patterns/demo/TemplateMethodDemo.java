package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.templatemethod.EmailReportGenerator;
import com.javadayistanbul.patterns.classic.templatemethod.ExcelReportGenerator;
import com.javadayistanbul.patterns.classic.templatemethod.HtmlReportGenerator;
import com.javadayistanbul.patterns.classic.templatemethod.PdfReportGenerator;
import com.javadayistanbul.patterns.modern.templatemethod.ReportData;
import com.javadayistanbul.patterns.modern.templatemethod.ReportGenerator;

import java.util.List;

public class TemplateMethodDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  TEMPLATE METHOD — Rapor Uretimi");
        IO.println("  Java Feature: Higher-Order Functions & Composition");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
        IO.println();
        modernCustomApproach();
    }

    private static com.javadayistanbul.patterns.classic.templatemethod.ReportData classicData() {
        return new com.javadayistanbul.patterns.classic.templatemethod.ReportData(
                "Q1 Satis Raporu",
                List.of("Urun", "Adet", "Gelir"),
                List.of(
                        List.of("Laptop", "42", "126.000 TL"),
                        List.of("Monitor", "87", "43.500 TL"),
                        List.of("Klavye", "210", "10.500 TL")
                )
        );
    }

    private static ReportData modernData() {
        return new ReportData(
                "Q1 Satis Raporu",
                List.of("Urun", "Adet", "Gelir"),
                List.of(
                        List.of("Laptop", "42", "126.000 TL"),
                        List.of("Monitor", "87", "43.500 TL"),
                        List.of("Klavye", "210", "10.500 TL")
                )
        );
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Abstract Class + Inheritance) ---");
        IO.println("  [6 dosya: 1 abstract + 4 concrete + 1 ReportData]");
        IO.println("  Her yeni format icin yeni sinif gerekir!");
        IO.println();

        var data = classicData();

        IO.println("  >> PDF:");
        new PdfReportGenerator().generate(data);
        IO.println();

        IO.println("  >> Excel:");
        new ExcelReportGenerator().generate(data);
        IO.println();

        IO.println("  >> HTML:");
        new HtmlReportGenerator().generate(data);
        IO.println();

        IO.println("  >> Email:");
        new EmailReportGenerator("yonetim@sirket.com").generate(data);
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Function Injection) ---");
        IO.println("  [2 dosya: 1 record + 1 ReportData]");
        IO.println("  Abstract class yok! 4 format, 1 dosya!");
        IO.println();

        var data = modernData();

        IO.println("  >> PDF:");
        ReportGenerator.pdf().generate(data);
        IO.println();

        IO.println("  >> Excel:");
        ReportGenerator.excel().generate(data);
        IO.println();

        IO.println("  >> HTML:");
        ReportGenerator.html().generate(data);
        IO.println();

        IO.println("  >> Email:");
        ReportGenerator.email("yonetim@sirket.com").generate(data);
    }

    private static void modernCustomApproach() {
        IO.println("--- Modern: Runtime'da Ozel Format (custom) ---");
        IO.println("  Yeni sinif yok! 4 lambda ile Slack bildirimi:");
        IO.println();

        var data = modernData();

        ReportGenerator slackReport = ReportGenerator.custom(
                d -> IO.println("  [Slack] Dogrulandi: " + d.rows().size() + " satir"),
                d -> {
                    var sb = new StringBuilder();
                    sb.append("*").append(d.title()).append("*\n");
                    d.rows().forEach(row ->
                            sb.append("• ").append(String.join(" — ", row)).append("\n")
                    );
                    return sb.toString();
                },
                formatted -> "```\n" + formatted + "```",
                output -> IO.println("  [Slack] #rapor kanalina gonderildi:\n" + output)
        );

        slackReport.generate(data);
    }

    public static void main(String[] args) {
        run();
    }
}
