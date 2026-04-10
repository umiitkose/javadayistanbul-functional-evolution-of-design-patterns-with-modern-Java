package com.javadayistanbul.patterns.classic.state;

public class DeliveredState implements OrderState {
    @Override
    public void next(OrderContext context) {
        IO.println("    Siparis zaten teslim edildi!");
    }

    @Override
    public void previous(OrderContext context) {
        IO.println("    Teslim edilen siparis geri alinamiyor!");
    }

    @Override
    public String getStatus() {
        return "TESLIM EDILDI";
    }
}
