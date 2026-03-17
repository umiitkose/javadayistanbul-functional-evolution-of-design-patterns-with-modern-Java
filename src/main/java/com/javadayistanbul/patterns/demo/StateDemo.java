package com.javadayistanbul.patterns.demo;

public class StateDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  STATE PATTERN");
        System.out.println("  Java Feature: Sealed Interface + Record + Switch");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (State Interface + Context) ---");
        System.out.println("  [6 dosya: 1 interface + 4 state class + 1 context]");
        System.out.println();

        var context = new com.javadayistanbul.patterns.classic.state.OrderContext();
        System.out.println("  Durum: " + context.getStatus());

        context.next();
        System.out.println("  Durum: " + context.getStatus());

        context.next();
        System.out.println("  Durum: " + context.getStatus());

        context.next();
        System.out.println("  Durum: " + context.getStatus());

        context.next();
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Sealed + Record + Pattern Matching) ---");
        System.out.println("  [1 dosya: sealed interface + 4 record + switch expression]");
        System.out.println("  State class yok! Context class yok!");
        System.out.println();

        var state = (com.javadayistanbul.patterns.modern.state.OrderState) new com.javadayistanbul.patterns.modern.state.OrderState.Pending();
        System.out.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        System.out.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        System.out.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        state = com.javadayistanbul.patterns.modern.state.OrderState.next(state);
        System.out.println("  Durum: " + com.javadayistanbul.patterns.modern.state.OrderState.getStatus(state));

        com.javadayistanbul.patterns.modern.state.OrderState.next(state);
    }

    public static void main(String[] args) {
        run();
    }
}
