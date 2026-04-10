package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.command.*;
import com.javadayistanbul.patterns.modern.command.OrderCommands;

import java.math.BigDecimal;

public class CommandDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  COMMAND PATTERN");
        IO.println("  Java Feature: Runnable & Method References");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Command Interface + Concrete Classes) ---");
        IO.println("  [5 dosya: 1 interface + 3 command class + 1 invoker]");
        IO.println();

        var invoker = new OrderCommandInvoker();

        invoker.executeCommand(new CreateOrderCommand("ORD-001", "Ahmet Yilmaz"));
        invoker.executeCommand(new CancelOrderCommand("ORD-001", "Musteri vazgecti"));
        invoker.executeCommand(new RefundCommand("ORD-001", new BigDecimal("299.99")));

        IO.println("    Toplam islem: " + invoker.getHistorySize());
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Runnable + Lambda) ---");
        IO.println("  [1 dosya: Runnable + lambda/method reference]");
        IO.println("  Command interface yok! Concrete class yok!");
        IO.println();

        var commands = new OrderCommands();

        commands.execute(OrderCommands.createOrder("ORD-001", "Ahmet Yilmaz"));
        commands.execute(OrderCommands.cancelOrder("ORD-001", "Musteri vazgecti"));
        commands.execute(OrderCommands.refund("ORD-001", new BigDecimal("299.99")));

        IO.println("    Toplam islem: " + commands.getHistorySize());
    }

    public static void main(String[] args) {
        run();
    }
}
