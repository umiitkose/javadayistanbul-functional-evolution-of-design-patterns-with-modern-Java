# Lambda İfadeleri (Lambda Expressions)

## Başlık
Java'da Lambda İfadeleri — Anonim fonksiyonlar ve SAM (Single Abstract Method) kullanımı.

---

## Nedir?
Lambda ifadesi, **anonim bir fonksiyon** tanımlamanın kısa yoludur. Tek bir soyut metoda sahip arayüzleri (SAM) tek satır veya blok halinde implemente etmek için kullanılır. Parametre listesi, ok (`->`) ve gövde ile yazılır.

---

## Hangi Java Versiyonunda Geldi?
**Java 8** (Mart 2014).

---

## Neden Eklendi?
- Anonim inner class yazımını azaltmak ve okunabilirliği artırmak
- Fonksiyonel programlama tarzında kod yazmayı kolaylaştırmak
- Stream API ve diğer fonksiyonel API'lerle uyum sağlamak

---

## Temel Sözdizimi (Syntax)

```java
// Parametre(ler) -> ifade
(amount) -> System.out.println("Ödeme: " + amount)

// Tek parametre: parantez opsiyonel
amount -> System.out.println("Ödeme: " + amount)

// Çok parametre
(a, b) -> a + b

// Blok gövde, return gerekli
(orderClassic, total) -> {
    var discounted = total.multiply(new BigDecimal("0.90"));
    System.out.println("İndirimli: " + discounted);
}
```

---

## Projede Nerelerde Kullanıldı?

| Desen | Dosya / Kullanım |
|-------|-------------------|
| **Strategy** | `PaymentService`: `Consumer<BigDecimal>` olarak ödeme stratejileri (kredi kartı, havale, kripto) |
| **Observer** | `OrderEventManager`: `Consumer<OrderEvent>` olarak event listener'lar |
| **Command** | `OrderCommands`: `Runnable` olarak komutlar (`createOrder`, `cancelOrder`, `refund`) |
| **Decorator** | `OrderEnhancer`: `UnaryOperator<Order>` olarak decorator'lar (hediye paketi, sigorta, hızlı kargo) |
| **Chain of Responsibility** | `OrderValidation`: `Predicate<Order>` olarak validator'lar (stok, tutar, adres) |

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (anonim inner class):**
```java
paymentService.setStrategy(new PaymentStrategy() {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Ödeme: " + amount + " TL");
    }
});
```

**Sonrası (lambda):**
```java
Consumer<BigDecimal> pay = amount -> System.out.println("Ödeme: " + amount);
PaymentService.processPayment(pay, new BigDecimal("100"));
```

---

## Dikkat Edilmesi Gerekenler

- **Closure:** Lambda, dış değişkenlere erişebilir; bu değişkenler **effectively final** olmalı (değiştirilmemeli).
- **Effectively final:** `final` yazmasanız bile, atandıktan sonra değişmeyen değişkenler lambda içinde kullanılabilir.
- **Serialization:** Lambda'lar serileştirilebilir ancak tüm yakalanan (captured) state de serileşir; dikkatli kullanın.
- **SAM uyumu:** Sadece **tek soyut metodu** olan arayüzler lambda ile kullanılabilir (`@FunctionalInterface` ile işaretlenebilir).
