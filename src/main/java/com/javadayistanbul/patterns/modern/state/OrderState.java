package com.javadayistanbul.patterns.modern.state;

public sealed interface OrderState {

    record Pending() implements OrderState {}
    record Processing() implements OrderState {}
    record Shipped() implements OrderState {}
    record Delivered() implements OrderState {}

    static OrderState next(OrderState current) {
        return switch (current) {
            case Pending p -> {
                IO.println("    Siparis isleme aliniyor...");
                yield p;
            }
            case Processing pr -> {
                IO.println("    Siparis kargoya veriliyor...");
                yield pr;
            }
            case Shipped s -> {
                IO.println("    Siparis teslim edildi!");
                yield s;
            }
            case Delivered d -> {
                IO.println("    Siparis zaten teslim edildi!");
                yield d;
            }
        };
    }

    static OrderState previous(OrderState current) {
        return switch (current) {
            case Pending p -> {
                IO.println("    Siparis zaten baslangic durumunda!");
                yield p;
            }
            case Processing pr -> {
                IO.println("    Siparis beklemeye aliniyor...");
                yield new Pending();
            }
            case Shipped s -> {
                IO.println("    Siparis isleme geri aliniyor...");
                yield new Processing();
            }
            case Delivered d -> {
                IO.println("    Teslim edilen siparis geri alinamiyor!");
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
