package com.javadayistanbul.patterns.modern.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderCommands {

    private final List<Runnable> history = new ArrayList<>();

    public static Runnable createOrder(String orderId, String customerName) {
        return () -> System.out.println("    Siparis olusturuldu: #" + orderId + " | Musteri: " + customerName);
    }

    public static Runnable cancelOrder(String orderId, String reason) {
        return () -> System.out.println("    Siparis iptal edildi: #" + orderId + " | Sebep: " + reason);
    }

    public static Runnable refund(String orderId, BigDecimal amount) {
        return () -> System.out.println("    Iade islemi yapildi: #" + orderId + " | Tutar: " + amount + " TL");
    }

    public void execute(Runnable command) {
        command.run();
        history.add(command);
    }

    public int getHistorySize() {
        return history.size();
    }
}
