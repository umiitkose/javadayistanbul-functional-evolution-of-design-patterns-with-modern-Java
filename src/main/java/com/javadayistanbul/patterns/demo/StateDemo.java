package com.javadayistanbul.patterns.demo;

public class StateDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  STATE PATTERN");
        IO.println("  Java Feature: Sealed Interface + Record + Switch");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (State Interface + Context) ---");
        IO.println("  [6 dosya: 1 interface + 4 state class + 1 context]");
        IO.println();

        var context = new com.javadayistanbul.patterns.classic.state.OrderContext();
        IO.println("  Durum: " + context.getStatus());

        context.next();
        IO.println("  Durum: " + context.getStatus());

        context.next();
        IO.println("  Durum: " + context.getStatus());

        context.next();
        IO.println("  Durum: " + context.getStatus());

        context.next();
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Sealed + Record + Pattern Matching) ---");
        IO.println("  [1 dosya: sealed interface + 4 record + switch expression]");
        IO.println("  State class yok! Context class yok!");
        IO.println();

        var state = (com.javadayistanbul.patterns.modern.state.OrderState) new com.javadayistanbul.patterns.modern.state.OrderState.Pending();
        IO.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        IO.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        IO.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        IO.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        com.javadayistanbul.patterns.modern.state.OrderState.next(state);
    }

    public static void main(String[] args) {
        run();
    }
}
