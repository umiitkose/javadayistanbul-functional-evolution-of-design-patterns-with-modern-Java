# Modern Java ile Design Patterns'ın Fonksiyonel Evrimi — Q&A Hazırlık Notları

> **Sunum:** JavaDay İstanbul 2026  
> **Konuşmacı:** Ümit Köse  
> **Süre:** 25 dakika • Java 8–26 odaklı  

---

## 1. Builder Pattern → Record Kompozisyonu

### Soru 1.1: Record'lar gerçekten Builder'ın yerini alıyor mu?

**Soru:** Sunumdaki `new StockReservation(new ReservationIdentity(...), new QuantityAllocation(100, 80), ...)` çağrısı 7-8 parametre alıyor. Bu da bir nevi telescoping constructor'a geri dönüş değil mi?

**Cevap:**  
Sunum amacıyla bilinçli olarak basitleştirilmiş bir yapı. Burada amaç Builder'ı tamamen öldürmek değil, FP'nin immutability garantisini vurgulamak. Record kompozisyonu parametreleri anlamsal gruplara ayırarak (ReservationIdentity, QuantityAllocation gibi) okunabilirliği artırıyor — 20 düz String/int yerine 5-6 anlamlı nesne görüyorsun.

**Önemli nüans:** Builder'ın çözdüğü iki temel sorun var:
1. Çok sayıda parametrenin okunabilirliği → Record kompozisyonu bunu kısmen çözüyor
2. Opsiyonel alanların yönetimi → Burada FP zorlanıyor, bu da trade-off'un bir parçası

**Sunumda vurgulanabilecek mesaj:** "Builder'ı tamamen öldürüyoruz değil, Builder'ın çözdüğü problemlerden birini — immutable nesne garantisini — artık dil seviyesinde çözüyoruz."

---

### Soru 1.2: Builder'ın mutability problemi

**Soru:** Builder'ın kendisinin mutable olması neden sorun?

**Cevap:**  
Builder nesnesi paylaşıldığında veya yeniden kullanıldığında öngörülemeyen davranışlar çıkabiliyor:

```java
var builder = new Builder("R-1", "WH-1", "SKU-A").requestedQuantity(100);
someService.configure(builder); // builder state değişmiş olabilir!
var res1 = builder.build();     // hangi state ile build edildi?
```

Record ise oluşturulduğu anda final — bu riski tamamen ortadan kaldırıyor. Bu argüman sunumda vurgulanmalı çünkü herkes bu hatayı ya yaşamıştır ya da yaşayacaktır.

---

### Soru 1.3: Validasyonun build()'da toplanması

**Soru:** Tüm validasyonun build() metodunda olması ne kadar kullanışlı?

**Cevap:**  
Builder'da validasyon "fail late" yaklaşımıdır. 15 alan set ediyorsun, sonra build() çağırıyorsun ve ancak o anda hata alıyorsun. Birden fazla hata varsa genellikle sadece ilkini görürsün.

Record'da ise compact constructor "fail fast, fail local" prensibiyle çalışır — `ReservationIdentity` oluşturulurken hemen patlar, hata kaynağına en yakın noktada yakalarsın.

**Sunumda söylenebilecek:** "Builder'da validasyon merkezi ve geç, record'da dağıtık ve erken — hangisi hatayı bulmayı kolaylaştırır?"

---

### Soru 1.4: Opsiyonel alanlar nasıl yönetiliyor?

**Soru:** 20 alandan 5'i opsiyonel olduğunda ne yapıyorsun?

**Cevap:**  
Bu, FP ile bu pattern'i uyarlamanın zorluğunu gösteriyor ve bu zorluk kabul ediliyor. Çözüm olarak factory method'lar kullanılabilir:

```java
public record StockReservation(...) {
    public static StockReservation withDefaults(
            ReservationIdentity identity,
            QuantityAllocation quantities) {
        return new StockReservation(
            identity, quantities,
            PricingTerms.standard(), StorageSlot.defaults());
    }
}
```

