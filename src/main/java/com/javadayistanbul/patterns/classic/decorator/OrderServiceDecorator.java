package com.javadayistanbul.patterns.classic.decorator;

/**
 * Somut decorator'larin ortak sarmalayan referansi; GoF'deki abstract Decorator rolu.
 */
public abstract class OrderServiceDecorator implements OrderService {

    protected final OrderService wrapped;

    protected OrderServiceDecorator(OrderService wrapped) {
        this.wrapped = wrapped;
    }
}
