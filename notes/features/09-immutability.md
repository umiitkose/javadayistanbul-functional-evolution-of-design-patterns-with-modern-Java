# Immutability (Değişmezlik)

## Başlık
Java'da Immutability — Record, degismez koleksiyonlar ve defensive copying.

---

## Nedir?
**Immutability (değişmezlik)**, bir nesnenin oluşturulduktan sonra **iç durumunun değiştirilememesi**dir. Alanlar `final`, setter yok; değişiklik gerektiğinde **yeni nesne** döndürülür (wither pattern). Böylece yan etkiler azalır, hata ayıklama ve paralel kullanım daha güvenli hale gelir.

---

## Hangi Java Versiyonunda Geldi?
- **Record (varsayılan immutable yapı):** Java 16 (preview 14)
- **List.of(), Map.of(), Set.of(), List.copyOf():** Java 9/10 — degismez koleksiyonlar

---

## Neden Eklendi?
- Yan etkileri azaltmak; bir nesneyi geçirdiğiniz yerde değiştirilmeyeceğini garanti etmek
- Çoklu iş parçacığı (thread safety) için ek senkronizasyon ihtiyacını düşürmek
- Hata ayıklamada "kim değiştirdi?" sorusunu ortadan kaldırmak
- Fonksiyonel ve domain odaklı tasarımda değer nesnelerini güvenle paylaşmak

---

## Temel Syntax

```java
// Record — alanlar final, setter yok
public record Order(String id, BigDecimal basePrice, List<String> features) {
    public Order {
        features = List.copyOf(features);  // defensive copy
    }
}

// Degismez koleksiyonlar
List<String> list = List.of("a", "b");
List<String> copy = List.copyOf(mutableList);

// Wither: yeni nesne döndür
public Order withShippingAddress(String address) {
    return new Order(id, customerName, amount, address, stockQuantity);
}
```

---

## Projede Nerelerde Kullanıldı?

| Desen | Dosya | Kullanım |
|-------|--------|----------|
| **Builder / Domain** | `modern/decorator/Order.java`, `OrderValidation.Order` | `record Order(...)` — tüm alanlar final; compact constructor'da `List.copyOf(features)` ile liste dışarıdan değiştirilemez |
| **Decorator** | `modern/decorator/Order.java` | `addFeature(name, cost)` **yeni Order döndürür**, mevcut nesneyi değiştirmez; zincir: `orderClassic.addFeature("A",x).addFeature("B",y)` |
| **Chain of Responsibility** | `OrderValidation.Order` | Sipariş validation sırasında **nesne değişmez**; validator'lar sadece okur, Order'ı mutate etmez |

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (Mutable — setter ile değişim):**
```java
orderClassic.setShippingAddress("Istanbul");
orderClassic.getFeatures().add("Hediye Paketi");  // Liste dışarıdan değiştirilebilir!
```

**Sonrası (Immutable — wither + copy):**
```java
Order updated = orderClassic.withShippingAddress("Istanbul");
Order withGift = orderClassic.addFeature("Hediye Paketi", new BigDecimal("15"));
// features = List.copyOf(features) ile constructor'da liste kopyalanır, dışarıdan değişiklik yansımaz
```

---

## Dikkat Edilmesi Gerekenler

- **Neden önemli:** Yan etki yok; aynı nesneyi birçok yerde güvenle kullanabilirsiniz. Paralel işlemde ek kilitleme gerekmez. Hata ayıklama kolaylaşır.
- **Maliyet:** Her "değişiklik" yeni nesne demek — daha fazla kısa ömürlü nesne, GC üzerinde ek yük. Modern JVM ve GC bu tür kullanımı iyi optimize eder; çoğu uygulamada ihmal edilebilir.
- **Defensive copying:** Record içinde `List`/`Map` tutuyorsanız constructor'da `List.copyOf(...)` kullanın; dışarıdan verilen koleksiyonun sonradan değiştirilmesi immutable garantisini bozar.
- **Wither pattern:** `withX(value)` ile yeni nesne döndürmek, setter kullanmamak — isimlendirme net olur ve fluent zincir kurulabilir.
