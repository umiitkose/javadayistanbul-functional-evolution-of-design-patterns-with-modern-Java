# OOP vs Fonksiyonel Programlama: Modern Java'da Design Patterns Karşılaştırması

**JavaDay Istanbul — "Modern Java ile Design Patterns'in Fonksiyonel Evrimi"**  
Bu belge sunum için referans dokümandır.

**İçindekiler:** 1) OOP ve FP felsefe farkları, 2) Pattern bazında karşılaştırma matrisi, 3) Karar rehberi, 4) Avantaj/dezavantaj tabloları, 5) Performans notları, 6) Okunabilirlik–kısalık dengesi, 7) Ekip ve kod inceleme, 8) Legacy modernizasyon stratejileri, 9) Best practices, 10) Sonuç.

**Hedef kitle:** Java geliştiricileri, tasarım kalıplarına aşina ekipler, modern Java (8+) özelliklerini projede daha bilinçli kullanmak isteyenler. Belge yaklaşık 300+ satır olacak şekilde detaylandırılmıştır.

---

## 1. OOP ve FP: Temel Felsefe Farkları

### OOP (Nesne Yönelimli Programlama)

- **Durum (state) + davranış (behavior) birlikteliği:** Nesneler hem veriyi hem o veri üzerindeki işlemleri taşır. Örneğin `PaymentService` bir `PaymentStrategy` tutar ve `pay()` çağrısıyla davranışı değiştirir.
- **Kapsülleme:** İç detaylar gizlenir; dışarıya arayüz (interface) sunulur.
- **Kalıtım ve polimorfizm:** Ortak davranış abstract/interface ile tanımlanır; farklı implementasyonlar (örn. `CreditCardPayment`, `BankTransferPayment`) birbirinin yerine kullanılabilir.

### FP (Fonksiyonel Programlama)

- **Saf fonksiyonlar:** Aynı girdi her zaman aynı çıktıyı üretir; dış dünya ile etkileşim minimize edilir.
- **Değişmezlik (immutability):** Veri değiştirilmez; yeni değerler üretilir (örn. `Order.addFeature()` yeni `Order` döner).
- **Fonksiyon kompozisyonu:** Küçük fonksiyonlar birleştirilerek büyük davranış oluşturulur (`UnaryOperator.andThen()`, `Predicate.and()`).
- **Yan etki yok:** İşlemler yan etki üretmeyecek şekilde tasarlanabilir (test ve anlama kolaylığı).

### Java'nın Hibrit Yaklaşımı

- Java **OOP temelli** bir dildir; Java 8 ile **lambda, Stream, fonksiyonel arayüzler** eklendi.
- **Record**, **sealed**, **pattern matching** (Java 17+) ile veri odaklı ve cebirsel tipler destekleniyor.
- Sonuç: **Paradigma savaşı değil, en uygun aracı seçmek** önemli. Domain model OOP, davranış/strateji FP ile ifade edilebilir.

**Projeden örnek (Strategy):** Klasik OOP’te `PaymentStrategy` arayüzü ve üç ayrı sınıf; modern FP’de tek sınıf ve `Consumer<BigDecimal>`:

```java
// Klasik: interface + 3 sınıf
public interface PaymentStrategy { void pay(BigDecimal amount); }
// CreditCardPayment, BankTransferPayment, CryptoPayment ayrı sınıflar

// Modern: tek sınıf, statik factory
PaymentService.processPayment(
    PaymentService.creditCard("4111-1111", "Ali"),
    new BigDecimal("100")
);
```

**Not:** Bu projede klasik ve modern implementasyonlar yan yana durduğu için karşılaştırma ve sunum için idealdir; üretim kodunda tek bir yaklaşım seçilmesi önerilir.

---


## 2. Pattern Bazında Karşılaştırma Matrisi

Projedeki 11 pattern için özet tablo. Klasik örnekler `classic.*` paketlerinde, modern örnekler `modern.*` paketlerindedir (örn. `classic.strategy`, `modern.strategy`).

