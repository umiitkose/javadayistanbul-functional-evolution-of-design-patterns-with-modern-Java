package com.javadayistanbul.patterns.classic.state;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new PendingState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void previous() {
        state.previous(this);
    }

    public String getStatus() {
        return state.getStatus();
    }
}
