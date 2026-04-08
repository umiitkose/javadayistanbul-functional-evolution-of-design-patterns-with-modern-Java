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
        System.out.println("=".repeat(60));
        System.out.println("  TEMPLATE METHOD — Rapor Uretimi");
        System.out.println("  Java Feature: Higher-Order Functions & Composition");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
        System.out.println();
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
        System.out.println("--- Klasik Yaklasim (Abstract Class + Inheritance) ---");
        System.out.println("  [6 dosya: 1 abstract + 4 concrete + 1 ReportData]");
        System.out.println("  Her yeni format icin yeni sinif gerekir!");
        System.out.println();

        var data = classicData();

        System.out.println("  >> PDF:");
        new PdfReportGenerator().generate(data);
        System.out.println();

        System.out.println("  >> Excel:");
        new ExcelReportGenerator().generate(data);
        System.out.println();

        System.out.println("  >> HTML:");
        new HtmlReportGenerator().generate(data);
        System.out.println();

        System.out.println("  >> Email:");
        new EmailReportGenerator("yonetim@sirket.com").generate(data);
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Function Injection) ---");
        System.out.println("  [2 dosya: 1 record + 1 ReportData]");
        System.out.println("  Abstract class yok! 4 format, 1 dosya!");
        System.out.println();

        var data = modernData();

        System.out.println("  >> PDF:");
        ReportGenerator.pdf().generate(data);
        System.out.println();

        System.out.println("  >> Excel:");
        ReportGenerator.excel().generate(data);
        System.out.println();

        System.out.println("  >> HTML:");
        ReportGenerator.html().generate(data);
        System.out.println();

        System.out.println("  >> Email:");
        ReportGenerator.email("yonetim@sirket.com").generate(data);
    }

    private static void modernCustomApproach() {
        System.out.println("--- Modern: Runtime'da Ozel Format (custom) ---");
        System.out.println("  Yeni sinif yok! 4 lambda ile Slack bildirimi:");
        System.out.println();

        var data = modernData();

        ReportGenerator slackReport = ReportGenerator.custom(
                d -> System.out.println("  [Slack] Dogrulandi: " + d.rows().size() + " satir"),
                d -> {
                    var sb = new StringBuilder();
                    sb.append("*").append(d.title()).append("*\n");
                    d.rows().forEach(row ->
                            sb.append("• ").append(String.join(" — ", row)).append("\n")
                    );
                    return sb.toString();
                },
                formatted -> "```\n" + formatted + "```",
                output -> System.out.println("  [Slack] #rapor kanalina gonderildi:\n" + output)
        );

        slackReport.generate(data);
    }

    public static void main(String[] args) {
        run();
    }
}