| # | Pattern | Klasik OOP Yaklaşımı | Modern FP Yaklaşımı | Dosya | Satır | Önerilen Yaklaşım ve Neden |
|---|---------|----------------------|----------------------|-------|--------|----------------------------|
| 1 | **Strategy** | `PaymentStrategy` arayüzü + `CreditCardPayment`, `BankTransferPayment`, `CryptoPayment` sınıfları; `PaymentService` strateji tutar ve `pay()` çağırır | `Consumer<BigDecimal>` ile ödeme davranışı; `PaymentService.processPayment(strategy, amount)` — tek sınıf, statik factory metodları | 5 → 1 | ~110 → 33 | **FP.** Strateji sadece “bir şey yap” ise lambda/Consumer yeterli; yeni ödeme türü için sınıf açmaya gerek yok. |
| 2 | **Builder** | POJO `Order` (getter/setter) + `OrderBuilder` (akıcı API, `build()` ile validasyon) | `record Order(...)` + compact constructor (validasyon) + `with*` ile kopyalama; builder sınıfı yok | 2 → 1 | ~181 → 36 | **FP (record).** Daha az boilerplate, değişmez veri, derleme zamanı garantileri. |
| 3 | **Template Method** | `AbstractOrderProcessor` (final `process()` + abstract `validateOrder`, `calculateTotal`, vb.) + `StandardOrderProcessor`, `PremiumOrderProcessor` alt sınıfları | `OrderProcessor` record: `Consumer`, `Function`, `BiConsumer` alanları; `standard()` ve `premium()` factory’ler farklı lambda setleri verir | 4 → 2 | ~85 → 66 | **FP.** Kalıtım yerine “algoritma parçalarını enjekte et”; daha esnek ve test edilebilir. |
| 4 | **Decorator** | `OrderService` arayüzü, `BasicOrderService`, `GiftWrapDecorator`, `InsuranceDecorator`, `ExpressShippingDecorator` (wrapper zinciri) | `UnaryOperator<Order>`; `OrderEnhancer.giftWrap().andThen(insurance()).andThen(expressShipping())` | 6 → 2 | ~91 → 50 | **FP.** Yeni “dekor” = yeni metod, yeni sınıf değil; zincirleme okunaklı. |
| 5 | **Visitor** | `OrderItem` arayüzü, `BookItem`, `ElectronicsItem`, `FoodItem` + `OrderItemVisitor` + `TaxCalculatorVisitor`, `DiscountVisitor` (çift dağıtım) | `sealed interface OrderItem` + `record` varyantları + `switch` ile `calculateTax` / `calculateDiscount` | 8 → 1 | ~197 → 59 | **FP (sealed + pattern matching).** Yeni işlem = yeni metod; yeni tip = sealed’a yeni record. Daha az sınıf, tek dosyada tip + davranış. |
| 6 | **Observer** | `OrderEventListener` arayüzü, `EmailNotificationListener`, `SmsNotificationListener`, `OrderEvent`; `OrderEventManager` liste tutar | `Consumer<OrderEvent>`; manager aynı, listener’lar lambda veya method reference | 5 → 1 | ~75 → 26 | **FP.** Dinleyici “bir event alıp bir şey yap” ise Consumer yeterli; sınıf sayısı dramatik azalır. |
| 7 | **Factory Method** | `NotificationType` enum + `NotificationFactory` + `NotificationService` arayüzü + `EmailNotificationService`, `SmsNotificationService`, `PushNotificationService` | `sealed interface NotificationService` (Email, Sms, Push record’ları) + `createSender(type)` switch ile `BiConsumer<String,String>` döner | 6 → 1 | ~52 → 21 | **FP.** Tip güvenli; yeni kanal = sealed’a yeni record + switch’e dal. |
| 8 | **State** | `OrderState` arayüzü, `PendingState`, `ProcessingState`, `ShippedState`, `DeliveredState`, `OrderContext` (durum tutar, geçiş yapar) | `sealed interface OrderState` + record’lar + `next()` / `previous()` / `getStatus()` switch ile | 6 → 1 | ~109 → 60 | **FP.** Durum geçişi tek yerde (switch); yeni durum = yeni record. |
| 9 | **Chain of Responsibility** | `OrderValidationHandler` arayüzü, `StockValidationHandler`, `PaymentValidationHandler`, `AddressValidationHandler`, zincir manuel kurulur | `Predicate<Order>` (hasStock, hasValidAmount, hasValidAddress) + `allValidations()` = `hasStock.and(hasValidAmount).and(hasValidAddress)` | 5 → 1 | ~68 → 37 | **FP.** Zincir = predicate kompozisyonu; sıra ve birleştirme net. |
| 10 | **Command** | `OrderCommand` arayüzü, `CreateOrderCommand`, `CancelOrderCommand`, `RefundCommand`, `OrderCommandInvoker` | `Runnable` (veya özel fonksiyonel arayüz); `OrderCommands.createOrder(...)`, `cancelOrder(...)`, `refund(...)` lambda döner; invoker `execute(Runnable)` | 5 → 1 | ~76 → 31 | **FP.** Komut “parametreleri kapatıp iş yap” ise lambda ideal; sınıf sayısı azalır. |
| 11 | **Adapter** | `ModernPaymentGateway` arayüzü, `LegacyPaymentSystem`, `PaymentAdapter` sınıfı (wrapper) | `BiFunction<String, BigDecimal, Boolean> adapt(LegacyPaymentSystem)` — lambda ile arayüz dönüşümü | 3 → 1 | ~36 → 23 | **FP.** Adaptasyon tek bir fonksiyon ise BiFunction yeterli; ek sınıf gerekmez. |

