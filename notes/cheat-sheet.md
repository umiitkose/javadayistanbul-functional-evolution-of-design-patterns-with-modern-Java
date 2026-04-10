# Design Patterns - Fonksiyonel Evrim Cheat Sheet

> **JavaDay Istanbul 2025** | github.com/umiitkose/javadayistanbul-modern-java-design-patterns

---

## Sunum Pattern'leri (5 Ana)

| Pattern | Klasik OOP | Modern FP | Dosya | Java Ozelligi |
|---------|-----------|-----------|-------|---------------|
| **Strategy** | `interface` + N concrete class | `Consumer<T>` + lambda | 5→1 | Lambda, Functional Interface |
| **Builder** | POJO + Builder class | `record` + compact constructor | 2→1 | Records, Immutability |
| **Template Method** | `abstract class` + inheritance | `record` + `Function`/`Consumer` params | 4→2 | Higher-Order Functions |
| **Decorator** | Interface + wrapper chain | `UnaryOperator<T>` + `andThen()` | 7→2 | Function Composition |
| **Visitor** | Double dispatch + visitor interface | `sealed interface` + `switch` | 8→1 | Sealed Classes, Pattern Matching |

## Bonus Pattern'ler (6 Ek)

| Pattern | Klasik OOP | Modern FP | Dosya | Java Ozelligi |
|---------|-----------|-----------|-------|---------------|
| **Observer** | Listener interface + concrete | `Consumer<T>` + lambda | 5→1 | Consumer, Method Ref |
| **Factory Method** | Enum + factory + interface | `sealed` + pattern matching | 6→1 | Sealed + Switch |
| **State** | State interface + N state class + context | `sealed interface` + record + switch | 6→1 | Sealed Records |
| **Chain of Resp.** | Abstract handler + chain | `Predicate<T>` + `and()`/`or()` | 5→1 | Predicate Composition |
| **Command** | Command interface + concrete | `Runnable` + lambda | 5→1 | Runnable, Lambda |
| **Adapter** | Wrapper class + interface | `BiFunction` + lambda | 3→1 | BiFunction, Lambda |

---

## Java Ozellikleri Hizli Referans

| Ozellik | Java | Kullanim | Pattern |
|---------|------|----------|---------|
| **Lambda** | 8 | `x -> x * 2` | Strategy, Observer, Command |
| **Consumer\<T>** | 8 | `void` donen tek param | Strategy, Observer |
| **Function\<T,R>** | 8 | Donusturucu | Template Method |
| **Predicate\<T>** | 8 | `boolean` donen | Chain of Responsibility |
| **UnaryOperator\<T>** | 8 | Ayni tip donusturucu | Decorator |
| **BiFunction\<T,U,R>** | 8 | 2 param donusturucu | Adapter |
| **andThen()** | 8 | Fonksiyon zincirleme | Decorator, Chain |
| **Records** | 16 | Immutable veri | Builder, Template, Visitor, State |
| **Sealed Classes** | 17 | Kontrol altinda kalitim | Visitor, State, Factory |
| **Pattern Matching** | 21 | `switch(x) { case T t ->` | Visitor, State, Factory |
| **var** | 10 | Tip cikarimi | Tum demolar |

---

## Karar Rehberi: OOP mi FP mi?

```
Davranis/strateji degisecek mi?
  EVET → FP (lambda)  |  HAYIR → Sabit sinif

Veri tasima mi?
  EVET → Record       |  HAYIR → Class

Tip hiyerarsisi sinirli mi?
  EVET → Sealed       |  HAYIR → Interface

Islem zinciri mi?
  EVET → andThen()    |  HAYIR → Wrapper

Durum makinesi mi?
  EVET → Sealed+Switch |  HAYIR → Enum/Class
```

---

## Hizli Komutlar

```bash
# Tum pattern'leri calistir
java -cp target/classes com.javadayistanbul.patterns.demo.Main

# Interaktif menu
java -cp target/classes com.javadayistanbul.patterns.demo.InteractiveDemo

# Tek pattern calistir
java -cp target/classes com.javadayistanbul.patterns.demo.StrategyDemo
java -cp target/classes com.javadayistanbul.patterns.demo.VisitorDemo

# Kod istatistikleri
./stats.sh
```

---

## Toplam Etki (Gercek Rakamlar)

| Metrik | Klasik OOP | Modern FP | Degisim |
|--------|-----------|-----------|---------|
| **Dosya sayisi** | 54 | 13 | -%76 |
| **Satir sayisi** | 1094 | 442 | -%60 |
| **Boilerplate** | Cok | Minimal | -%90 |
| **Test edilebilirlik** | Orta | Yuksek | +50% |
| **Okunabilirlik** | Bilinen | Modern | = |

> **"Design patterns HALA gecerli. Uygulanma bicimi degisti."**
