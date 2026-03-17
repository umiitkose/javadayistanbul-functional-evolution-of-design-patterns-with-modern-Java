package com.javadayistanbul.patterns.classic.decorator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record Order(String id, BigDecimal basePrice, BigDecimal totalPrice, List<String> features) {

    public Order {
        features = List.copyOf(features);
    }

    public Order(String id, BigDecimal basePrice) {
        this(id, basePrice, basePrice, List.of());
    }

    public Order addFeature(String feature, BigDecimal extraCost) {
        var newFeatures = new ArrayList<>(features);
        newFeatures.add(feature);
        return new Order(id, basePrice, totalPrice.add(extraCost), newFeatures);
    }
}