**Özet:** Neredeyse tüm örneklerde dosya ve satır sayısı ciddi azalıyor; önerilen yaklaşım çoğunlukla modern Java (record, sealed, lambda, fonksiyonel arayüzler) ile FP tarafı.

**Projeden kod örnekleri:**

- **Decorator (modern):** `OrderEnhancer.giftWrap().andThen(OrderEnhancer.insurance()).andThen(OrderEnhancer.expressShipping())` — tek ifade, sınıf yok.
- **Visitor (modern):** `OrderItem.java` içinde `sealed interface OrderItem` + `BookItem`, `ElectronicsItem`, `FoodItem` record’ları + `calculateTax(OrderItem item)` switch ile; klasikte 8 ayrı dosya.
- **Chain of Responsibility (modern):** `OrderValidation.allValidations()` = `hasStock.and(hasValidAmount).and(hasValidAddress)` — predicate kompozisyonu.

**İnceleme için dosya çiftleri (klasik | modern):**

| Pattern | Klasik | Modern |
|---------|--------|--------|
| Strategy | `classic/strategy/PaymentStrategy.java`, `PaymentService.java`, `*Payment.java` | `modern/strategy/PaymentService.java` |
| Builder | `classic/builder/Order.java`, `OrderBuilder.java` | `modern/builder/Order.java` |
| Template Method | `classic/templatemethod/AbstractOrderProcessor.java`, `*OrderProcessor.java` | `modern/templatemethod/OrderProcessor.java` |
| Decorator | `classic/decorator/OrderService.java`, `*Decorator.java`, `BasicOrderService.java` | `modern/decorator/OrderEnhancer.java`, `Order.java` |
| Visitor | `classic/visitor/OrderItem.java`, `*Item.java`, `*Visitor.java` | `modern/visitor/OrderItem.java` |
| Observer | `classic/observer/OrderEventManager.java`, `OrderEventListener.java`, `*Listener.java` | `modern/observer/OrderEventManager.java` |
| Factory | `classic/factory/NotificationFactory.java`, `NotificationType.java`, `*NotificationService.java` | `modern/factory/NotificationService.java` |
| State | `classic/state/OrderState.java`, `*State.java`, `OrderContext.java` | `modern/state/OrderState.java` |
| Chain | `classic/chainofresponsibility/*Handler.java`, `Order.java` | `modern/chainofresponsibility/OrderValidation.java` |
| Command | `classic/command/OrderCommand.java`, `*Command.java`, `OrderCommandInvoker.java` | `modern/command/OrderCommands.java` |
| Adapter | `classic/adapter/PaymentAdapter.java`, `ModernPaymentGateway.java`, `LegacyPaymentSystem.java` | `modern/adapter/PaymentAdapter.java` |

