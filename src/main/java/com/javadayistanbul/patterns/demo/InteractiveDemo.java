package com.javadayistanbul.patterns.demo;

import java.util.Scanner;

public class InteractiveDemo {

    private static final String[] PATTERN_NAMES = {
            "Strategy Pattern",
            "Template Method Pattern",
            "Decorator Pattern",
            "Builder Pattern",
            "Iterator/Stream Pattern",
            "Observer Pattern",
            "Factory Method Pattern",
            "State Pattern",
            "Chain of Responsibility Pattern",
            "Command Pattern",
            "Adapter Pattern"
    };

    private static final Runnable[] DEMOS = {
            StrategyDemo::run,
            TemplateMethodDemo::run,
            DecoratorDemo::run,
            BuilderDemo::run,
            IteratorStreamDemo::run,
            ObserverDemo::run,
            FactoryDemo::run,
            StateDemo::run,
            ChainOfResponsibilityDemo::run,
            CommandDemo::run,
            AdapterDemo::run
    };

    static void main() {
        var scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            IO.print("  Seciminiz (0-12): ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                IO.println("  Gecersiz giris!\n");
                continue;
            }

            if (choice == 0) {
                IO.println("\n  Iyi sunumlar!\n");
                break;
            }

            if (choice == 12) {
                IO.println();
                for (int i = 0; i < DEMOS.length; i++) {
                    DEMOS[i].run();
                    if (i < DEMOS.length - 1) {
                        IO.println("\n" + "-".repeat(60) + "\n");
                    }
                }
                IO.println();
                continue;
            }

            if (choice >= 1 && choice <= 11) {
                IO.println();
                DEMOS[choice - 1].run();
                IO.println();
            } else {
                IO.println("  Gecersiz secim!\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        IO.println();
        IO.println("#".repeat(60));
        IO.println("#  JavaDay Istanbul - Design Patterns Demo");
        IO.println("#".repeat(60));
        IO.println();
        IO.println("  SUNUM PATTERN'LERI:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("    [%2d] %s%n", i + 1, PATTERN_NAMES[i]);
        }
        IO.println();
        IO.println("  BONUS PATTERN'LER:");
        for (int i = 5; i < PATTERN_NAMES.length; i++) {
            System.out.printf("    [%2d] %s%n", i + 1, PATTERN_NAMES[i]);
        }
        IO.println();
        IO.println("  DIGER:");
        IO.println("    [12] Tumunu calistir");
        IO.println("    [ 0] Cikis");
        IO.println();
    }
}
