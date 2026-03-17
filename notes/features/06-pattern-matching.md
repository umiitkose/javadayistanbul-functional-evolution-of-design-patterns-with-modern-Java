# Pattern Matching (Desen Eşleştirme)

## Başlık
Java'da Pattern Matching — instanceof, switch, record patterns ve exhaustiveness kontrolü.

---

## Nedir?
**Pattern matching**, bir değerin yapısını kontrol edip aynı anda değişkene bağlayarak kodu sadeleştirir. `instanceof` ile tür kontrolü + cast tek adımda yapılır; `switch` ile tüm alt tipler tek yerde ele alınır; **record patterns** ile kayıt alanları doğrudan değişkenlere ayrıştırılır.

---

## Hangi Java Versiyonunda Geldi?
- **instanceof pattern matching:** Java 16 (JEP 394)
- **switch pattern matching, guard clauses (when), record patterns:** Java 21 (JEP 441, JEP 440)

---

## Neden Eklendi?
- `if (x instanceof Foo) { Foo f = (Foo) x; ... }` tekrarlarını kaldırmak
- Switch'i sadece primitive/String ile sınırlı olmaktan çıkarıp nesne tipleriyle kullanmak
- Sealed hierarchy ile birlikte **exhaustiveness** (tüm durumların ele alınması) garantisi vermek
- Visitor ve benzeri desenlerde çok sayıda `if-else` yerine tek `switch` kullanmak

---

## Temel Syntax

```java
// instanceof pattern (Java 16+)
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}

// switch pattern (Java 21+)
String result = switch (item) {
    case BookItem b -> "Kitap: " + b.name();
    case ElectronicsItem e -> "Elektronik: " + e.name();
    case FoodItem f -> "Gida: " + f.name();
};

// Guard clause (when)
case BookItem b when b.price().compareTo(BigDecimal.ZERO) > 0 -> ...

// Record pattern (deconstruction)
case Point(int x, int y) -> x + y;
```

---

## Projede Nerelerde Kullanıldı?

| Desen | Dosya | Kullanım |
|-------|--------|----------|
| **Visitor** | `modern/visitor/OrderItem.java` | `switch(item) { case BookItem b -> b.price().multiply(...); case ElectronicsItem e -> ...; case FoodItem f -> ...; }` — KDV ve indirim hesaplama |
| **State** | `modern/state/OrderState.java` | `switch(current) { case Pending p -> new Processing(); case Processing pr -> new Shipped(); ... }` — Sonraki/önceki durum geçişi |
| **Factory** | `modern/factory/NotificationService.java` | `switch(type) { case Email e -> (r, m) -> ...; case Sms s -> ...; case Push p -> ...; }` — Gönderici fonksiyonu üretme |

Sealed interface'ler (`OrderItem`, `OrderState`, `NotificationService`) sayesinde switch'te tüm alt tipler ele alınmazsa **derleyici hata verir** (exhaustiveness).

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (Visitor — instanceof + cast):**
```java
if (item instanceof BookItem) {
    BookItem b = (BookItem) item;
    BigDecimal tax = b.getPrice().multiply(new BigDecimal("0.08"));
    totalTax = totalTax.add(tax);
} else if (item instanceof ElectronicsItem) {
    ElectronicsItem e = (ElectronicsItem) item;
    BigDecimal tax = e.getPrice().multiply(new BigDecimal("0.18"));
    totalTax = totalTax.add(tax);
} else if (item instanceof FoodItem) {
    FoodItem f = (FoodItem) item;
    // ...
}
```

**Sonrası (Pattern matching + sealed):**
```java
return switch (item) {
    case BookItem b -> b.price().multiply(new BigDecimal("0.08"));
    case ElectronicsItem e -> e.price().multiply(new BigDecimal("0.18"));
    case FoodItem f -> f.price().multiply(new BigDecimal("0.01"));
};
```

Yeni bir alt tip (örn. `DigitalItem`) eklendiğinde, bu switch'i güncellemezsen **derleyici hata verir** — exhaustiveness sayesinde unutulan durum kalmaz.

---

## Dikkat Edilmesi Gerekenler

- **Exhaustiveness:** Sadece **sealed** hierarchy'de switch tüm alt tipleri kapsıyorsa exhaustiveness kontrolü yapılır. Sealed değilse `default` gerekebilir.
- **Named patterns:** `case BookItem b` ile `b` pattern variable olarak kullanılır; blok içinde tipi `BookItem`'dır.
- **Record patterns:** `case Point(int x, int y)` ile alanlar doğrudan değişkene bağlanır (deconstruction).
- **Guard (when):** Sadece eşleşen durumda ek koşul için; `case BookItem b when b.quantity() > 1 -> ...`
- **null:** Java 21 switch'te `case null -> ...` yazılabilir; yoksa `null` için NPE riski vardır.
