package com.javadayistanbul.patterns.modern.builder;

/**
 * Depo ic konum ve oncelik bandi; koridor/kutu opsiyoneldir.
 */
public record StorageSlot(String aisleCode, String binCode, int priorityBand) {

    public static StorageSlot defaults() {
        return new StorageSlot(null, null, 5);
    }

    public StorageSlot {
        if (priorityBand < 1 || priorityBand > 10) {
            throw new IllegalArgumentException("Oncelik bandi 1 ile 10 arasinda olmalidir");
        }
    }
}
