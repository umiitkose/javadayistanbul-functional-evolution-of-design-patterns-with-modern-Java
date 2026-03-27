# Modern Java ile Design Patterns'in Fonksiyonel Evrimi

**JavaDay Istanbul 2026** - 25 Dakikalik Sunum

Klasik Gang of Four design pattern'lerinin modern Java (8-26) ile nasil daha sade, daha guclu ve daha fonksiyonel bir hale geldigini gosteren kapsamli ornek projesi.

## Proje Hakkinda

Bu proje, bir **E-Ticaret Siparis Isleme Sistemi** uzerinden 11 farkli design pattern'in hem klasik OOP hem de modern fonksiyonel versiyonlarini icermektedir. Her pattern icin:

- `classic/` - Klasik OOP implementasyonu (Java 8 oncesi yaklasim)
- `modern/` - Modern fonksiyonel implementasyon (Java 8-26 ozellikleri)
- `demo/` - Karsilastirmali demo sinifi (her ikisini de calistirir)

## Sunum Pattern'leri (3 Ana Pattern)

| #   | Pattern             | Klasik                                         | Modern                                   | Ogrenilen Java Ozelligi                  |
| --- | ------------------- | ---------------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| 1   | **Builder**         | POJO (getter/setter/equals/hashCode) + Builder | record + compact constructor + wither    | Records, Compact Constructors            |
| 2   | **Strategy**        | Interface + 3 concrete class + service         | Consumer\<T> + lambda                    | Lambda Expressions, Functional Interface |
| 3   | **Decorator**       | Interface + wrapper classes (ic ice sarma)     | UnaryOperator\<T> + andThen() zincirleme | UnaryOperator, Function Composition      |

## Bonus Pattern'ler (8 Ek Pattern)

| #   | Pattern                     | Klasik                                    | Modern                              | Ogrenilen Java Ozelligi          |
| --- | --------------------------- | ----------------------------------------- | ----------------------------------- | -------------------------------- |
| 4   | **Iterator/Stream**         | for-each ile external iteration           | Stream pipeline ile internal iteration | Stream API, Declarative Thinking |
| 5   | **Template Method**         | Abstract class + inheritance              | record + Consumer/Function parametreleri | Higher-Order Functions, Composition |
| 6   | **Observer**                | Listener interface + concrete listeners   | Consumer\<T> + lambda               | Consumer, Method References      |
| 7   | **Factory Method**          | Enum + factory class + interface          | sealed interface + pattern matching | Sealed + Exhaustive Switch       |
| 8   | **State**                   | State interface + 4 state class + context | sealed interface + record + switch  | Sealed Records, Pattern Matching |
| 9   | **Chain of Responsibility** | Abstract handler + concrete handlers      | Predicate\<T> + and()/or()          | Predicate Composition            |
| 10  | **Command**                 | Command interface + concrete commands     | Runnable + lambda                   | Runnable, Method References      |
| 11  | **Adapter**                 | Wrapper class + interface                 | BiFunction + lambda adaptasyon      | BiFunction, Lambda               |

## Gereksinimler

- **Java 21+** (records, sealed classes, pattern matching, switch expressions)
- **Maven 3.8+**

## Calistirma

```bash
# Projeyi derle
mvn compile

# Tum pattern'leri calistir
mvn exec:java -Dexec.mainClass="com.javadayistanbul.patterns.demo.Main"

# Tek bir pattern calistir
mvn exec:java -Dexec.mainClass="com.javadayistanbul.patterns.demo.StrategyDemo"
mvn exec:java -Dexec.mainClass="com.javadayistanbul.patterns.demo.BuilderDemo"
mvn exec:java -Dexec.mainClass="com.javadayistanbul.patterns.demo.DecoratorDemo"
mvn exec:java -Dexec.mainClass="com.javadayistanbul.patterns.demo.VisitorDemo"
```

## Proje Yapisi

```
src/main/java/com/javadayistanbul/patterns/
├── classic/                    # Klasik OOP implementasyonlari
│   ├── strategy/              # 5 dosya: interface + 3 concrete + service
│   ├── builder/               # 2 dosya: POJO + builder
│   ├── templatemethod/        # 4 dosya: abstract + 2 concrete + orderClassic
│   ├── decorator/             # 6 dosya: interface + base + 3 decorator + orderClassic
│   ├── visitor/               # 8 dosya: item interface + 3 item + visitor interface + 2 visitor
│   ├── observer/              # 5 dosya: event + listener interface + 2 listener + manager
│   ├── factory/               # 6 dosya: enum + interface + 3 concrete + factory
│   ├── state/                 # 6 dosya: interface + 4 state + context
│   ├── chainofresponsibility/ # 5 dosya: abstract handler + 3 handler + orderClassic
│   ├── command/               # 5 dosya: interface + 3 command + invoker
│   └── adapter/               # 3 dosya: legacy system + interface + adapter
├── modern/                    # Modern fonksiyonel implementasyonlar
│   ├── strategy/              # 1 dosya: Consumer + lambda
│   ├── builder/               # 1 dosya: record
│   ├── templatemethod/        # 2 dosya: record processor + orderClassic
│   ├── decorator/             # 2 dosya: UnaryOperator + orderClassic
│   ├── visitor/               # 1 dosya: sealed interface + record + switch
│   ├── observer/              # 1 dosya: Consumer + record event
│   ├── factory/               # 1 dosya: sealed interface + BiConsumer
│   ├── state/                 # 1 dosya: sealed interface + record + switch
│   ├── chainofresponsibility/ # 1 dosya: Predicate composition
│   ├── command/               # 1 dosya: Runnable + lambda
│   └── adapter/               # 1 dosya: BiFunction + lambda
└── demo/                      # Karsilastirmali demo siniflari
    ├── StrategyDemo.java
    ├── BuilderDemo.java
    ├── TemplateMethodDemo.java
    ├── DecoratorDemo.java
    ├── VisitorDemo.java
    ├── ObserverDemo.java
    ├── FactoryDemo.java
    ├── StateDemo.java
    ├── ChainOfResponsibilityDemo.java
    ├── CommandDemo.java
    ├── AdapterDemo.java
    └── Main.java              # Tum demo'lari sirasiyla calistirir
```

## Dosya Sayisi Karsilastirmasi

| Yaklasim               | Dosya Sayisi |
| ---------------------- | ------------ |
| **Klasik OOP**         | ~55 dosya    |
| **Modern Fonksiyonel** | ~12 dosya    |
| **Azalma**             | **~%80**     |

## Sunumcu

**Umit Kose**

- YouTube: [Design Patterns Playlist](https://www.youtube.com/watch?v=Sc2d6y2YO9w&list=PLXSngD2-TyxqItaCjTW_UaovgtTfGZhhY)
- GitHub: [Sunum Repo](https://github.com/umiitkose/javadayistanbul-functional-evolution-of-design-patterns-with-modern-Java)
- Turkiye Java Community - Ankara 2024: [Java ile Fonksiyonel Programlama](https://kommunity.com/turkiye-java-community/events/java-ile-fonksiyonel-programlama-lambdadan-stream-gathererslara-7cd8a2a3)

## Lisans

MIT License
