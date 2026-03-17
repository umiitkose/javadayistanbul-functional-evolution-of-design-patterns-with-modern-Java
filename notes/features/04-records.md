# Records

## Başlık
Java Record — Değişmez veri taşıyıcıları ve tasarım desenlerinde kullanım.

---

## Nedir?
**Record**, Java'da **sadece veri taşımak** için kullanılan, **immutable** (değişmez) bir türdür. Alanlar final kabul edilir; derleyici otomatik olarak kurucu (canonical constructor), erişimci (getter), `equals`, `hashCode` ve `toString` üretir. Sınıf gibi kalıtım yoktur; arayüz implemente edebilir.

---

## Hangi Java Versiyonunda Geldi?
- **Java 14:** Preview.
- **Java 16:** Stable (LTS dahil).

---

## Neden Eklendi?
- POJO / DTO yazarken tekrarlayan boilerplate (getter, setter, equals, hashCode, toString) kaldırılmak istendi.
- Veri odaklı, değişmeyen modeller için net ve güvenli bir sözleşme sağlamak.
- Sealed hierarchy ve pattern matching ile uyumlu, hafif veri yapıları sunmak.

---

## Temel Sözdizimi

```java
// Basit record
public record OrderEvent(String orderId, String eventType, String details) {}

// Compact constructor ile validasyon
public record Order(String id, BigDecimal basePrice, BigDecimal totalPrice, List<String> features) {
    public Order {
        features = List.copyOf(features);  // defensive copy
    }
}

// Wither (withX) — yeni örnek döndürme
public Order addFeature(String feature, BigDecimal extraCost) {
    var newFeatures = new ArrayList<>(features);
    newFeatures.add(feature);
    return new Order(id, basePrice, totalPrice.add(extraCost), newFeatures);
}
```

Erişimciler alan adıyla aynı isimde, parantezsiz: `orderClassic.id()`, `orderClassic.basePrice()`.

---

## Projede Nerelerde Kullanıldı?

| Desen | Kullanım |
|-------|----------|
| **Builder / veri modeli** | `Order` (decorator): id, basePrice, totalPrice, features; `addFeature` ile yeni Order. |
| **Template Method** | `OrderProcessor` record: validator, totalCalculator, discountApplier, confirmationSender (fonksiyonel alanlar). |
| **Visitor** | `BookItem`, `ElectronicsItem`, `FoodItem` — `OrderItem` sealed interface'ini implement eden record'lar. |
| **State** | `Pending`, `Processing`, `Shipped`, `Delivered` — `OrderState` sealed interface'inin record implementasyonları. |
| **Observer** | `OrderEvent` record: orderId, eventType, details. |
| **Chain of Responsibility** | `OrderValidation.Order` record: id, customerName, amount, shippingAddress, stockQuantity. |

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (klasik POJO, ~90 satır):**
```java
public class OrderEvent {
    private final String orderId;
    private final String eventType;
    private final String details;
    public OrderEvent(String orderId, String eventType, String details) { ... }
    public String getOrderId() { return orderId; }
    public String getEventType() { return eventType; }
    public String getDetails() { return details; }
    @Override public boolean equals(Object o) { ... }
    @Override public int hashCode() { ... }
    @Override public String toString() { ... }
}
```

**Sonrası (record, ~1 satır):**
```java
public record OrderEvent(String orderId, String eventType, String details) {}
```

---

## Dikkat Edilmesi Gerekenler

- **Kalıtım:** Record başka sınıfı extend edemez; sadece interface implement edebilir.
- **Mutable alan:** Tasarım gereği alanlar final'dır; referans türü (List, Map) kullanıyorsanız compact constructor'da kopya alarak immutable davranışı koruyun (ör. `List.copyOf(features)`).
- **Canonical constructor:** Tüm bileşenleri alan tek constructor; compact form `public RecordName { ... }` ile validasyon veya normalizasyon ekleyebilirsiniz.
- **Wither:** “Değişiklik” için yeni record örneği döndüren metotlar (ör. `addFeature`) immutable kullanımı tamamlar.
