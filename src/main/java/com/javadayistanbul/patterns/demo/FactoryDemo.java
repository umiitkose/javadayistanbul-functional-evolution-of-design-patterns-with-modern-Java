package com.javadayistanbul.patterns.demo;


import com.javadayistanbul.patterns.classic.factory.NotificationClassicFactory;
import com.javadayistanbul.patterns.classic.factory.NotificationClassicService;
import com.javadayistanbul.patterns.classic.factory.NotificationClassicType;

public class FactoryDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  FACTORY METHOD PATTERN");
        IO.println("  Java Feature: Sealed Interface + Pattern Matching");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Enum + Factory + Interface) ---");
        IO.println("  [6 dosya: 1 enum + 1 interface + 3 concrete + 1 factory]");
        IO.println();

        NotificationClassicService email = NotificationClassicFactory.create(NotificationClassicType.EMAIL);
        NotificationClassicService sms = NotificationClassicFactory.create(NotificationClassicType.SMS);
        NotificationClassicService push = NotificationClassicFactory.create(NotificationClassicType.PUSH);

        email.send("ahmet@email.com", "Sipaarisiniz onaylandi!");
        sms.send("+90 555 123 4567", "Sipaarisiniz kargoda!");
        push.send("device-token-123", "Teslimat yaklasıyor!");
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Sealed + Pattern Matching) ---");
        IO.println("  [1 dosya: sealed interface + record + switch + BiConsumer]");
        IO.println("  Factory class yok! Concrete class yok!");
        IO.println("  Compiler exhaustiveness kontrolu!");
        IO.println();

        // Varolan enum tabanlı sender'lar
        com.javadayistanbul.patterns.modern.factory.NotificationService.EMAIL.send("ahmet@email.com", "Sipaarisiniz onaylandi!");
        com.javadayistanbul.patterns.modern.factory.NotificationService.SMS.send("+90 555 123 4567", "Sipaarisiniz kargoda!");
        com.javadayistanbul.patterns.modern.factory.NotificationService.PUSH.send("device-token-123", "Teslimat yaklasıyor!");

    }

    public static void main(String[] args) {
        run();
    }
}
