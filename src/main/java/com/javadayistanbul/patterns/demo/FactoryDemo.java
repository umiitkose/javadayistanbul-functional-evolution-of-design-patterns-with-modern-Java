package com.javadayistanbul.patterns.demo;


import com.javadayistanbul.patterns.classic.factory.NotificationClassicFactory;
import com.javadayistanbul.patterns.classic.factory.NotificationClassicService;
import com.javadayistanbul.patterns.classic.factory.NotificationClassicType;

public class FactoryDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  FACTORY METHOD PATTERN");
        System.out.println("  Java Feature: Sealed Interface + Pattern Matching");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Enum + Factory + Interface) ---");
        System.out.println("  [6 dosya: 1 enum + 1 interface + 3 concrete + 1 factory]");
        System.out.println();

        NotificationClassicService email = NotificationClassicFactory.create(NotificationClassicType.EMAIL);
        NotificationClassicService sms = NotificationClassicFactory.create(NotificationClassicType.SMS);
        NotificationClassicService push = NotificationClassicFactory.create(NotificationClassicType.PUSH);

        email.send("ahmet@email.com", "Sipaarisiniz onaylandi!");
        sms.send("+90 555 123 4567", "Sipaarisiniz kargoda!");
        push.send("device-token-123", "Teslimat yaklasıyor!");
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Sealed + Pattern Matching) ---");
        System.out.println("  [1 dosya: sealed interface + record + switch + BiConsumer]");
        System.out.println("  Factory class yok! Concrete class yok!");
        System.out.println("  Compiler exhaustiveness kontrolu!");
        System.out.println();

        // Varolan enum tabanlı sender'lar
        com.javadayistanbul.patterns.modern.factory.NotificationService.EMAIL.send("ahmet@email.com", "Sipaarisiniz onaylandi!");
        com.javadayistanbul.patterns.modern.factory.NotificationService.SMS.send("+90 555 123 4567", "Sipaarisiniz kargoda!");
        com.javadayistanbul.patterns.modern.factory.NotificationService.PUSH.send("device-token-123", "Teslimat yaklasıyor!");

    }

    public static void main(String[] args) {
        run();
    }
}
