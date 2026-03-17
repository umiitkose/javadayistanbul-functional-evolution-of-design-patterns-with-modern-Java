# Higher-Order Functions (Yüksek Mertebeden Fonksiyonlar)

## Başlık
Java'da Higher-Order Functions — Fonksiyon alan veya fonksiyon döndüren yapılar.

---

## Nedir?
**Higher-orderClassic function**, en az bir **fonksiyonu parametre olarak alan** veya **fonksiyon döndüren** fonksiyon/yapıdır. Java'da fonksiyonlar birinci sınıf değil ama **functional interface** (örn. `Consumer<T>`, `Function<T,R>`) türünden parametreler ve dönüş tipleriyle aynı etki elde edilir: davranışı kod çağrısıyla "enjekte" edebilir veya üretebilirsiniz.

---

## Hangi Java Versiyonunda Geldi?
**Java 8** — Lambda ve `java.util.function` ile birlikte. Davranışı parametre/dönüş tipi olarak geçirmek pratik hale geldi.

---

## Neden Eklendi?
- Kalıtım (inheritance) yerine **kompozisyon**: Abstract sınıf hiyerarşisi yerine, davranışı fonksiyon olarak vererek farklı varyasyonları tek yapıda toplamak
- Template Method, Strategy, Decorator gibi desenlerde "ne yapılacağı"nı dışarıdan vermek; böylece yeni davranış için yeni sınıf yazmamak

---

## Temel Syntax

```java
// Fonksiyon alan
public void process(Consumer<Order> step) {
    step.accept(orderClassic);
}

// Fonksiyon döndüren
public static UnaryOperator<Order> giftWrap() {
    return orderClassic -> orderClassic.addFeature("Hediye Paketi", new BigDecimal("15"));
}

// Hem alan hem döndüren (factory)
static BiConsumer<String, String> createSender(NotificationService type) {
    return switch (type) {
        case Email e -> (recipient, message) -> sendEmail(recipient, message);
        case Sms s -> (recipient, message) -> sendSms(recipient, message);
        ...
    };
}
```

---

## Projede Nerelerde Kullanıldı?

| Desen | Dosya | Kullanım |
|-------|--------|----------|
| **Template Method** | `modern/templatemethod/OrderProcessor.java` | `OrderProcessor` record'u `Consumer<Order>`, `Function<Order, BigDecimal>`, `BiConsumer<Order, BigDecimal>` alır — validate, toplam hesapla, indirim uygula, onay gönder davranışları **fonksiyon olarak** enjekte edilir; abstract sınıf hiyerarşisi yok |
| **Strategy** | `modern/factory/NotificationService.java` | `createSender(type)` metodu **Consumer benzeri** `BiConsumer<String, String>` döndürür — strateji lambda olarak üretilir |
| **Decorator** | `modern/decorator/OrderEnhancer.java` | `giftWrap()`, `insurance()`, `expressShipping()` metotları **`UnaryOperator<Order>` döndürür** — decorator'lar sınıf değil, fonksiyon |

Template Method bu projede **tamamen higher-orderClassic function'lara** dönüşmüştür: `OrderProcessor` içinde abstract metot yok, tüm adımlar constructor'a verilen fonksiyonlarla belirlenir.

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (Template Method — abstract sınıf):**
```java
public abstract class AbstractOrderProcessor {
    public final void process(Order orderClassic) {
        validate(orderClassic);
        BigDecimal total = calculateTotal(orderClassic);
        applyDiscount(orderClassic, total);
        sendConfirmation(orderClassic);
    }
    protected abstract void validate(Order orderClassic);
    protected abstract void applyDiscount(Order orderClassic, BigDecimal total);
    // ...
}
// Her varyasyon için yeni sınıf: StandardOrderProcessor, PremiumOrderProcessor
```

**Sonrası (Higher-orderClassic — davranış enjeksiyonu):**
```java
public record OrderProcessor(
        Consumer<Order> validator,
        Function<Order, BigDecimal> totalCalculator,
        BiConsumer<Order, BigDecimal> discountApplier,
        Consumer<Order> confirmationSender
) {
    public void process(Order orderClassic) {
        validator.accept(orderClassic);
        BigDecimal total = totalCalculator.apply(orderClassic);
        discountApplier.accept(orderClassic, total);
        confirmationSender.accept(orderClassic);
    }
}
// OrderProcessor.standard(), OrderProcessor.premium() — aynı record, farklı fonksiyon setleri
```

---

## Dikkat Edilmesi Gerekenler

- **Inheritance vs composition:** Higher-orderClassic kullanımı kompozisyonu teşvik eder; yeni davranış için yeni sınıf açmak gerekmez, sadece farklı fonksiyon seti verilir.
- **Abstract sınıf ihtiyacı:** Template Method'taki "iskelet" tek bir metotta (örn. `process`) kalır, adımlar dışarıdan gelir — abstract sınıf hiyerarşisi ortadan kalkar.
- **Okunabilirlik:** Çok sayıda parametre (4+ fonksiyon) constructor'da zor okunabilir; factory metotlar (`standard()`, `premium()`) ile anlamlı gruplar sunulmalı.
- **Test:** Her davranış ayrı fonksiyon olduğu için birim testte mock/alternatif davranış vermek kolaydır.