---

## 3. Ne Zaman OOP, Ne Zaman FP? Karar Rehberi

Aşağıdaki kriterlere göre karar matrisi ve kısa rehber:

| Kriter | OOP Tercih | FP Tercih |
|--------|------------|-----------|
| **Karmaşıklık** | Çok karmaşık domain, çok sayıda ilişki ve davranış | Orta/basit davranış, veri dönüşümü, pipeline |
| **Durum yönetimi** | Gerçekten değişen durum, lifecycle, context | Durum az veya immutable snapshot’lar (record) |
| **Ekip deneyimi** | Ekip OOP ve tasarım kalıplarına alışkın | Ekip lambda/Stream/record kullanabiliyor |
| **Proje ömrü** | Uzun ömürlü, sık genişletme, çok yerden kullanılacak abstraction | Hızlı değişen, modüler, davranış odaklı parçalar |
| **Performans** | Ağır nesne grafikleri, özel allocation kontrolü | Çoğu iş mantığı; JVM lambda/record optimizasyonları yeterli |
| **Test** | Mock’lanacak bağımlılıklar, büyük nesneler | Saf fonksiyonlar, küçük birimler; test kolay |
| **Genişletilebilirlik** | Yeni alt tip (yeni sınıf) eklenmesi sık | Yeni davranış (yeni fonksiyon/switch dalı) veya yeni sealed alt tip |
| **Okunabilirlik** | İsimlendirilmiş sınıflar ve roller net | Kısa pipeline, az boilerplate; aşırı zincir karmaşıklaştırmamak |

**Karar ağacı (özet):**

1. Davranış “tek bir fonksiyon” gibi mi (tek giriş, tek çıkış veya yan etki)? → **FP (lambda/fonksiyonel arayüz).**
2. Veri taşıma / DTO / değişmez aggregate mi? → **Record (FP tarafı).**
3. Sabit sayıda varyant + tüm kullanım yerlerini derleme zamanında bilmek mi? → **Sealed + pattern matching.**
4. Karmaşık nesne yaşam döngüsü, çok ilişki, sık yeni “tür” ekleme mi? → **OOP (sınıflar, arayüzler).**
5. Hem domain model hem davranış var mı? → **Hibrit: model OOP, strateji/komut/observer FP.**

**Checklist (kısa):**

- [ ] Strateji/komut sadece “bir şey yap” mı? → Lambda/Consumer/Runnable.
- [ ] Nesne sadece veri taşıyor mu, değişmiyor mu? → Record.
- [ ] Sonlu sayıda alt tip ve hepsini bilmek istiyor muyuz? → Sealed + switch.
- [ ] Zincirleme doğrulama/filtre mi? → Predicate/UnaryOperator kompozisyonu.
- [ ] Karmaşık lifecycle, çok bağımlılık mı? → OOP sınıfları.

**Örnek senaryo:** “Ödeme sonrası e-posta ve SMS gönderilecek, log yazılacak.” OOP: bir `OrderEventListener` arayüzü ve iki ayrı listener sınıfı + bir logger sınıfı. FP: `OrderEventManager` aynı kalır, subscribe tarafında üç lambda veya method reference (`this::sendEmail`, `this::sendSms`, `logger::info`). Yeni bir kanal eklemek OOP’te yeni sınıf, FP’te yeni lambda/abonelik.

