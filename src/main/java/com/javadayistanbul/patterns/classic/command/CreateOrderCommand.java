package com.javadayistanbul.patterns.classic.command;

public class CreateOrderCommand implements OrderCommand {
    private final String orderId;
    private final String customerName;

    public CreateOrderCommand(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    @Override
    public void execute() {
        System.out.println("    Siparis olusturuldu: #" + orderId + " | Musteri: " + customerName);
    }
}
