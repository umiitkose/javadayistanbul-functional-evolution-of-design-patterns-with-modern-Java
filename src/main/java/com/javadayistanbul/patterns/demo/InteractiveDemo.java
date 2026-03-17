package com.javadayistanbul.patterns.demo;

import java.util.Scanner;

public class InteractiveDemo {

    private static final String[] PATTERN_NAMES = {
            "Strategy Pattern",
            "Builder Pattern",
            "Template Method Pattern",
            "Decorator Pattern",
            "Visitor Pattern",
            "Observer Pattern",
            "Factory Method Pattern",
            "State Pattern",
            "Chain of Responsibility Pattern",
            "Command Pattern",
            "Adapter Pattern"
    };

    private static final Runnable[] DEMOS = {
            StrategyDemo::run,
            BuilderDemo::run,
            TemplateMethodDemo::run,
            DecoratorDemo::run,
            VisitorDemo::run,
            ObserverDemo::run,
            FactoryDemo::run,
            StateDemo::run,
            ChainOfResponsibilityDemo::run,
            CommandDemo::run,
            AdapterDemo::run
    };

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("  Seciminiz (0-12): ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("  Gecersiz giris!\n");
                continue;
            }

            if (choice == 0) {
                System.out.println("\n  Iyi sunumlar!\n");
                break;
            }

            if (choice == 12) {
                System.out.println();
                for (int i = 0; i < DEMOS.length; i++) {
                    DEMOS[i].run();
                    if (i < DEMOS.length - 1) {
                        System.out.println("\n" + "-".repeat(60) + "\n");
                    }
                }
                System.out.println();
                continue;
            }

            if (choice >= 1 && choice <= 11) {
                System.out.println();
                DEMOS[choice - 1].run();
                System.out.println();
            } else {
                System.out.println("  Gecersiz secim!\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("#".repeat(60));
        System.out.println("#  JavaDay Istanbul - Design Patterns Demo");
        System.out.println("#".repeat(60));
        System.out.println();
        System.out.println("  SUNUM PATTERN'LERI:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("    [%2d] %s%n", i + 1, PATTERN_NAMES[i]);
        }
        System.out.println();
        System.out.println("  BONUS PATTERN'LER:");
        for (int i = 5; i < PATTERN_NAMES.length; i++) {
            System.out.printf("    [%2d] %s%n", i + 1, PATTERN_NAMES[i]);
        }
        System.out.println();
        System.out.println("  DIGER:");
        System.out.println("    [12] Tumunu calistir");
        System.out.println("    [ 0] Cikis");
        System.out.println();
    }
}