**Sunumda bu zorluğu açıkça söylemek güvenilirliği artırır** — "her şey FP ile güzel" yerine "bakın, burada FP bizi zorluyor" demek daha ikna edici.

---

### Soru 1.5: Lombok bağımlılığı ve record ilişkisi

**Soru:** Lombok @Builder kullanmak bir alternatif değil mi?

**Cevap:**  
Lombok annotation processor seviyesinde çalışır, IDE desteği gerektirir, derleme süresini etkiler ve Java versiyon geçişlerinde kırılabilir. Özellikle Java 17+ module system ile `--add-opens` hack'lerine ihtiyaç duyması sorun.

Record'lar ile bu çözümü dil seviyesinde, sıfır bağımlılıkla elde ediyoruz. Java'nın evrimi üçüncü parti kütüphanelerin çözdüğü sorunları dilin içine çekiyor:
- Lombok `@Data` / `@Value` → record
- Guava `ImmutableList` → `List.of()`

**Not:** Lombok'un `@Data`'sı mutable bir sınıf üretir (setter'lar var). İmmutable karşılığı `@Value`'dur. Record aslında `@Value`'nun dil seviyesindeki native hali.

---

### Soru 1.6: Hibrit yaklaşım — Record + Builder

**Soru:** İkisini birlikte kullanmak mümkün mü?

**Cevap:** Evet, zorunlu alanları derleme zamanında zorlayan, opsiyonelleri fluent chain ile alan ve sonuçta immutable record döndüren bir yapı kurulabilir:

```java
public record StockReservation(
    ReservationIdentity identity,
    QuantityAllocation quantities,
    PricingTerms pricing,
    StorageSlot storageSlot,
    PhysicalWeights weights,
    ComplianceNotes compliance
) {
    public static Builder builder(ReservationIdentity identity, 
                                   QuantityAllocation quantities) {
        return new Builder(identity, quantities);
    }

    public static final class Builder {
        private final ReservationIdentity identity;
        private final QuantityAllocation quantities;
        private PricingTerms pricing = PricingTerms.standard();
        private StorageSlot storageSlot = StorageSlot.defaults();
        private PhysicalWeights weights = PhysicalWeights.none();
        private ComplianceNotes compliance = ComplianceNotes.empty();

        private Builder(ReservationIdentity identity, 
                        QuantityAllocation quantities) {
            this.identity = identity;
            this.quantities = quantities;
        }

        public Builder pricing(PricingTerms p) { this.pricing = p; return this; }
        public Builder storageSlot(StorageSlot s) { this.storageSlot = s; return this; }
        // ... diğer opsiyonel alanlar

        public StockReservation build() {
            return new StockReservation(
                identity, quantities, pricing, 
                storageSlot, weights, compliance);
        }
    }
}
```

**Kullanım:** Builder'ın ergonomisi korunur, çıktı immutable bir record. Lombok'a ihtiyaç yok. Sunumda "ileri seviye" veya "bonus" olarak gösterilebilir.

---

## 2. Strategy Pattern → Lambda

### Soru 2.1: Strateji karmaşıklaştığında lambda yetmez mi?

**Soru:** Sunumdaki `Consumer<BigDecimal>` tek metotlu. Gerçek dünyada bir ödeme stratejisinin `pay()`, `refund()`, `validate()`, `getTransactionFee()` gibi birden fazla davranışı olur. O zaman ne olacak?

**Cevap:**  
Projede bununla karşılaşıldı. İki yol var:

1. Her davranışı ayrı fonksiyonel parametre olarak taşıyan bir record:
```java
public record PaymentStrategy(
    Consumer<BigDecimal> pay,
    Consumer<BigDecimal> refund,
    Predicate<String> validate,
    UnaryOperator<BigDecimal> transactionFee
) { ... }
```

2. Pragmatik kabul: işler karmaşıklaşacaksa doğrudan OOP Strategy kullanmak.

**Gerçek proje deneyimi:** İkisi de güzel yaklaşımlar, ama karmaşıklaşabileceği öngörülünce doğrudan OOP strategy tercih edildi.

**Sunumda eklenebilecek mesaj:** "Lambda ile başla, karmaşıklaştığında interface'e terfi ettir — bu bir geri adım değil, olgunlaşma."

---

### Soru 2.2: Lambda'larda debug ve stack trace sorunu

**Soru:** Stack trace'de `PaymentService$$Lambda$14/0x0000000800c01200` gördüğünde, `CreditCardPayment.pay()` kadar bilgilendirici değil. Üretim ortamında bu nasıl yönetilir?

**Cevap — Pratik çözümler:**

**1. Method reference kullanmak:**
```java
// Stack trace'de anlamsız
Consumer<BigDecimal> pay = amount -> processCard(amount);

// Stack trace'de PaymentService::processCard olarak görünür
Consumer<BigDecimal> pay = PaymentService::processCard;
```

**2. Lambda'yı isimli static final alana atamak:**
```java
public class PaymentStrategies {
    public static final Consumer<BigDecimal> CREDIT_CARD = amount -> { ... };
}
```

**3. Logging wrapper (Decorator pattern'in fonksiyonel hali):**
```java
public static <T> Consumer<T> logged(String name, Consumer<T> action) {
    return t -> {
        log.info("Strategy başlıyor: {}", name);
        action.accept(t);
        log.info("Strategy tamamlandı: {}", name);
    };
}

Consumer<BigDecimal> pay = logged("credit-card", amount -> ...);
```

**Dürüst cevap:** Bunların hiçbiri klasik sınıfın stack trace netliğini tam olarak yakalayamaz. Debug tarafında bir bedeli var, method reference ve logging wrapper'larla hafifletilir ama sıfırlanmaz. Bu trade-off kabul edilmeli.

---

### Soru 2.3: Lambda'da tip güvenliği eksikliği

**Soru:** `Consumer<BigDecimal>` herhangi bir BigDecimal tüketen lambda'yı kabul eder. Loglama yapan bir lambda'yı ödeme stratejisi olarak geçirsen derleyici ses çıkarmaz.

**Karşı argüman (güçlü):**  
Klasik interface'de de aynı sorun var:

```java
public class LoggingService implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        log.info("Amount: {}", amount); // ödeme yapmıyor!
    }
}
// Derleyici mutlu, runtime'da felaket
```

Derleyici her iki durumda da seni "bu gerçekten bir ödeme stratejisi mi?" diye korumaz — sadece imzanın uyduğunu kontrol eder. Kompozisyon aynı kompozisyon.

**Nüans:** Asıl fark tip güvenliği değil, **semantik okunabilirlik**. `CreditCardPayment implements PaymentStrategy` gördüğünde amacı isminden anlarsın. Lambda'da bu sinyal kaybolur. Bu compile-time güvenliği değil, okunabilirlik meselesi.

**Q&A'da söylenebilecek:** "Haklısınız, her iki durumda da derleyici sizi korumaz, fark semantik okunabilirlikte."

---

## 3. Decorator Pattern → andThen() Kompozisyonu

### Soru 3.1: Side effect ve dış servis bağımlılığı olan decorator'lar

**Soru:** Klasik Decorator state ve dependency taşır (API client, cache, retry policy). `UnaryOperator<Order>` stateless bir dönüşüm. Decorator'ın dış servise bağımlılığı varsa bu model bozulmaz mı?

**Cevap:**  
Net pozisyon: **saf dönüşüm → FP, yan etki → OOP.** Bu, sunumdaki satranç slaytıyla (OOP vs FP karar çerçevesi) tamamen uyumlu.

Bu demek değil ki ikisi birlikte kullanılamaz. Hibrit çalışabiliyorsa tercih edilebilir — tamamen trade-off meselesi. Gelen probleme göre tasarlamak lazım, bazen OOP çözümü işe gelecek şekilde ayarlanır ama bu durum ikisinin birlikte kullanılamayacağı anlamına gelmez.

**Sunumda eklenebilecek bir cümle:** "Bu yaklaşım saf dönüşümler için ideal. Dış servis bağımlılığı olan decorator'larda klasik OOP hâlâ doğru tercih."

---

### Soru 3.2: Dinamik pipeline'da sıralama garantisi

**Soru:** `reduce` ile dinamik pipeline kurduğunda sıralama runtime'a kayar. Sıralama garantisi nasıl sağlanır?

**Cevap:**  
Bu aslında yeni bir problem değil — klasik ordering problemi. Veritabanından sipariş listesi çekerken `ORDER BY priority` yazarsın, burada da aynı mantık geçerli. Sıralama bilgisi verinin kendisinde yaşar.

**Trade-off:** Statik sıralama (nested constructor) kodda açık ve güvenli. Dinamik sıralama esnek ama sıralama sorumluluğunu konfigürasyon katmanına taşır. Karşı tarafın yapısına göre sorgulanmalı.

---

## 4. Template Method Pattern → Higher-Order Functions

### Soru 4.1: Lambda'lar arasındaki implicit kontrat

**Soru:** `dataFormatter`'ın çıktısı `outputRenderer`'ın girdisi olmak zorunda. İkisi de `String → String` — yanlış formatter ile doğru renderer eşleştirebilirsin. Bu kontrat nerede korunuyor?

**Cevap:**  
Record'un `generate()` metodu lambda'lar arasındaki geçişi taahhüt ediyor ve bu sıranın bozulmaması gerektiğini yapısal olarak belirtiyor. Factory method'lar uyumlu lambda setlerini bir kez doğru eşleştirip dışarıya tutarlı bir birim olarak sunuyor.

Ayrıca klasik yaklaşımla önemli bir fark var: klasik `AbstractReportGenerator`'da birisi `generate()` metodunu `final` yapmayı unutursa, alt sınıf tüm iskeleti ezebilir. **Record'da bu risk yok** çünkü override edecek bir kalıtım mekanizması mevcut değil. Record, kalıtım yokluğuyla iskeleti koruyor — `final` keyword'üne bile ihtiyaç duymadan.

**Sunumda söylenebilecek:** "Klasik Template Method'da iskeleti korumak için `final` demeniz gerekir ve birisi bunu unutabilir. Record'da iskelet zaten korunur çünkü override edecek mekanizma yok."

---

### Soru 4.2: Spring ve DI entegrasyonu

**Soru:** Klasik yaklaşımda `PdfReportGenerator` bir `@Component`, Spring inject eder. Modern yaklaşımda record'ları Spring'e nasıl tanıtıyorsun?

**Cevap:**  
`@Configuration` + factory method yaklaşımı:

```java
@Configuration
public class ReportConfig {
    @Bean
    public ReportGenerator pdfReport() {
        return ReportGenerator.pdf();
    }
    
    @Bean
    public ReportGenerator excelReport() {
        return ReportGenerator.excel();
    }
}
```

Bu, Spring'in kendi evrimiyle de uyumlu — deklaratif, annotation-based konfigürasyon. Record + factory + `@Bean` üçlüsü bu felsefeyle örtüşüyor.

---

## 5. Genel Sorular (Pattern-bağımsız)

### Soru 5.1: Test edilebilirlik nasıl değişiyor?

**Soru:** "%60-80 daha az kod" iddiası var ama test tarafı gösterilmiyor.

**Cevap:**  
Gerçek kazanç "daha az test kodu" değil, **daha kolay test setup'ı:**

```java
// Klasik Builder — build() çağırmadan tek alanı test edemezsin
@Test
void shouldValidateReservationId() {
    assertThrows(IllegalStateException.class, () ->
        new Builder(null, "WH-1", "SKU-A").requestedQuantity(100).build());
}

// Record — doğrudan, setup yok
@Test
void shouldValidateReservationId() {
    assertThrows(IllegalArgumentException.class, () ->
        new ReservationIdentity(null, "WH-1", "SKU-A"));
}
```

Küçük record'lar bağımsız test edilebilir. `ReservationIdentity` testini `QuantityAllocation`'dan bağımsız yazarsın. Klasik Builder'da tüm nesneyi build etmeden tek bir alanı test edemezsin.

---

### Soru 5.2: Mevcut projede nasıl geçiş yapılır?

**Soru:** "İkna oldum, pazartesi ne yapayım?"

**Cevap — Risk-fayda sırasına göre yol haritası:**

1. **Yeni kod** record ile yazılır, mevcut koda dokunulmaz
2. **Value object'ler** (Money, Address, DateRange) record'a çevrilir — en düşük risk
3. **Tek metotlu Strategy interface'leri** lambda'ya dönüştürülür
4. **Builder'lar** kademeli olarak record kompozisyonuna geçirilir

---

### Soru 5.3: Çok sayıda küçük record GC pressure yaratmaz mı?

**Soru:** Bu kadar küçük nesne performansı etkiler mi?

**Cevap:**  
- Kısa ömürlü, küçük nesneler young generation'da toplanır, maliyeti neredeyse sıfır
- JIT compiler küçük nesneleri **scalar replacement** ile stack'e taşıyabilir — heap'e bile çıkmaz
- **Project Valhalla** ile value types geldiğinde record'lar doğal aday
- Lambda'lar `invokedynamic` ile oluşturulur, çoğu durumda **singleton olarak cache'lenir** — her çağrıda yeni nesne üretmez

---

### Soru 5.4: DDD ile bağlantı var mı?

**Soru:** Bu value object'ler DDD'deki value object'lerle aynı mı?

**Kısa cevap:** Evet. Record'lar Java'da DDD value object'lerini uygulamanın en doğal yolu haline geldi:
- Identity'si yok (alan değerlerine göre eşitlik)
- Immutable
- Kendi validasyonunu compact constructor'da taşır

Eskiden bir `Money(amount, currency)` value object'i için 50 satır boilerplate yazılırdı, şimdi tek satır. Bu da geliştiricileri küçük, anlamlı tipler yazmaya teşvik ediyor.

---

## 6. Sunumun Genel Güçlü Yanları

- **Dogmatik değil, pragmatik** — "Her şeyi FP yapın" demiyor, "araç kutunuzu genişletin" diyor
- **Tutarlı yapı** — Her pattern için: tanım → diyagram → klasik kod → modern kod → çıkarımlar
- **Gerçek dünya örnekleri** — Stok rezervasyonu, ödeme, sipariş, rapor üretimi
- **Satranç slaytı** — OOP "neyi", FP "nasılı" ayrımı sunumun felsefi omurgası
- **Brian Goetz alıntısı** — "Be a better programmer" tüm mesajı tek cümleye indirgiyor

---

## 7. Sunumda Dikkat Edilecekler

- Kod slaytlarındaki font boyutu bazı yerlerde küçük — konferans salonunda arka sıralardan okunması zor olabilir
- "%60-80 daha az kod" iddiası somut bir karşılaştırmayla desteklenmeli (satır sayısı gibi)
- Decorator'daki `andThen()` sıra farkı notu (Function Composition Notu) altta küçük kalmış — sözlü olarak vurgulanmalı
- Her pattern'deki trade-off'ları explicit söylemek güvenilirliği artırır

---

*Bu notlar Q&A hazırlığı için derlenmiştir. Sunumun kendisine ekleme yapılması önerilen noktalar ilgili bölümlerde belirtilmiştir.*