---

## 4. Avantaj ve Dezavantaj Tabloları

Aşağıdaki tablolar sunumda “OOP vs FP tartışması” bölümünde kullanılabilir; her iki tarafın da güçlü ve zayıf yönleri olduğu vurgulanmalı.

### OOP

| Avantajlar | Dezavantajlar |
|------------|----------------|
| Tanıdık model (sınıf, kalıtım, polimorfizm) | Çok sınıf ve arayüz → boilerplate |
| IDE ve araçlarla güçlü destek | Küçük davranış için bile sınıf açma ihtiyacı |
| Kapsülleme ile sorumluluk sınırları net | Test için mock/alt sınıf gerekebilir |
| Genişletme: yeni alt sınıf eklemek doğal | Kalıtım hiyerarşisi zamanla şişebilir |
| Nesne grafiği ve lifecycle açık | Durum yan etkileri takibi zorlaşabilir |

### FP (Modern Java bağlamında)

| Avantajlar | Dezavantajlar |
|------------|----------------|
| Az kod (lambda, record, sealed) | Derin lambda zincirleri okunabilirliği düşürebilir |
| Değişmezlik → daha az hata, daha iyi test | Ekip lambda/Stream’e alışkın değilse öğrenme eğrisi |
| Fonksiyon kompozisyonu (andThen, and, or) | Stack trace’lerde anonim sınıf isimleri |
| JVM (invokedynamic, inlining) ile iyi optimize | Çok büyük immutable yapılar kopyalama maliyeti (nadir) |
| Sealed + switch ile eksiksiz davranış garantisi | Eski Java sürümlerinde sealed/pattern matching yok |

**Hangi fonksiyonel arayüz ne zaman (özet):**

| Arayüz | Kullanım | Proje örneği |
|--------|----------|--------------|
| `Consumer<T>` | T alır, döner yok, yan etki | Strategy (ödeme), Observer (listener) |
| `Supplier<T>` | Parametre yok, T döner | Lazy değer, factory |
| `Function<T,R>` | T → R | Dönüşüm, Template Method (totalCalculator) |
| `UnaryOperator<T>` | T → T | Decorator (Order → Order) |
| `Predicate<T>` | T → boolean | Chain of Responsibility (validasyon) |
| `Runnable` | Parametre yok, void | Command |
| `BiFunction<T,U,R>` | (T,U) → R | Adapter (orderId, amount → Boolean) |

---

## 5. Performans Notları

Sunumda “FP daha yavaş mı?” sorusuna kısa ve net yanıt için kullanılabilir.

- **Lambda vs anonymous class:** JVM `invokedynamic` kullanır; runtime’da tek implementation sınıfı paylaşılır. Anonymous class ise her kullanımda yeni sınıf. Lambda genelde daha az baskı yapar.
- **Record vs POJO:** Bellek layout benzer; ek alan yok. Equals/hashCode/toString derleme zamanında üretilir; reflection azalır.
- **Sealed + pattern matching:** Switch’te tüm dallar bilindiği için JVM optimizasyonu (inlining, branch prediction) iyileşir.
- **Fonksiyon kompozisyonu:** `andThen`/`and` ek çağrı katmanı ekler ama pratikte ihmal edilebilir; JIT inline eder.
- **Stream vs for:** Küçük koleksiyonlarda for döngüsü genelde daha az overhead; büyük veride Stream ve özellikle `parallelStream()` avantajlı olabilir.
- **GC:** Çok sayıda kısa ömürlü immutable nesne (record, lambda capture) GC’yi artırır; modern JVM (özellikle G1/ZGC) kısa ömürlü objeleri iyi yönetir.

