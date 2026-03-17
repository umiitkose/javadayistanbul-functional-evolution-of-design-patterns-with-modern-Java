package com.javadayistanbul.patterns.classic.state;

public class PendingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        System.out.println("    Siparis isleme aliniyor...");
        context.setState(new ProcessingState());
    }

    @Override
    public void previous(OrderContext context) {
        System.out.println("    Siparis zaten baslangic durumunda!");
    }

    @Override
    public String getStatus() {
        return "BEKLEMEDE";
    }
}
