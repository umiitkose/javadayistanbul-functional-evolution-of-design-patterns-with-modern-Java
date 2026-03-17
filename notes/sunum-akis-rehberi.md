# Sunum Akis Rehberi - 25 Dakika

**Baslik:** Modern Java ile Design Patterns'in Fonksiyonel Evrimi
**Etkinlik:** JavaDay Istanbul 2025
**Sure:** 25 dakika

---

## Dakika Dakika Akis

### 0:00 - 2:00 | GIRIS (2 dk)
- Kendini tanit (kisa, 30 sn)
- "Java her yil degisiyor, biz de degisiyor muyuz?" sorusu
- Hedef: 5 pattern, klasik vs modern, canli karsilastirma
- "Sunumun sonunda repo linkini paylasacagim, 11 pattern var" -> Merak uyandır

### 2:00 - 3:30 | JAVA'NIN EVRIMI (1.5 dk)
- Java 8: Lambda, Stream, Functional Interface
- Java 14-16: Records
- Java 17: Sealed Classes
- Java 21: Pattern Matching, Switch Expressions
- "Bu ozellikler design patterns'i nasil etkiliyor?"
- **Slide:** Java versiyonlari timeline

### 3:30 - 7:30 | STRATEGY PATTERN (4 dk)
- **Neden ilk bu?** En basit donusum, isindirma
- Sol: 5 dosya goster (interface + 3 concrete + service)
- Sag: 1 dosya goster (Consumer + lambda)
- **Vurgula:** "PaymentStrategy interface'i artik gereksiz!"
- **Java Feature:** Lambda nedir? Consumer<T> nedir? (30 sn aciklama)
- Demo calistir: `StrategyDemo.run()`
- **Etki:** "5 dosya -> 1 dosya, ayni sonuc"

### 7:30 - 11:30 | BUILDER PATTERN (4 dk)
- Sol: POJO goster (getter/setter/equals/hashCode/toString = ~90 satir)
- Sag: record goster (~30 satir)
- **Vurgula:** "toString, equals, hashCode OTOMATIK!"
- **Java Feature:** Record nedir? Compact constructor nedir? (45 sn)
- Wither pattern goster: `orderClassic.withShippingAddress("Istanbul")`
- **Etki:** "90 satir boilerplate -> 30 satir record"

### 11:30 - 15:00 | DECORATOR PATTERN (3.5 dk)
- Sol: 6 dosya (interface + base + 3 decorator, ic ice sarma)
- Sag: UnaryOperator + andThen() zincirleme
- **Vurgula:** Ic ice sarma (`new A(new B(new C()))`) vs `a.andThen(b).andThen(c)`
- **Java Feature:** UnaryOperator, andThen() compostion (30 sn)
- Demo calistir: `DecoratorDemo.run()`
- **Etki:** "Decorator sinifi tamamen ortadan kalkti!"

### 15:00 - 19:00 | VISITOR PATTERN (4 dk) -- EN ETKILEYICI
- Sol: 8 dosya! (double dispatch mekanizmasi acikla)
- Sag: 1 dosya! (sealed interface + switch)
- **Vurgula:** "8 dosya -> 1 dosya, EN dramatik donusum!"
- **Java Feature:** Sealed interface + Pattern matching + Exhaustiveness (1 dk)
- "Yeni bir OrderItem tipi eklersen, compiler HATA verir!"
- Demo calistir: `VisitorDemo.run()`
- **Etki:** "Visitor pattern artik gereksiz!"

### 19:00 - 22:00 | TEMPLATE METHOD (3 dk)
- Sol: Abstract class + inheritance hiyerarsisi
- Sag: Record + Consumer/Function parametreleri
- **Vurgula:** "Inheritance yerine composition!"
- **Java Feature:** Higher-orderClassic functions (fonksiyon alan fonksiyonlar)
- "Yeni bir islem tipi icin sinif YAZMAYA GEREK YOK"
- **Etki:** "Abstract class tamamen ortadan kalkti!"

### 22:00 - 24:00 | OOP vs FP: NE ZAMAN HANGISI? (2 dk)
- **Bu sunumun en onemli mesaji:**
  - "Paradigma savasi degil, EN UYGUN ARACI SECMEK"
  - Domain model: OOP (siniflar, iliski)
  - Davranis/strateji: FP (lambda, kompozisyon)
  - Veri tasima: Records
  - Tip guveniligi: Sealed classes
- Karar checklist'i goster (1 slide)
- Legacy gecis stratejisi: "Strategy'den baslayin, en kolay"

### 24:00 - 25:00 | KAPANIS (1 dk)
- Repo linkini goster / QR code
- "Repoda 11 pattern var, 6 tanesini burada gostermedik"
- "notes/ dizininde tum aciklamalar, cheat sheet, karsilastirma"
- Sosyal medya linkleri
- "Sorulariniz icin sunumdan sonra bulabilirsiniz"
- Tesekkurler!

---

## Kritik Notlar

### Zamanlama Riskleri
- Strategy + Builder toplam 8 dk'yi GECMEMELI
- Visitor EN COK 4 dk olmali (cok heyecanlanma, uzatma)
- OOP vs FP bolumu ATLAMA, sunumun kalbi burasi

### Sunum Sirasinda Dikkat
- Her pattern icin ONCE sol (klasik), SONRA sag (modern) goster
- Dosya sayisini her seferinde vurgula
- Demo calistirirken terminali BUYUT
- Kod fontunu EN AZ 18px yap (arkadakiler gorsin)

### Yedek Plan
- Demo calismazsa: Hazir output screenshot'lari
- Sure yetmezse: Template Method'u ATLA (en az etkileyici)
- Sure kalirsa: Observer veya Command'i bonus olarak goster

### Izleyici Etkilesimi
- Baslangicta soru sor: "Kac kisiniz Java 17+ kullaniyor?"
- Visitor'da: "Kac dosya oldugunu tahmin edin?" (8 dosya sasirtir)
- Sonunda: "Yarin hangi pattern'i modernize edeceksiniz?"

---

## Gerekli Materyaller Checklist

- [ ] Laptop sarji %100
- [ ] IDE acik, tum dosyalar hazir
- [ ] Terminal acik, `mvn compile` tamamlanmis
- [ ] Font boyutu ayarlanmis (IDE + Terminal)
- [ ] Dark mode / Light mode izleyicilere uygun
- [ ] Repo public yapilmis
- [ ] Slides hazir (sadece yapisal destek icin)
- [ ] Su / bogaz pastili
- [ ] Yedek: Output screenshot'lari
