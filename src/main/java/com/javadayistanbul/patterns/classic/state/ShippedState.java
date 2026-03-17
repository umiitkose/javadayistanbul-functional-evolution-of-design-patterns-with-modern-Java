package com.javadayistanbul.patterns.classic.state;

public class ShippedState implements OrderState {
    @Override
    public void next(OrderContext context) {
        System.out.println("    Siparis teslim edildi!");
        context.setState(new DeliveredState());
    }

    @Override
    public void previous(OrderContext context) {
        System.out.println("    Siparis isleme geri aliniyor...");
        context.setState(new ProcessingState());
    }

    @Override
    public String getStatus() {
        return "KARGODA";
    }
}
