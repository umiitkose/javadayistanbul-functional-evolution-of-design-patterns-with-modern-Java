package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.command.*;
import com.javadayistanbul.patterns.modern.command.OrderCommands;

import java.math.BigDecimal;

public class CommandDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  COMMAND PATTERN");
        System.out.println("  Java Feature: Runnable & Method References");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Command Interface + Concrete Classes) ---");
        System.out.println("  [5 dosya: 1 interface + 3 command class + 1 invoker]");
        System.out.println();

        var invoker = new OrderCommandInvoker();

        invoker.executeCommand(new CreateOrderCommand("ORD-001", "Ahmet Yilmaz"));
        invoker.executeCommand(new CancelOrderCommand("ORD-001", "Musteri vazgecti"));
        invoker.executeCommand(new RefundCommand("ORD-001", new BigDecimal("299.99")));

        System.out.println("    Toplam islem: " + invoker.getHistorySize());
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Runnable + Lambda) ---");
        System.out.println("  [1 dosya: Runnable + lambda/method reference]");
        System.out.println("  Command interface yok! Concrete class yok!");
        System.out.println();

        var commands = new OrderCommands();

        commands.execute(OrderCommands.createOrder("ORD-001", "Ahmet Yilmaz"));
        commands.execute(OrderCommands.cancelOrder("ORD-001", "Musteri vazgecti"));
        commands.execute(OrderCommands.refund("ORD-001", new BigDecimal("299.99")));

        System.out.println("    Toplam islem: " + commands.getHistorySize());
    }

    public static void main(String[] args) {
        run();
    }
}