**Pratik öneri:** Mikro-benchmark yerine gerçek senaryoda ölçüm yapın; çoğu uygulamada lambda/record maliyeti ihmal edilebilir.

---

## 6. Okunabilirlik vs Kısalık Dengesi

“Daha az kod” sunumda sık vurgulanıyor; ancak okunabilirlik de korunmalı. Aşağıdaki noktalar ekip standartları oluştururken referans alınabilir.

- **Daha az kod her zaman daha iyi mi?** Hayır. Okunabilirlik ve niyet öncelikli; gereksiz uzunluk da gereksiz kısalık da zararlı.
- **Lambda içinde lambda:** İç içe çok fazla lambda okunabilirliği düşürür. Anlamlı isimli private metod veya ayrı değişkene çıkarmak iyidir.
- **Method reference vs lambda:** `BigDecimal::add` gibi tek ifade için method reference; birden fazla ifade veya parametre kullanımı için lambda daha anlaşılır olabilir.
- **Fonksiyonel zincirleme:** `andThen`/`and` 3–4 adımda genelde okunaklı; daha uzun zincirlerde ara sonuçları isimlendirmek veya parçalara bölmek faydalı.
- **Ekip standartları:** Lambda satır sınırı (örn. 3–5 satır), method reference kullanım kuralları, “karmaşık mantık sınıfa/private metoda taşınsın” gibi kurallar konulabilir.

**Projeden örnek:** `OrderProcessor.premium()` içinde discount uygulayan kısım 3–4 satırlık lambda; daha uzun olsaydı `applyPremiumDiscount(Order orderClassic, BigDecimal total)` gibi bir private metoda taşımak okunabilirliği artırırdı.

---

## 7. Ekip İçi Kod İnceleme Etkileri

Modern Java’ya geçiş sadece teknik değil, ekip dinamiğini de etkiler. Yeni gelenler ve FP’ye alışkın olmayan ekip üyeleri için adım adım yaklaşım önerilir.

- **Yeni gelenler:** FP tarafı (lambda, Stream, record, sealed) kısa bir eğitim ve örneklerle hızla öğrenilebilir; proje içi “modern pattern” örnekleri referans olmalı.
- **FP bilmeyen ekip:** Önce Strategy, Command, Observer gibi basit örneklerle “sınıf yerine lambda” gösterilmeli; sonra record ve sealed’a geçilebilir. Zorlayıcı olmadan, adım adım.
- **Kod inceleme checklist:** (1) Aynı davranış 1–2 satırda lambda ile yazılabiliyorsa gereksiz sınıf var mı? (2) Veri taşıma sınıfları record olabilir mi? (3) Sabit varyantlar sealed + switch ile mi? (4) Lambda zinciri okunaklı mı?
- **Pair programming:** Legacy OOP pattern’den modern FP’ye refactor ederken birlikte yapmak, “neden böyle değiştirdik?” sohbetini doğal kılar.

**Kod inceleme soruları (örnek):** “Bu listener için ayrı sınıf gerekli mi, `Consumer<OrderEvent>` yeterli mi?” “Bu DTO record yapılabilir mi?” “Bu switch tüm sealed alt tipleri kapsıyor mu?”

---

## 8. Legacy Kodu Modernize Etme Stratejileri

Mevcut OOP tabanlı kodu modern Java ile yeniden yazarken “büyük patlama” yerine kademeli geçiş ve net öncelik sırası önemlidir.

- **Büyük patlama yapmayın.** Modül/modül veya pattern/pattern geçiş yapın; her adımda testler yeşil kalsın.
- **Öncelik sırası (kolay → zor):**

