# Method Reference (Metot Referansları)

## Başlık
Java'da Method Reference — Lambda yerine mevcut metotları referans gösterme.

---

## Nedir?
**Method reference**, bir lambda ifadesinin sadece mevcut bir metodu çağırdığı durumlarda kullanılabilecek kısa yazım biçimidir. `::` operatörü ile sınıf veya nesne adı ve metot adı verilir; daha okunaklı ve bazen daha verimli kod sağlar.

---

## Hangi Java Versiyonunda Geldi?
**Java 8.**

---

## Neden Eklendi?
- Sadece “şu metodu çağır” diyen lambda'ları kısaltmak
- Okunabilirliği artırmak ve niyeti netleştirmek
- Bazı durumlarda derleyici/ JVM optimizasyonlarına imkân vermek

---

## Temel Sözdizimi — 4 Tür

| Tür | Sözdizimi | Örnek |
|-----|-----------|--------|
| **Static metot** | `ClassName::staticMethod` | `Integer::parseInt` |
| **Belirli nesne üzerinde instance** | `instance::method` | `orderPrinter::print` |
| **Keyfi nesne üzerinde instance** | `ClassName::instanceMethod` | `Order.Item::total` |
| **Constructor** | `ClassName::new` | `ArrayList::new` |

**Projede görülen örnekler:**
```java
// Template Method: Item'ın total() metodu — keyfi nesne
.map(Order.Item::total)

// Stream reduce: BigDecimal.add — static gibi kullanım (ilk argüman receiver)
.reduce(BigDecimal.ZERO, BigDecimal::add)

// Visitor tarzı kullanım: OrderItem::calculateTax, OrderItem::calculateDiscount (static)
OrderItem.calculateTax(item);
```

---

## Projede Nerelerde Kullanıldı?

- **Template Method:** `OrderProcessor.standard()` / `premium()` içinde `orderClassic.items().stream().map(Order.Item::total)` — her kalemin toplamı hesaplanıyor.
- **Visitor (veri yapısı):** `OrderItem` sealed interface'inde `calculateTax(OrderItem item)` ve `calculateDiscount(OrderItem item)` static metotlar; switch ile tipe göre hesaplama yapılıyor (method reference doğrudan bu metotlara geçirilebilir).
- **Stream:** `BigDecimal::add` — reduce'da birleştirici olarak.

---

## Lambda vs Method Reference Okunabilirlik

**Lambda:**
```java
.map(item -> item.total())
.reduce(BigDecimal.ZERO, (a, b) -> a.add(b))
```

**Method reference:**
```java
.map(Order.Item::total)
.reduce(BigDecimal.ZERO, BigDecimal::add)
```

Method reference, “hangi metodu kullandığını” isim üzerinden verdiği için özellikle tek metot çağrılarında daha sade ve anlaşılırdır.

---

## Dikkat Edilmesi Gerekenler

- Method reference'ın imzası, hedef fonksiyonel arayüzün metot imzasıyla uyumlu olmalıdır (parametre sayısı ve türleri, dönüş tipi).
- `ClassName::instanceMethod` kullanıldığında ilk parametre “receiver” (metodun çağrıldığı nesne) olur; `(a, b) -> a.add(b)` ↔ `BigDecimal::add` gibi.
- Constructor reference `ClassName::new` generic tip ile birlikte kullanılabilir: `Supplier<List<String>> listSupplier = ArrayList::new`.

---

## Sunumda Hatırlatma

- **Static:** `Integer::parseInt` — sınıf üzerinden.
- **Instance (belirli):** `this::validate` veya `printer::print` — tek nesne.
- **Instance (keyfi):** `String::toLowerCase` — ilk parametre receiver; stream'de çok kullanılır.
- **Constructor:** `OrderEvent::new` — `(a, b, c) -> new OrderEvent(a, b, c)` yerine.
