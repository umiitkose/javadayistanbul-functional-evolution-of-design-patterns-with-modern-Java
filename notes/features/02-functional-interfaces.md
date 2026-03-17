# Fonksiyonel Arayüzler (Functional Interfaces)

## Başlık
Java'da `@FunctionalInterface` ve Yerleşik Fonksiyonel Arayüzler — Tasarım desenlerinde kullanım.

---

## Nedir?
**Fonksiyonel arayüz**, tam olarak **tek soyut metodu (SAM)** olan bir arayüzdür. Lambda ifadeleri ve method reference'lar bu arayüzlerin türünde kullanılır. `@FunctionalInterface` annotation'ı bu sözleşmeyi derleyiciye bildirir ve ikinci bir soyut metot eklendiğinde hata verir.

---

## Hangi Java Versiyonunda Geldi?
**Java 8** — `java.util.function` paketi ve `@FunctionalInterface` ile birlikte.

---

## Neden Eklendi?
- Lambda'ların tip güvenli bir şekilde kullanılabilmesi için hedef tür tanımlamak
- Ortak kullanım kalıplarını (tüketici, üretici, dönüştürücü, koşul) standart arayüzlerle ifade etmek
- Kod tekrarını azaltmak ve API'leri sadeleştirmek

---

## Temel Sözdizimi ve Yerleşik Arayüzler

| Arayüz | Metot | Açıklama | Projede Kullanım |
|--------|--------|----------|-------------------|
| `Consumer<T>` | `void accept(T t)` | T alır, void döner | Strategy (ödeme), Observer (event) |
| `Function<T,R>` | `R apply(T t)` | T'yi R'ye dönüştürür | Template Method (toplam hesaplama) |
| `BiConsumer<T,U>` | `void accept(T t, U u)` | İki parametre, void | Template Method (indirim), Factory (gönderici) |
| `UnaryOperator<T>` | `T apply(T t)` | Aynı tipte dönüşüm | Decorator (sipariş zenginleştirme) |
| `Predicate<T>` | `boolean test(T t)` | Koşul, boolean | Chain of Responsibility (validasyon) |
| `Runnable` | `void run()` | Parametresiz void | Command (aksiyonlar) |
| `BiFunction<T,U,R>` | `R apply(T t, U u)` | İki parametre, R döner | Adapter (ödeme uyarlama) |
| `Supplier<T>` | `T get()` | Parametre yok, T üretir | Lazy evaluation |

**Örnek imzalar:**
```java
Consumer<BigDecimal> pay = amount -> { /* ... */ };
Function<Order, BigDecimal> totalCalc = orderClassic -> orderClassic.items().stream()...;
Predicate<Order> hasStock = orderClassic -> orderClassic.stockQuantity() > 0;
UnaryOperator<Order> wrap = orderClassic -> orderClassic.addFeature("Hediye", ...);
BiFunction<String, BigDecimal, Boolean> adapt = (id, amt) -> legacy.process(...);
```

---

## Projede Nerelerde Kullanıldı?

- **Strategy:** `PaymentService` — `Consumer<BigDecimal>` (creditCard, bankTransfer, crypto).
- **Observer:** `OrderEventManager` — `Consumer<OrderEvent>` (subscribe / notify).
- **Command:** `OrderCommands` — `Runnable` (createOrder, cancelOrder, refund).
- **Decorator:** `OrderEnhancer` — `UnaryOperator<Order>` (giftWrap, insurance, expressShipping).
- **Chain of Responsibility:** `OrderValidation` — `Predicate<Order>` (hasStock, hasValidAmount, hasValidAddress); `.and()` ile zincir.
- **Template Method:** `OrderProcessor` record — `Consumer<Order>`, `Function<Order, BigDecimal>`, `BiConsumer<Order, BigDecimal>`.
- **Adapter:** `PaymentAdapter.adapt()` — `BiFunction<String, BigDecimal, Boolean>`.
- **Factory:** `NotificationService.createSender()` — `BiConsumer<String, String>` döner.

---

## Custom vs Yerleşik Karşılaştırma

**Custom (klasik):** Her strateji için ayrı sınıf (CreditCardPayment, BankTransferPayment, …).  
**Yerleşik:** Tek tip `Consumer<BigDecimal>`, implementasyon lambda veya method reference; daha az sınıf, daha okunaklı API.

---

## @FunctionalInterface'ın Önemi

- Arayüzün **tek soyut metoda** sahip kalmasını zorunlu kılar; ikinci soyut metot eklerseniz derleme hatası alırsınız.
- Dokümantasyon niteliğindedir; bu arayüzün lambda ile kullanılmak üzere tasarlandığını belirtir.
- Default ve static metotlar sayılmaz; arayüz hâlâ fonksiyonel kalabilir.

---

## Kısa Özet

| İhtiyaç | Kullanılacak arayüz |
|---------|---------------------|
| Bir değer al, bir şey yap (void) | `Consumer<T>` veya `BiConsumer<T,U>` |
| Bir değeri dönüştür | `Function<T,R>` veya `UnaryOperator<T>` |
| Koşul (evet/hayır) | `Predicate<T>` |
| Parametresiz aksiyon | `Runnable` |
| Parametresiz değer üret | `Supplier<T>` |
| İki değerle dönüşüm | `BiFunction<T,U,R>` |
