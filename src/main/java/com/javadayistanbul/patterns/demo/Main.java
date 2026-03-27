package com.javadayistanbul.patterns.demo;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("#".repeat(60));
        System.out.println("#  JavaDay Istanbul 2026");
        System.out.println("#  Modern Java ile Design Patterns'in Fonksiyonel Evrimi");
        System.out.println("#  Klasik OOP vs Modern Functional - 11 Pattern");
        System.out.println("#".repeat(60));
        System.out.println();

        System.out.println(">>> SUNUM PATTERN'LERI (5 Ana Pattern) <<<");
        System.out.println();

        StrategyDemo.run();
        separator();

        TemplateMethodDemo.run();
        separator();

        DecoratorDemo.run();
        separator();

        BuilderDemo.run();
        separator();

        IteratorStreamDemo.run();
        separator();

        System.out.println(">>> BONUS PATTERN'LER (6 Ek Pattern) <<<");
        System.out.println();

        ObserverDemo.run();
        separator();

        FactoryDemo.run();
        separator();

        StateDemo.run();
        separator();

        ChainOfResponsibilityDemo.run();
        separator();

        CommandDemo.run();
        separator();

        AdapterDemo.run();

        System.out.println();
        System.out.println("#".repeat(60));
        System.out.println("#  Tum pattern'ler tamamlandi!");
        System.out.println("#  GitHub: github.com/umiitkose/javadayistanbul-modern-java-design-patterns");
        System.out.println("#".repeat(60));
    }

    private static void separator() {
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println();
    }
}