| Sıra | Pattern | Neden bu sıra | Risk |
|------|---------|----------------|------|
| 1 | Strategy | Tek metod → doğrudan lambda/Consumer | Düşük |
| 2 | Command | Tek aksiyon → Runnable/lambda | Düşük |
| 3 | Observer | Listener = Consumer | Düşük |
| 4 | Builder | POJO → record + compact constructor | Orta (API kırılabilir) |
| 5 | Chain of Responsibility | Handler → Predicate.and() | Düşük |
| 6 | Decorator | Wrapper → UnaryOperator.andThen | Orta |
| 7 | Template Method | Abstract sınıf → higher-orderClassic fonksiyon | Orta |
| 8 | Factory | Enum + sınıflar → sealed + switch | Orta |
| 9 | State | State sınıfları → sealed + switch | Orta |
| 10 | Visitor | Çift dağıtım → sealed + pattern matching | Yüksek (çok kullanım yeri) |
| 11 | Adapter | Wrapper sınıf → BiFunction/lambda | Düşük |

- **Geri dönüş:** Her pattern için eski sınıfları silmeden önce feature flag veya yeni API’yi kullanan tek bir giriş noktası ile geçiş yapın; sorun olursa eski çağrıya dönülebilsin.
- **Test:** Refactor öncesi ve sonrası unit/integration testler aynı senaryoları kapsasın; kapsam düşmesin.

**Geri dönüş stratejisi:** Yeni API’yi facade ile sunun; eski sınıflar bir süre deprecated olarak kalsın. Örnek: `OrderEventManager.subscribe(eventType, (Consumer<OrderEvent>) listener)` hem eski `OrderEventListener` adapte edilebilir hem yeni `Consumer` kullanılabilir (adaptör lambda ile). Sorun çıkarsa facade’ı eski implementasyona yönlendirin.

**Risk seviyesi özeti:** Strategy, Command, Observer, Adapter, Chain of Responsibility → düşük. Builder (API kırılır), Decorator, Template Method, Factory, State → orta. Visitor (birçok yerde değişir) → yüksek.

**Test kapsamı:** Her pattern için demo sınıfları (`*Demo.java`) hem klasik hem modern akışı çalıştırır. Refactor sonrası aynı çıktıyı (log/side-effect) test eden basit testler yazılabilir; böylece davranış değişmediği doğrulanır.

---

## 9. Gerçek Dünya Önerileri ve Best Practices

Bu bölüm, sunum sonrası “Peki projede nasıl uygulayalım?” sorusuna yanıt vermek için kullanılabilir.

- **Hibrit kullanın:** Domain model (varlıklar, ilişkiler, lifecycle) OOP; davranış (ödeme, bildirim, validasyon) FP (lambda, sealed, record).
- **Veri taşıma:** DTO, event, sonuç nesneleri için **record** kullanın; getter/setter/equals/hashCode tekrarlamayın.
- **Tip güvenliği:** Sabit varyantlar için **sealed**; tüm kullanımlar **pattern matching** ile kapalı kalsın.
- **Anti-pattern’ler:** Her şeyi tek lambda’da toplamak; gereksiz abstraction (tek kullanım için arayüz); aşırı fonksiyonel zincir (okunamaz). Ayrıca: her yerde stream kullanmak (basit for bazen daha okunaklı); null yerine Optional’ı her yerde taşımak (sadece API sınırlarında anlamlı).

- **Proje büyüklüğü:** Küçük/orta projede FP ağırlığı artırılabilir; çok büyük monolitte domain katmanı OOP, uygulama/strateji katmanı FP tutulabilir.
- **Bağımlılık:** Dış kütüphaneler OOP arayüz bekliyorsa (örn. Spring listener arayüzleri), adapter lambda ile `listener::onEvent` şeklinde bağlanabilir; tüm kodu FP’ye çevirmek zorunlu değil.

**Proje örneği (bu repo):** Klasik Strategy için 5 sınıf, modern için tek `PaymentService` ve `Consumer<BigDecimal>`; Decorator’da 6 sınıf yerine `OrderEnhancer` + `UnaryOperator` zinciri. Bu tür somut örnekler sunumda vurgulanabilir.

