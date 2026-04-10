package com.javadayistanbul.patterns.classic.state;

public class PendingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        IO.println("    Siparis isleme aliniyor...");
        context.setState(new ProcessingState());
    }

    @Override
    public void previous(OrderContext context) {
        IO.println("    Siparis zaten baslangic durumunda!");
    }

    @Override
    public String getStatus() {
        return "BEKLEMEDE";
    }
}
