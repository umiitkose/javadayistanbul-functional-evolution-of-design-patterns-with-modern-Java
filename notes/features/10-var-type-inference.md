# var — Yerel Değişken Tip Çıkarımı (Local Variable Type Inference)

## Başlık
Java'da var (JEP 286) — Sadece yerel değişkenlerde tip çıkarımı.

---

## Nedir?
**var**, derleyicinin **yerel değişken** için tipi sağdaki ifadeden (initializer) **çıkarmasını** sağlayan bir anahtar sözcüktür. Değişken hâlâ statik tiptedir; sadece tipi yazmayı kısaltır. Method parametreleri, alanlar (field) veya dönüş tipi için **kullanılamaz**.

---

## Hangi Java Versiyonunda Geldi?
**Java 10** (JEP 286 — Local-Variable Type Inference). Lambda parametrelerinde `var` (annotation ile birlikte) **Java 11**'de kullanılabilir hale geldi.

---

## Neden Eklendi?
- Uzun generic tipleri tekrarlamamak: `Map<String, List<Order>> map = ...` yerine `var map = ...`
- Sağ taraftaki ifade tipi net olduğunda okunabilirliği artırmak
- Diamond operator (`<>`) ile benzer bir rahatlık; tip bilgisi tek yerde (sağda) kalır

---

## Temel Syntax

```java
// Yerel değişken — kullanılabilir
var orderClassic = new Order("ORD-001", new BigDecimal("200"));
var result = service.process(orderClassic);
var list = new ArrayList<String>();

// Method parametresi / field / return — KULLANILAMAZ
// void process(var orderClassic) { }           // HATA
// private var id;                       // HATA
// public var getOrder() { return o; }  // HATA

// Lambda'da var (Java 11+), örn. annotation için
BiConsumer<String, String> c = (@NonNull var a, var b) -> {};
```

---

## Projede Nerelerde Kullanıldı?

| Yer | Kullanım |
|-----|----------|
| **Tüm demo sınıfları** | `var orderClassic = new Order(...)`, `var result = ...`, `var total = items.stream()...` — tip tekrarı yok, kod kısa |
| **DecoratorDemo** | `var enhance = OrderEnhancer.giftWrap().andThen(...)`; `var orderClassic = new ... Order(...)`; `var result = enhance.apply(orderClassic)` |
| **VisitorDemo, ChainOfResponsibilityDemo, StateDemo, FactoryDemo, vb.** | Gereksiz uzun tip bildirimleri yerine `var` ile okunabilir yerel değişkenler |

Örnek: `var total = items.stream().map(OrderItem::calculateTax).reduce(BigDecimal.ZERO, BigDecimal::add)` — generic tipi yazmadan aynı netlik.

---

## Öncesi / Sonrası Kod Örneği

**Öncesi (Açık tip):**
```java
Order orderClassic = new Order("ORD-001", new BigDecimal("200"));
Order result = enhance.apply(orderClassic);
BigDecimal total = items.stream().map(OrderItem::calculateTax).reduce(BigDecimal.ZERO, BigDecimal::add);
```

**Sonrası (var):**
```java
var orderClassic = new Order("ORD-001", new BigDecimal("200"));
var result = enhance.apply(orderClassic);
var total = items.stream().map(OrderItem::calculateTax).reduce(BigDecimal.ZERO, BigDecimal::add);
```

**Diamond ile benzerlik:** `ArrayList<String> list = new ArrayList<>()` — sağda tip çıkarılır; `var list = new ArrayList<String>()` — solda çıkarılır.

---

## Dikkat Edilmesi Gerekenler

- **Ne zaman kullanmalı:** Tip sağdaki ifadeden **açıkça anlaşıldığında** (constructor, factory, bilinen dönüş tipi). Okunabilirliği artırıyorsa tercih edilebilir.
- **Ne zaman kullanmamalı:** Tip belirsizse (`var x = getSomething()` — dönüş tipi net değilse), veya isim yetersizse (`var data = ...` — ne tür data?) `var` okunabilirliği azaltabilir.
- **Ekip politikası:** Bazı ekipler `var` kullanımını kısıtlar (sadece diamond/stream gibi yerlerde); bazıları tutarlı kullanımı teşvik eder. Sunumda "ekip içi tartışma" olarak belirtmek faydalı.
- **var bir tip değildir:** `var` sadece "derleyici burada tipi çıkarsın" anlamına gelir; `var` türünde alan veya generic yazılamaz.
