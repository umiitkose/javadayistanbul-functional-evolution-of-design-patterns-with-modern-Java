package com.javadayistanbul.patterns.classic.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Cok alanli (20) ornek domain modeli; {@link OrderClassic} ile ayni paket ve Builder yaklasimi.
 * Bazi alanlar {@link Builder#build()} sirasinda validasyon edilir.
 */
public final class StockReservationClassic {

    private final String reservationId;
    private final String warehouseId;
    private final String sku;
    private final int requestedQuantity;
    private final int reservedQuantity;
    private final BigDecimal unitCost;
    private final BigDecimal discountPercent;
    private final BigDecimal vatPercent;
    private final String currencyCode;
    private final String aisleCode;
    private final String binCode;
    private final int priorityBand;
    private final BigDecimal grossWeightKg;
    private final BigDecimal netWeightKg;
    private final LocalDate bestBeforeDate;
    private final String batchNumber;
    private final String lotSerial;
    private final String hazmatCategory;
    private final String originCountryCode;
    private final String internalNotes;

    private StockReservationClassic(Builder builder) {
        this.reservationId = builder.reservationId;
        this.warehouseId = builder.warehouseId;
        this.sku = builder.sku;
        this.requestedQuantity = builder.requestedQuantity;
        this.reservedQuantity = builder.reservedQuantity;
        this.unitCost = builder.unitCost;
        this.discountPercent = builder.discountPercent;
        this.vatPercent = builder.vatPercent;
        this.currencyCode = builder.currencyCode;
        this.aisleCode = builder.aisleCode;
        this.binCode = builder.binCode;
        this.priorityBand = builder.priorityBand;
        this.grossWeightKg = builder.grossWeightKg;
        this.netWeightKg = builder.netWeightKg;
        this.bestBeforeDate = builder.bestBeforeDate;
        this.batchNumber = builder.batchNumber;
        this.lotSerial = builder.lotSerial;
        this.hazmatCategory = builder.hazmatCategory;
        this.originCountryCode = builder.originCountryCode;
        this.internalNotes = builder.internalNotes;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getSku() {
        return sku;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getVatPercent() {
        return vatPercent;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getAisleCode() {
        return aisleCode;
    }

    public String getBinCode() {
        return binCode;
    }

    public int getPriorityBand() {
        return priorityBand;
    }

    public BigDecimal getGrossWeightKg() {
        return grossWeightKg;
    }

    public BigDecimal getNetWeightKg() {
        return netWeightKg;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public String getLotSerial() {
        return lotSerial;
    }

    public String getHazmatCategory() {
        return hazmatCategory;
    }

    public String getOriginCountryCode() {
        return originCountryCode;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    @Override
    public String toString() {
        return "StockReservationClassic{" +
                "reservationId='" + reservationId + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", sku='" + sku + '\'' +
                ", requestedQuantity=" + requestedQuantity +
                ", reservedQuantity=" + reservedQuantity +
                ", unitCost=" + unitCost +
                ", discountPercent=" + discountPercent +
                ", vatPercent=" + vatPercent +
                ", currencyCode='" + currencyCode + '\'' +
                ", aisleCode='" + aisleCode + '\'' +
                ", binCode='" + binCode + '\'' +
                ", priorityBand=" + priorityBand +
                ", grossWeightKg=" + grossWeightKg +
                ", netWeightKg=" + netWeightKg +
                ", bestBeforeDate=" + bestBeforeDate +
                ", batchNumber='" + batchNumber + '\'' +
                ", lotSerial='" + lotSerial + '\'' +
                ", hazmatCategory='" + hazmatCategory + '\'' +
                ", originCountryCode='" + originCountryCode + '\'' +
                ", internalNotes='" + internalNotes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StockReservationClassic that = (StockReservationClassic) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId);
    }

    public static class Builder {
        private final String reservationId;
        private final String warehouseId;
        private final String sku;
        private int requestedQuantity;
        private int reservedQuantity;
        private BigDecimal unitCost = BigDecimal.ZERO;
        private BigDecimal discountPercent = BigDecimal.ZERO;
        private BigDecimal vatPercent = BigDecimal.ZERO;
        private String currencyCode = "TRY";
        private String aisleCode;
        private String binCode;
        private int priorityBand = 5;
        private BigDecimal grossWeightKg;
        private BigDecimal netWeightKg;
        private LocalDate bestBeforeDate;
        private String batchNumber;
        private String lotSerial;
        private String hazmatCategory;
        private String originCountryCode;
        private String internalNotes;

        public Builder(String reservationId, String warehouseId, String sku) {
            this.reservationId = reservationId;
            this.warehouseId = warehouseId;
            this.sku = sku;
        }

        public Builder requestedQuantity(int requestedQuantity) {
            this.requestedQuantity = requestedQuantity;
            return this;
        }

        public Builder reservedQuantity(int reservedQuantity) {
            this.reservedQuantity = reservedQuantity;
            return this;
        }

        public Builder unitCost(BigDecimal unitCost) {
            this.unitCost = unitCost;
            return this;
        }

        public Builder discountPercent(BigDecimal discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder vatPercent(BigDecimal vatPercent) {
            this.vatPercent = vatPercent;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder aisleCode(String aisleCode) {
            this.aisleCode = aisleCode;
            return this;
        }

        public Builder binCode(String binCode) {
            this.binCode = binCode;
            return this;
        }

        public Builder priorityBand(int priorityBand) {
            this.priorityBand = priorityBand;
            return this;
        }

        public Builder grossWeightKg(BigDecimal grossWeightKg) {
            this.grossWeightKg = grossWeightKg;
            return this;
        }

        public Builder netWeightKg(BigDecimal netWeightKg) {
            this.netWeightKg = netWeightKg;
            return this;
        }

        public Builder bestBeforeDate(LocalDate bestBeforeDate) {
            this.bestBeforeDate = bestBeforeDate;
            return this;
        }

        public Builder batchNumber(String batchNumber) {
            this.batchNumber = batchNumber;
            return this;
        }

        public Builder lotSerial(String lotSerial) {
            this.lotSerial = lotSerial;
            return this;
        }

        public Builder hazmatCategory(String hazmatCategory) {
            this.hazmatCategory = hazmatCategory;
            return this;
        }

        public Builder originCountryCode(String originCountryCode) {
            this.originCountryCode = originCountryCode;
            return this;
        }

        public Builder internalNotes(String internalNotes) {
            this.internalNotes = internalNotes;
            return this;
        }

        public StockReservationClassic build() {
            if (reservationId == null || reservationId.isBlank()) {
                throw new IllegalStateException("Rezervasyon ID zorunludur");
            }
            if (warehouseId == null || warehouseId.isBlank()) {
                throw new IllegalStateException("Depo ID zorunludur");
            }
            if (sku == null || sku.isBlank()) {
                throw new IllegalStateException("SKU zorunludur");
            }
            if (requestedQuantity <= 0) {
                throw new IllegalStateException("Talep miktari sifirdan buyuk olmalidir");
            }
            if (reservedQuantity < 0) {
                throw new IllegalStateException("Rezerve miktar negatif olamaz");
            }
            if (reservedQuantity > requestedQuantity) {
                throw new IllegalStateException("Rezerve miktar talep miktarini asamaz");
            }
            if (unitCost == null || unitCost.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalStateException("Birim maliyet negatif olamaz");
            }
            if (discountPercent == null
                    || discountPercent.compareTo(BigDecimal.ZERO) < 0
                    || discountPercent.compareTo(new BigDecimal("100")) > 0) {
                throw new IllegalStateException("Indirim yuzdesi 0 ile 100 arasinda olmalidir");
            }
            if (vatPercent == null
                    || vatPercent.compareTo(BigDecimal.ZERO) < 0
                    || vatPercent.compareTo(new BigDecimal("100")) > 0) {
                throw new IllegalStateException("KDV yuzdesi 0 ile 100 arasinda olmalidir");
            }
            if (currencyCode == null || currencyCode.length() != 3) {
                throw new IllegalStateException("Para birimi kodu tam 3 karakter olmalidir (ornegin TRY)");
            }
            if (priorityBand < 1 || priorityBand > 10) {
                throw new IllegalStateException("Oncelik bandi 1 ile 10 arasinda olmalidir");
            }
            if (grossWeightKg != null && grossWeightKg.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalStateException("Brut agirlik sifirdan buyuk olmalidir");
            }
            if (netWeightKg != null && grossWeightKg != null
                    && netWeightKg.compareTo(grossWeightKg) > 0) {
                throw new IllegalStateException("Net agirlik brut agirligi asamaz");
            }
            if (bestBeforeDate != null && bestBeforeDate.isBefore(LocalDate.now())) {
                throw new IllegalStateException("Son kullanma tarihi gecmis olamaz");
            }
            if (hazmatCategory != null && !hazmatCategory.isBlank() && hazmatCategory.length() > 16) {
                throw new IllegalStateException("Tehlikeli madde kodu en fazla 16 karakter olabilir");
            }
            if (originCountryCode != null && !originCountryCode.isBlank()
                    && originCountryCode.length() != 2) {
                throw new IllegalStateException("Menşe ulke kodu tam 2 karakter olmalidir (ISO)");
            }
            if (internalNotes != null && internalNotes.length() > 500) {
                throw new IllegalStateException("Ic notlar en fazla 500 karakter olabilir");
            }

            return new StockReservationClassic(this);
        }
    }
}
