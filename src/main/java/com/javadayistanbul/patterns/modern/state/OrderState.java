package com.javadayistanbul.patterns.modern.state;

public sealed interface OrderState {

    record Pending() implements OrderState {}
    record Processing() implements OrderState {}
    record Shipped() implements OrderState {}
    record Delivered() implements OrderState {}

    static OrderState next(OrderState current) {
        return switch (current) {
            case Pending p -> {
                System.out.println("    Siparis isleme aliniyor...");
                yield new Processing();
            }
            case Processing pr -> {
                System.out.println("    Siparis kargoya veriliyor...");
                yield new Shipped();
            }
            case Shipped s -> {
                System.out.println("    Siparis teslim edildi!");
                yield new Delivered();
            }
            case Delivered d -> {
                System.out.println("    Siparis zaten teslim edildi!");
                yield d;
            }
        };
    }

    static OrderState previous(OrderState current) {
        return switch (current) {
            case Pending p -> {
                System.out.println("    Siparis zaten baslangic durumunda!");
                yield p;
            }
            case Processing pr -> {
                System.out.println("    Siparis beklemeye aliniyor...");
                yield new Pending();
            }
            case Shipped s -> {
                System.out.println("    Siparis isleme geri aliniyor...");
                yield new Processing();
            }
            case Delivered d -> {
                System.out.println("    Teslim edilen siparis geri alinamiyor!");
                yield d;
            }
        };
    }

    static String getStatus(OrderState state) {
        return switch (state) {
            case Pending p -> "BEKLEMEDE";
            case Processing pr -> "ISLENIYOR";
            case Shipped s -> "KARGODA";
            case Delivered d -> "TESLIM EDILDI";
        };
    }
}