**Record örneği (Builder):** Klasik `Order` POJO + `OrderBuilder` toplam ~181 satır; modern `record Order(...)` + compact constructor + `with*` ~36 satır. Validasyon compact constructor içinde:

```java
public Order {
    Objects.requireNonNull(id, "Order ID zorunludur");
    if (items.isEmpty()) throw new IllegalArgumentException("...");
    items = List.copyOf(items);
}
```

**Sealed + switch örneği (State):** `OrderState` sealed interface, `Pending`, `Processing`, `Shipped`, `Delivered` record’ları; geçiş mantığı tek `next()`/`previous()` switch’inde. Klasikte 6 ayrı sınıf ve context sınıfı.

---

## 10. Sonuç ve Özet

Sunumun kapanış mesajları aşağıda özetlenmiştir; “Design pattern’ler öldü mü?” sorusuna net cevap: Hayır, ama uygulama biçimleri değişti.

- **Design pattern’ler hâlâ geçerli ve değerli;** problemler (strateji seçme, davranışı değiştirme, zincirleme, durum yönetimi vb.) aynı. Değişen şey, **uygulama biçimi**: sınıf ve arayüz sayısı azalıyor, davranış fonksiyon ve veri yapılarıyla ifade ediliyor.
- **Kod miktarı:** Bu projede pattern bazında kabaca **%70–80 daha az dosya ve satır** (ör. Strategy 5→1 dosya, Builder ~181→36 satır, Visitor 8→1 dosya).
- **Test ve okunabilirlik:** Saf fonksiyonlar ve küçük birimler testi kolaylaştırır; record ve sealed ile niyet daha net.
- **Java artık çok paradigmalı:** OOP + FP birlikte kullanıldığında hem domain modeli hem davranışı ifade etmek daha az kodla ve daha güvenli (tip sistemi) yapılabiliyor.
- **Özet mesaj:** “OOP vs FP” yerine “doğru yerde OOP, doğru yerde FP”; **OOP + FP = en güçlü kombinasyon** — Java bu kombinasyonu destekleyecek özelliklerle (lambda, record, sealed, pattern matching) güçlü bir şekilde sunuyor.

**Sunumda vurgulanacak üç cümle:**

1. Design pattern’ler hâlâ geçerli; değişen, uygulama biçimleri (daha az sınıf, daha çok fonksiyon ve veri yapısı).
2. Modern Java ile aynı problemlere çok daha az kodla, daha test edilebilir ve okunaklı çözümler yazılabiliyor.
3. OOP ile domain modeli, FP ile davranışı modelleyerek hibrit kullanım, günlük projelerde en mantıklı yol.

**Sunum akışı önerisi (kısa):** Giriş → OOP vs FP felsefe (1) → Pattern matrisi ile 11 pattern özeti (2) → Karar rehberi (3) → Avantaj/dezavantaj (4) → Performans ve okunabilirlik (5–6) → Ekip ve legacy (7–8) → Best practices (9) → Sonuç (10). İsteğe bağlı: canlı kod ile Strategy veya Decorator karşılaştırması.

---

**Proje yapısı (referans):**

- Klasik: `src/main/java/com/javadayistanbul/patterns/classic/{strategy,builder,templatemethod,decorator,visitor,observer,factory,state,chainofresponsibility,command,adapter}/`
- Modern: `src/main/java/com/javadayistanbul/patterns/modern/{...aynı isimler...}/`
- Demolar: `demo/StrategyDemo.java`, `BuilderDemo.java`, `DecoratorDemo.java`, vb. — her pattern için klasik ve modern kullanım örneği çalıştırılabilir.

---

*Belge, `javadayistanbul-modern-java-design-patterns` projesindeki classic ve modern paketlerindeki örneklere dayanmaktadır. Sunumda proje kodlarıyla birlikte kullanılması önerilir. Tüm demo sınıfları `Main.java` üzerinden veya ilgili `*Demo.java` main metotlarıyla çalıştırılabilir.*
