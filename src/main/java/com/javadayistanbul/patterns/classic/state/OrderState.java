package com.javadayistanbul.patterns.classic.state;

public interface OrderState {
    void next(OrderContext context);
    void previous(OrderContext context);
    String getStatus();
}
