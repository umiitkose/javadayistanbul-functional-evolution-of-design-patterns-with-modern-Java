package com.javadayistanbul.patterns.classic.templatemethod;

public abstract class AbstractReportGenerator {

    public final void generate(ReportData data) {
        validateData(data);
        String formatted = formatData(data);
        String output = renderOutput(formatted, data.getTitle());
        sendReport(output);
    }

    protected abstract void validateData(ReportData data);

    protected abstract String formatData(ReportData data);

    protected abstract String renderOutput(String formatted, String title);

    protected abstract void sendReport(String output);
}
