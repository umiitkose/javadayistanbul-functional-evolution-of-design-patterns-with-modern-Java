# Sealed Classes (Mühürlü Sınıflar)

## Başlık
Java Sealed Classes — Alt tip kümesinin derleyici tarafından kontrol altına alınması.

---

## Nedir?
**Sealed** bir sınıf veya arayüz, **hangi sınıfların onu extend / implement edebileceğini** `permits` ile sınırlar. Böylece tüm “bilinen” alt tipler derleyici tarafından bilinir; **exhaustiveness checking** (tüketim kontrolü) yapılabilir. Yeni bir alt tip eklendiğinde, örneğin switch'te tüm dalları eklemezseniz derleme hatası alırsınız.

---

## Hangi Java Versiyonunda Geldi?
- **Java 15:** Preview.
- **Java 17:** Stable (LTS).

---

## Neden Eklendi?
- Algebraic veri yapılarını (sabit sayıda varyant) güvenli şekilde modellemek.
- Pattern matching ve switch ile birlikte “tüm durumlar ele alındı mı?” kontrolünü derleyiciye bırakmak.
- Visitor benzeri desenlerde manuel “yeni tip eklendi” hatalarını azaltmak; hatta sealed + switch ile Visitor’a ihtiyacı büyük ölçüde ortadan kaldırmak.

---

## Temel Sözdizimi

```java
// Sealed interface: izin verilen alt tipler permits ile listelenir
public sealed interface OrderItem permits BookItem, ElectronicsItem, FoodItem {
    String name();
    BigDecimal price();
    int quantity();
}

// Alt tipler final, sealed veya non-sealed olmalı
public record BookItem(...) implements OrderItem {}
public record ElectronicsItem(...) implements OrderItem {}
public record FoodItem(...) implements OrderItem {}
```

- **final:** Başka alt sınıf yok.
- **sealed:** Alt sınıflar yine permits ile sınırlı.
- **non-sealed:** Geleneksel extend/implement serbest (dikkatli kullanılmalı).

Aynı dosyada (nested) tanımlanıyorsa `permits` yazmak zorunlu değildir; derleyici izin verilenleri kendisi çıkarır.

---

## Projede Nerelerde Kullanıldı?

| Desen | Kullanım |
|-------|----------|
| **Visitor** | `sealed interface OrderItem` — 3 record: `BookItem`, `ElectronicsItem`, `FoodItem`; `switch (item)` ile KDV ve indirim hesaplanıyor; yeni tip eklenince switch eksik kalırsa derleyici hata verir. |
| **State** | `sealed interface OrderState` — 4 record: `Pending`, `Processing`, `Shipped`, `Delivered`; `next()`, `previous()`, `getStatus()` switch ile exhaustive. |
| **Factory** | `sealed interface NotificationService` — 3 record: `Email`, `Sms`, `Push`; `createSender(type)` switch ile `BiConsumer<String, String>` döndürüyor. |

---

## Exhaustiveness (Tüketim Kontrolü)

Yeni bir alt tip eklendiğinde (ör. `OrderItem`'a `GiftCardItem` eklendiğinde), bu tipi kullanan tüm `switch` ifadelerinde yeni case eklenmezse **derleyici hata verir**. Böylece “unhandled case” runtime’da değil, derleme aşamasında yakalanır.

**Örnek (projeden):**
```java
static BigDecimal calculateTax(OrderItem item) {
    return switch (item) {
        case BookItem b -> ...
        case ElectronicsItem e -> ...
        case FoodItem f -> ...
        // Yeni record eklense buraya case eklenmezse derleme hatası
    };
}
```

---

## Visitor’ı Neden Büyük Ölçüde Gereksiz Kılar?

Klasik Visitor: her yeni tip için visitor arayüzüne yeni metot eklenir, tüm visitor implementasyonları güncellenir. Sealed + pattern matching switch ile:

- Tüm tipler `permits` ile sabit.
- Her kullanım yeri tek bir `switch` ile tüm varyantları ele alır.
- Yeni varyant eklendiğinde derleyici, switch kullanan her yeri “eksik case” diye işaretler.

Bu yüzden “tip bazlı aksiyon” ihtiyacı çoğu yerde ayrı bir Visitor sınıfı yerine sealed + switch ile karşılanabilir.

---

## Dikkat Edilmesi Gerekenler

- **permits:** Sealed türün izin verdiği alt tipler açıkça listelenmeli (aynı dosyada nested ise liste opsiyonel).
- **Alt tip kısıtı:** Her permitted alt tip `final`, `sealed` veya `non-sealed` olarak bildirilmelidir.
- **Modül / paket:** Permitted sınıflar genelde aynı modülde (veya tanımlara göre erişilebilir) olmalıdır.
- **Reflection:** `getPermittedSubclasses()` ile izin verilen alt sınıflar sorgulanabilir.
