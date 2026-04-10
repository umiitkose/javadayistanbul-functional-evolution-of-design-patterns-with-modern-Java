package com.javadayistanbul.patterns.demo;

public class Main {

    public static void main(String[] args) {
        IO.println();
        IO.println("#".repeat(60));
        IO.println("#  JavaDay Istanbul 2026");
        IO.println("#  Modern Java ile Design Patterns'in Fonksiyonel Evrimi");
        IO.println("#  Klasik OOP vs Modern Functional - 11 Pattern");
        IO.println("#".repeat(60));
        IO.println();

        IO.println(">>> SUNUM PATTERN'LERI (5 Ana Pattern) <<<");
        IO.println();

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

        IO.println(">>> BONUS PATTERN'LER (6 Ek Pattern) <<<");
        IO.println();

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

        IO.println();
        IO.println("#".repeat(60));
        IO.println("#  Tum pattern'ler tamamlandi!");
        IO.println("#  GitHub: github.com/umiitkose/javadayistanbul-modern-java-design-patterns");
        IO.println("#".repeat(60));
    }

    private static void separator() {
        IO.println();
        IO.println("-".repeat(60));
        IO.println();
    }
}
