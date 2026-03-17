package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.observer.*;

public class ObserverDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  OBSERVER PATTERN");
        System.out.println("  Java Feature: Consumer<T> & Method References");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Interface + Concrete Listeners) ---");
        System.out.println("  [5 dosya: 1 event + 1 listener interface + 2 concrete + 1 manager]");
        System.out.println();

        var manager = new OrderEventManager();
        manager.subscribe("ORDER_CREATED", new EmailNotificationListener("ahmet@email.com"));
        manager.subscribe("ORDER_CREATED", new SmsNotificationListener("+90 555 123 4567"));
        manager.subscribe("ORDER_SHIPPED", new EmailNotificationListener("ahmet@email.com"));

        System.out.println("  Siparis olusturuldu:");
        manager.notify("ORDER_CREATED", new OrderEvent("ORD-001", "ORDER_CREATED", "Yeni siparis alindi"));
        System.out.println();
        System.out.println("  Siparis kargolandi:");
        manager.notify("ORDER_SHIPPED", new OrderEvent("ORD-001", "ORDER_SHIPPED", "Kargoya verildi"));
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Consumer<T> + Lambda) ---");
        System.out.println("  [1 dosya: record event + Consumer<OrderEvent> + lambda]");
        System.out.println("  Listener interface/class yok! Sadece lambda!");
        System.out.println();

        var manager = new com.javadayistanbul.patterns.modern.observer.OrderEventManager();

        manager.subscribe("ORDER_CREATED", event ->
                System.out.println("    [Email -> ahmet@email.com] " + event.eventType() + ": " + event.details()));
        manager.subscribe("ORDER_CREATED", event ->
                System.out.println("    [SMS -> +90 555 123 4567] " + event.eventType() + ": " + event.details()));
        manager.subscribe("ORDER_SHIPPED", event ->
                System.out.println("    [Email -> ahmet@email.com] " + event.eventType() + ": " + event.details()));

        System.out.println("  Siparis olusturuldu:");
        manager.notify("ORDER_CREATED",
                new com.javadayistanbul.patterns.modern.observer.OrderEventManager.OrderEvent(
                        "ORD-001", "ORDER_CREATED", "Yeni siparis alindi"));
        System.out.println();
        System.out.println("  Siparis kargolandi:");
        manager.notify("ORDER_SHIPPED",
                new com.javadayistanbul.patterns.modern.observer.OrderEventManager.OrderEvent(
                        "ORD-001", "ORDER_SHIPPED", "Kargoya verildi"));
    }

    public static void main(String[] args) {
        run();
    }
}
