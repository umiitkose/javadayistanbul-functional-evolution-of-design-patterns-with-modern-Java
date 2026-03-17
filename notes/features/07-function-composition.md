# Fonksiyon Kompozisyonu (Function Composition)

## Başlık
Java'da Fonksiyon Kompozisyonu — andThen, compose, Predicate/Consumer zincirleme.

---

## Nedir?
**Fonksiyon kompozisyonu**, iki veya daha fazla fonksiyonu tek bir fonksiyon gibi **zincirleyerek** kullanmaktır. Önce bir fonksiyonun çıktısı, sonra diğerinin girdisi olur. Java'da `Function.andThen()`, `Function.compose()`, `Predicate.and()/or()/negate()`, `Consumer.andThen()` ile yapılır.

---

## Hangi Java Versiyonunda Geldi?
**Java 8** — `java.util.function` paketi ile birlikte (Function, UnaryOperator, Predicate, Consumer).

---

## Neden Eklendi?
- Davranışları küçük, tek sorumluluklu fonksiyonlara bölüp sonra birleştirmek
- Decorator, Chain of Responsibility gibi desenlerde sınıf hiyerarşisi yerine **tek satırda pipeline** kurmak
- Kod tekrarını azaltmak ve test edilebilir parçalar oluşturmak

---

## Temel Syntax

```java
// Function: f.andThen(g) => önce f, sonra g
Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.andThen(g);  // (x+1)*2

// UnaryOperator zincirleme
UnaryOperator<Order> pipeline = giftWrap().andThen(insurance()).andThen(expressShipping());

// Predicate: and(), or(), negate()
Predicate<Order> valid = hasStock.and(hasValidAmount).and(hasValidAddress);

// Consumer: andThen()
Consumer<String> log = s -> System.out.println(s);
Consumer<String> upper = log.andThen(s -> System.out.println(s.toUpperCase()));
```

---

## Projede Nerelerde Kullanıldı?

| Desen | Dosya | Kullanım |
|-------|--------|----------|
| **Decorator** | `DecoratorDemo.java`, `OrderEnhancer.java` | `giftWrap().andThen(insurance()).andThen(expressShipping())` — Üç decorator'ü tek satırda birleştirme; `enhance.apply(orderClassic)` ile siparişe sırayla hediye paketi, sigorta, hızlı kargo uygulanır |
| **Chain of Responsibility** | `OrderValidation.java` | `hasStock.and(hasValidAmount).and(hasValidAddress)` — Üç validator'ü tek Predicate'te birleştirme; `allValidations().test(orderClassic)` ile tüm kontroller sırayla çalışır |

Decorator pattern bu projede **tamamen fonksiyon kompozisyonuna** dönüşmüştür: ayrı wrapper sınıfları yok, sadece `UnaryOperator<Order>` döndüren metotlar ve `andThen` ile zincir.

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (Klasik Decorator — iç içe wrapper sınıfları):**
```java
OrderService service = new ExpressShippingDecorator(
    new InsuranceDecorator(
        new GiftWrapDecorator(new BasicOrderService())
    )
);
var result = service.process(orderClassic);
```

**Sonrası (Fonksiyon kompozisyonu):**
```java
var enhance = OrderEnhancer.giftWrap()
        .andThen(OrderEnhancer.insurance())
        .andThen(OrderEnhancer.expressShipping());
var result = enhance.apply(orderClassic);
```

---

## Dikkat Edilmesi Gerekenler

- **andThen vs compose:** `f.andThen(g)` = önce `f`, sonra `g` (ok soldan sağa). `f.compose(g)` = önce `g`, sonra `f` (girdi önce g'den geçer). Pipeline okunu düşünürken `andThen` daha sezgisel.
- **Sıralama:** Decorator'da ilk yazılan (örn. giftWrap) ilk uygulanır; Chain of Responsibility'de predicate'ler sırayla test edilir.
- **Pipeline oluşturma:** Birden fazla `UnaryOperator<T>` veya `Function<T,T>` tek bir değişkende toplanıp tek çağrıyla uygulanabilir — kod kısalır, yeni "decorator" eklemek tek satır olur.
- **Boş pipeline:** Hiç fonksiyon eklemeden `UnaryOperator.identity()` ile başlayıp `andThen(...)` ile genişletilebilir.
