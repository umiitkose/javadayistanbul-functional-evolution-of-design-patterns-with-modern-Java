package com.javadayistanbul.patterns.classic.visitor;

public interface OrderItemVisitor {
    void visit(BookItem book);

    void visit(ElectronicsItem electronics);

    void visit(FoodItem food);
}
