package com.javadayistanbul.patterns.classic.state;

public class ProcessingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        System.out.println("    Siparis kargoya veriliyor...");
        context.setState(new ShippedState());
    }

    @Override
    public void previous(OrderContext context) {
        System.out.println("    Siparis beklemeye aliniyor...");
        context.setState(new PendingState());
    }

    @Override
    public String getStatus() {
        return "ISLENIYOR";
    }
}
