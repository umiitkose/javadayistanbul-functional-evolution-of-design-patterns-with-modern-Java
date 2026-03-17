---
theme: default
background: "#0d1117"
class: text-white
highlighter: shiki
lineNumbers: false
info: |
  ## Modern Java ile Design Patterns'ın Fonksiyonel Evrimi
  JavaDay İstanbul 2026 - Ümit Köse
drawings:
  persist: false
transition: slide-left
title: Modern Java ile Design Patterns'ın Fonksiyonel Evrimi
mdc: true
---

<div class="flex flex-col items-center justify-center h-full">
  <div class="text-6xl font-extrabold tracking-tight bg-gradient-to-r from-yellow-300 via-orange-400 to-red-400 bg-clip-text text-transparent drop-shadow-lg mb-4">
    Modern Java ile
  </div>
  <div class="text-5xl font-bold text-white leading-tight text-center mb-8">
    <div class="tracking-tight">Design Patterns'ın</div>
    <div class="text-4xl mt-2 bg-gradient-to-r from-white via-yellow-100 to-orange-200 bg-clip-text text-transparent">Fonksiyonel Evrimi</div>
  </div>

  <div class="flex items-center gap-8">
    <div class="px-6 py-3 bg-gradient-to-r from-blue-500/25 to-sky-400/20 rounded-full border border-blue-200/40 shadow-[0_0_20px_rgba(59,130,246,0.25)]">
      <span class="font-bold text-xl bg-gradient-to-r from-blue-100 via-white to-sky-100 bg-clip-text text-transparent">JavaDay İstanbul 2026</span>
    </div>
  </div>
</div>

---

# Hakkımda

<div class="grid grid-cols-[220px_1fr] gap-6 mt-8 items-center max-w-4xl">
  <div class="p-4 rounded-2xl bg-gradient-to-b from-blue-500/20 to-white/5 border border-blue-300/20 text-center">
    <img
      src="https://github.com/umiitkose.png"
      alt="Umit Kose"
      class="w-28 h-28 rounded-full mx-auto mb-3 border-2 border-blue-200/50 shadow-[0_0_18px_rgba(147,197,253,0.35)] object-cover"
    />
    <div class="text-blue-100 font-bold text-lg">Ümit Köse</div>
    <div class="text-xs opacity-75 mt-1">Senior Software Developer</div>
    <div class="text-xs opacity-70 mt-1">Türksat Uydu Haberleşme Kablo TV ve İşletme A.Ş.</div>
  </div>

  <div class="space-y-3">
    <div class="p-3 rounded-xl bg-white/8 border border-white/15">
      <div class="text-xs uppercase tracking-wide opacity-60 mb-2">Sosyal Medya</div>
      <div class="grid grid-cols-1 gap-2 text-sm">
        <div class="flex items-center gap-2 px-3 py-2 rounded-lg bg-red-400/10 border border-red-300/20">
          <img src="/logos/youtube.png" alt="YouTube" class="w-4 h-4 object-contain" />
          <span>YouTube: @umiitkose</span>
        </div>
        <div class="flex items-center gap-2 px-3 py-2 rounded-lg bg-slate-300/10 border border-slate-200/20">
          <img src="/logos/x.png" alt="X" class="w-4 h-4 object-contain" />
          <span>X: @umiitkose</span>
        </div>
        <div class="flex items-center gap-2 px-3 py-2 rounded-lg bg-white/10 border border-white/20">
          <img src="/logos/github.svg" alt="GitHub" class="w-4 h-4 object-contain" />
          <span>GitHub: @umiitkose</span>
        </div>
      </div>
    </div>
  </div>
</div>

---

# Gündem

<div class="grid grid-cols-2 gap-4 mt-6">

<div class="space-y-3">
  <div v-click="1" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-yellow-400">
    <div class="text-yellow-400 font-bold text-lg w-8">01</div>
    <div>
      <div class="font-semibold">Java 8 - Java 25</div>
      <div class="text-xs opacity-60">
      Fonksiyonel Programlama Yolculuğu
      </div>
    </div>
  </div>

  <div v-click="2" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-yellow-400">
    <div class="text-yellow-400 font-bold text-lg w-8">02</div>
    <div>
      <div class="font-semibold">Design Patterns</div>
      <div class="text-xs opacity-60">Someone has already solved your problems.</div>
    </div>
  </div>

  <div v-click="3" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-orange-400">
    <div class="text-orange-400 font-bold text-lg w-8">03</div>
    <div>
      <div class="font-semibold">5 Pattern</div>
      <div class="text-xs opacity-60">Imperative & Declarative ile Design Patterns
      </div>
    </div>
  </div>
</div>

<div class="space-y-3">
  <div v-click="3" class="p-3 bg-orange-400/10 rounded-lg border border-orange-400/20">
    <div class="text-orange-400 font-bold mb-2 text-xs">Pattern'ler</div>
    <div class="space-y-1 text-xs opacity-80">
      <div>🎯 Strategy → Lambda & Functional Interfaces</div>
      <div>🎨 Decorator → Function Composition</div>
      <div>📋 Template Method → Higher-Order Functions</div>
      <div>🏗️ Builder → Records & Functional Builder</div>
      <div>👁️ Visitor → Sealed Classes & Pattern Matching</div>
    </div>
  </div>

  <div v-click="4" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-green-400">
    <div class="text-green-400 font-bold text-lg w-8">04</div>
    <div>
      <div class="font-semibold">Özet & Best Practices</div>
      <div class="text-xs opacity-60">Ne zaman OOP, ne zaman FP?</div>
    </div>
  </div>
</div>

</div>

<div v-click="5" class="mt-4 text-center">
  <div class="inline-block px-4 py-2 bg-gradient-to-r from-yellow-400/20 to-green-400/20 rounded-full border border-yellow-400/20 text-xs opacity-80">
    ⏱️ 25 dakika • Java 8–25 odaklı
  </div>
</div>

---

# Java 8 → Java 25

## Fonksiyonel Programlama Yolculuğu

<div class="grid grid-cols-3 gap-2 mt-2 px-1">

<div v-click="1" class="p-2 bg-gradient-to-br from-blue-400/20 to-blue-400/5 rounded-lg border border-blue-400/20">
  <div class="text-blue-400 text-sm font-bold mb-1">Java 8 <span class="text-xs opacity-60">(2014)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Lambda Expressions & Functional Interfaces</div>
  <div class="text-[11px] opacity-70 leading-tight">FP yaklaşımının başlangıcı</div>
</div>

<div v-click="2" class="p-2 bg-gradient-to-br from-blue-400/20 to-blue-400/5 rounded-lg border border-blue-400/20">
  <div class="text-blue-400 text-sm font-bold mb-1">Java 8 <span class="text-xs opacity-60">(2014)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Stream API & Method References</div>
  <div class="text-[11px] opacity-70 leading-tight">Deklaratif veri işleme</div>
</div>

<div v-click="3" class="p-2 bg-gradient-to-br from-blue-400/20 to-blue-400/5 rounded-lg border border-blue-400/20">
  <div class="text-blue-400 text-sm font-bold mb-1">Java 8 <span class="text-xs opacity-60">(2014)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Optional & Default Methods</div>
  <div class="text-[11px] opacity-70 leading-tight">Null safety ve davranış ekleme</div>
</div>

<div v-click="4" class="p-2 bg-gradient-to-br from-purple-400/20 to-purple-400/5 rounded-lg border border-purple-400/20">
  <div class="text-purple-400 text-sm font-bold mb-1">Java 10 <span class="text-xs opacity-60">(2018)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Local Variable Type Inference (var)</div>
  <div class="text-[11px] opacity-70 leading-tight">Lambda parametresinde var (Java 11)</div>
</div>

<div v-click="5" class="p-2 bg-gradient-to-br from-yellow-400/20 to-yellow-400/5 rounded-lg border border-yellow-400/20">
  <div class="text-yellow-400 text-sm font-bold mb-1">Java 14 <span class="text-xs opacity-60">(2020)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Records</div>
  <div class="text-[11px] opacity-70 leading-tight">Immutable data, daha az boilerplate</div>
</div>

<div v-click="6" class="p-2 bg-gradient-to-br from-yellow-400/20 to-yellow-400/5 rounded-lg border border-yellow-400/20">
  <div class="text-yellow-400 text-sm font-bold mb-1">Java 16 <span class="text-xs opacity-60">(2021)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Pattern Matching for instanceof</div>
  <div class="text-[11px] opacity-70 leading-tight">Type-safe cast işlemleri</div>
</div>

<div v-click="7" class="p-2 bg-gradient-to-br from-orange-400/20 to-orange-400/5 rounded-lg border border-orange-400/20">
  <div class="text-orange-400 text-sm font-bold mb-1">Java 17 <span class="text-xs opacity-60">(2021 LTS)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Sealed Classes & Interfaces</div>
  <div class="text-[11px] opacity-70 leading-tight">Kontrollü kalıtım, exhaustive matching</div>
</div>

<div v-click="8" class="p-2 bg-gradient-to-br from-red-400/20 to-red-400/5 rounded-lg border border-red-400/20">
  <div class="text-red-400 text-sm font-bold mb-1">Java 21 <span class="text-xs opacity-60">(2023 LTS)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Switch & Record Pattern Matching</div>
  <div class="text-[11px] opacity-70 leading-tight">Daha güçlü switch ve deconstruction</div>
</div>

<div v-click="9" class="p-2 bg-gradient-to-br from-green-400/20 to-green-400/5 rounded-lg border border-green-400/20">
  <div class="text-green-400 text-sm font-bold mb-1">Java 24/25 <span class="text-xs opacity-60">(2025)</span></div>
  <div class="text-xs font-semibold mb-1 leading-tight">Gatherers ve modern dil iyileştirmeleri</div>
  <div class="text-[11px] opacity-70 leading-tight">Stream pipeline'larında daha esnek toplama</div>
</div>

</div>

---

# Design Patterns

<div class="grid grid-cols-2 gap-6 mt-6">

<div v-click="1" class="p-5 bg-white/10 rounded-lg backdrop-blur">
  <div class="text-yellow-400 text-xl font-bold mb-3">Amaç</div>
  <div class="text-[15px] text-white/92 leading-relaxed">
    Tekrarlanan yazılım tasarım problemlerine <span class="text-yellow-400 font-semibold">kanıtlanmış çözümler</span> sunar. Kod kalitesini, bakımını ve yeniden kullanılabilirliğini artırır.
  </div>
  <div class="mt-3 text-sm text-white/85 leading-relaxed">
    <span class="text-yellow-300 font-semibold">Gang of Four (GoF)</span>:
    Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
  </div>
  <div class="mt-2 text-sm text-white/85 leading-relaxed">
    Kitap: <span class="text-blue-300 font-semibold">Design Patterns: Elements of Reusable Object-Oriented Software</span> (1994)
  </div>
  <div class="mt-3 flex justify-center">
    <img src="/images/gof-book.png" alt="Design Patterns GoF Book Cover" class="w-24 rounded-md border border-white/20 shadow-md" />
  </div>
</div>

<div v-click="2" class="p-5 bg-white/10 rounded-lg backdrop-blur">
  <div class="text-yellow-400 text-xl font-bold mb-3">Genel Bilgiler</div>
  <div class="text-[15px] text-white/92 leading-relaxed space-y-3">
    <div v-click="3"><span class="text-green-400 font-semibold">Creational:</span> Nesne oluşturma sorumluluğunu yönetir (Builder, Factory...)</div>
    <div v-click="4"><span class="text-blue-400 font-semibold">Structural:</span> Sınıf ve nesneleri bir araya getirip esnek bir yapı kurar (Decorator, Adapter...)</div>
    <div v-click="5"><span class="text-purple-400 font-semibold">Behavioral:</span> Nesneler arası iletişim ve davranış akışını düzenler (Strategy, Visitor...)</div>
    <div v-click="6" class="mt-2 p-3 bg-yellow-400/10 border border-yellow-400/20 rounded-lg">
      <div class="text-yellow-300 font-semibold mb-1">Modern Java ile Değişim</div>
      <div class="text-sm text-white/90 leading-relaxed">
        Pattern'ler aynı kalır; uygulama şekli modernleşir. Lambda, Stream API, records, sealed classes ve pattern matching ile
        daha az kod, daha net okunabilirlik ve daha kolay test elde edilir.
      </div>
    </div>
  </div>
</div>

</div>

---

# Klasik vs Modern Yaklaşım

<div class="grid grid-cols-2 gap-6 mt-6">

<div class="p-4 bg-red-400/10 rounded-lg border border-red-400/20">
  <div class="text-red-400 text-xl font-bold mb-3">Klasik OOP</div>
  <ul class="opacity-90 space-y-2 list-none text-sm">
    <li class="flex items-start gap-2"><span class="text-red-400 mt-1">▸</span> Çok sayıda interface ve concrete class</li>
    <li class="flex items-start gap-2"><span class="text-red-400 mt-1">▸</span> Verbose (uzun) kod yapısı</li>
    <li class="flex items-start gap-2"><span class="text-red-400 mt-1">▸</span> Boilerplate kod fazlalığı</li>
    <li class="flex items-start gap-2"><span class="text-red-400 mt-1">▸</span> Runtime'da sınırlı esneklik</li>
    <li class="flex items-start gap-2"><span class="text-red-400 mt-1">▸</span> Her davranış için yeni sınıf gereksinimi</li>
  </ul>
</div>

<div class="p-4 bg-green-400/10 rounded-lg border border-green-400/20">
  <div class="text-green-400 text-xl font-bold mb-3">Modern FP</div>
  <ul class="opacity-90 space-y-2 list-none text-sm">
    <li class="flex items-start gap-2"><span class="text-green-400 mt-1">▸</span> Lambda expressions & functional interfaces</li>
    <li class="flex items-start gap-2"><span class="text-green-400 mt-1">▸</span> Kısa ve öz kod yapısı</li>
    <li class="flex items-start gap-2"><span class="text-green-400 mt-1">▸</span> Minimal boilerplate</li>
    <li class="flex items-start gap-2"><span class="text-green-400 mt-1">▸</span> Yüksek esneklik ve composability</li>
    <li class="flex items-start gap-2"><span class="text-green-400 mt-1">▸</span> Fonksiyonlar birinci sınıf vatandaş</li>
  </ul>
</div>

</div>

<div class="mt-6 p-4 bg-blue-400/10 rounded-lg border border-blue-400/20">
  <div class="flex items-center justify-between">
    <div>
      <div class="text-blue-400 text-lg font-bold mb-1">Sonuç</div>
      <div class="opacity-90 text-sm">
        Modern yaklaşım ile <span class="text-yellow-400 font-bold">%60-80 daha az kod</span>,
        aynı veya daha fazla esneklik ve okunabilirlik kazanıyoruz!
      </div>
    </div>
    <div class="text-4xl opacity-30">→</div>
  </div>
</div>

---

# Sunumdaki Pattern'ler

<div class="grid grid-cols-5 gap-3 mt-8">

<div v-click="1" class="p-4 bg-gradient-to-b from-yellow-400/15 to-transparent rounded-lg border border-yellow-400/20 text-center">
  <div class="text-3xl mb-2">🎯</div>
  <div class="text-yellow-400 text-sm font-bold mb-1">Strategy</div>
  <div class="text-xs opacity-60 leading-tight">Lambda Expressions<br/>Functional Interfaces</div>
</div>

<div v-click="2" class="p-4 bg-gradient-to-b from-orange-400/15 to-transparent rounded-lg border border-orange-400/20 text-center">
  <div class="text-3xl mb-2">🎨</div>
  <div class="text-orange-400 text-sm font-bold mb-1">Decorator</div>
  <div class="text-xs opacity-60 leading-tight">Function Composition<br/>andThen()</div>
</div>

<div v-click="3" class="p-4 bg-gradient-to-b from-blue-400/15 to-transparent rounded-lg border border-blue-400/20 text-center">
  <div class="text-3xl mb-2">📋</div>
  <div class="text-blue-400 text-sm font-bold mb-1">Template Method</div>
  <div class="text-xs opacity-60 leading-tight">Higher-Order<br/>Functions</div>
</div>

<div v-click="4" class="p-4 bg-gradient-to-b from-purple-400/15 to-transparent rounded-lg border border-purple-400/20 text-center">
  <div class="text-3xl mb-2">🏗️</div>
  <div class="text-purple-400 text-sm font-bold mb-1">Builder</div>
  <div class="text-xs opacity-60 leading-tight">Records<br/>Functional Builder</div>
</div>

<div v-click="5" class="p-4 bg-gradient-to-b from-green-400/15 to-transparent rounded-lg border border-green-400/20 text-center">
  <div class="text-3xl mb-2">👁️</div>
  <div class="text-green-400 text-sm font-bold mb-1">Visitor</div>
  <div class="text-xs opacity-60 leading-tight">Sealed Classes<br/>Pattern Matching</div>
</div>

</div>

<div v-click="6" class="mt-8 p-4 bg-gradient-to-r from-yellow-400/10 via-orange-400/10 to-green-400/10 rounded-lg border border-yellow-400/15">
  <div class="text-center text-sm opacity-90">
    Her pattern için <span class="text-red-400 font-bold">solda klasik OOP</span> ve
    <span class="text-green-400 font-bold">sağda modern FP</span> yaklaşımını yan yana göreceğiz
  </div>
</div>

---
layout: section
---

# 🎯 Strategy Pattern

<div class="text-center mt-8">
  <div class="text-4xl font-bold bg-gradient-to-r from-yellow-400 to-orange-400 bg-clip-text text-transparent mb-4">
    Davranışı Runtime'da Değiştirme
  </div>
  <div class="text-xl opacity-80 max-w-2xl mx-auto">
    Strategy Pattern, bir algoritma ailesini ayrı sınıflar/fonksiyonlar olarak kapsüller
    ve çalışma anında uygun olanı seçmeyi sağlar.
    <span class="text-red-400">Klasik OOP</span> yaklaşımında interface + concrete class,
    <span class="text-green-400">modern FP</span> yaklaşımında ise davranış bir functional interface ile verilir
    (bu örnekte <code>Consumer&lt;BigDecimal&gt;</code> kullanıyoruz).
  </div>
</div>

---
layout: two-cols
layoutClass: gap-3
class: text-xs
---

## 🎯 <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Strategy</span>

```java
// classic/strategy/PaymentStrategy.java
public interface PaymentStrategy {
    void pay(BigDecimal amount);
}

// classic/strategy/PaymentService.java
public class PaymentService {
    private PaymentStrategy strategy;
    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void processPayment(BigDecimal amount) {
        strategy.pay(amount);
    }
}
```

```java
// classic/strategy/CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Kredi karti ile odeme: " + amount);
    }
}
```

```java
// classic/strategy/StrategyDemo.java
public static void main(String[] args) {
    BigDecimal amount = new BigDecimal("299.99");

    PaymentService service = new PaymentService(new CreditCardPayment());
    service.processPayment(amount);
}
```

<div class="mt-2 text-[11px] text-red-300 font-semibold">Neden onemli?</div>
<div class="mt-1 grid grid-cols-3 gap-2 text-[11px]">
  <div v-click="1" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Open/Closed</div>
    <div class="opacity-90">Yeni strateji eklerken mevcut kodu degistirmeyiz.</div>
  </div>
  <div v-click="2" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Composition</div>
    <div class="opacity-90">Davranisi kalitim yerine kompozisyonla degistiririz.</div>
  </div>
  <div v-click="3" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Program to Interface</div>
    <div class="opacity-90">Implementasyona degil, soyutlamaya bagli kaliriz.</div>
  </div>
</div>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Strategy</span>

```java
// java.util.function.Consumer
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

```java
// modern/strategy/PaymentService.java
public static Consumer<BigDecimal> creditCard(String cardNumber, String cardHolderName) {
    return amount -> {
        String masked = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("  Kredi karti ile odeme yapildi: " + amount + " TL");
        System.out.println("    Kart: " + masked + " | Sahibi: " + cardHolderName);
    };
}
public static void processPayment(Consumer<BigDecimal> strategy, BigDecimal amount) {
    strategy.accept(amount);
}
```

```java
// StrategyDemo.modernApproach(...)
Consumer<BigDecimal> cc = PaymentService.creditCard("...0366", "Ahmet Yilmaz");
PaymentService.processPayment(cc, amount);

Consumer<BigDecimal> bank = PaymentService.bankTransfer("TR...1326", "Garanti");
PaymentService.processPayment(bank, amount);
```

<div class="mt-4 grid grid-cols-3 gap-2 text-xs">
  <div v-click="4" class="p-2 rounded bg-blue-400/10 border border-blue-300/25">
    <div class="text-blue-300 font-semibold mb-1">Higher-Order Function</div>
    <div class="opacity-85">Davranışı parametre olarak geçirip runtime'da strateji seçiyoruz.</div>
  </div>
  <div v-click="5" class="p-2 rounded bg-green-400/10 border border-green-300/25">
    <div class="text-green-300 font-semibold mb-1">Functional Interface</div>
    <div class="opacity-85">Strategy'yi sınıf yerine fonksiyonel bir tip ile temsil ediyoruz.</div>
  </div>
  <div v-click="6" class="p-2 rounded bg-yellow-400/10 border border-yellow-300/25">
    <div class="text-yellow-300 font-semibold mb-1">Daha Az Boilerplate</div>
    <div class="opacity-85">Daha az sınıf, daha kısa kod, daha kolay bakım ve test.</div>
  </div>
</div>

---

# 🏗️ Builder Pattern

<div class="text-center mt-8">
  <div class="text-4xl font-bold bg-gradient-to-r from-purple-400 to-pink-400 bg-clip-text text-transparent mb-4">
    Records & Functional Builder
  </div>
  <div class="text-xl opacity-80 max-w-2xl mx-auto">
    Records ile <span class="text-purple-400">immutable data classes</span> ve
    <span class="text-green-400">Consumer-based functional builder</span> ile boilerplate dramatik şekilde azalıyor.
  </div>
</div>

---

layout: two-cols
layoutClass: gap-3
class: text-xs

---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Builder</span>

```java {1-4,6-15,17}
public class User {
    private String name, email;
    private int age;
    private User() {}

    public static class Builder {
        private String name, email;
        private int age;
        public Builder name(String n)
            { this.name = n; return this; }
        public Builder email(String e)
            { this.email = e; return this; }
        public Builder age(int a)
            { this.age = a; return this; }
        public User build() { /* field copy */ }
    }
    // + getter'lar, equals, hashCode, toString...
}
```

```java {1-3}
User user = new User.Builder()
    .name("Ümit").email("umit@javaday.com")
    .age(30).build();
```

<div class="mt-2 text-[11px] text-red-300 font-semibold">Neden onemli?</div>
<div class="mt-1 grid grid-cols-3 gap-2 text-[11px]">
  <div v-click="1" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Ayrim</div>
    <div class="opacity-90">Nesne kurulum adimlari yapidan ayrilir.</div>
  </div>
  <div v-click="2" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Okunabilirlik</div>
    <div class="opacity-90">Fluent API ile parametreler daha anlasilir olur.</div>
  </div>
  <div v-click="3" class="p-2 rounded bg-red-400/10 border border-red-300/25">
    <div class="font-semibold text-red-300 mb-1">Esneklik</div>
    <div class="opacity-90">Opsiyonel alanlar adim adim ve kontrollu kurulur.</div>
  </div>
</div>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Builder</span>

```java {2,4-7}
// equals, hashCode, toString otomatik!
public record User(String name, String email, int age) {

    public static User create(Consumer<Builder> cfg) {
        var b = new Builder();
        cfg.accept(b);
        return b.build();
    }

    public static class Builder {
        private String name, email;
        private int age;
        public Builder name(String n)
            { this.name = n; return this; }
        public Builder email(String e)
            { this.email = e; return this; }
        public Builder age(int a)
            { this.age = a; return this; }
        public User build()
            { return new User(name, email, age); }
    }
}
```

```java {1-4}
User user = User.create(b -> {
    b.name("Ümit"); b.email("umit@javaday.com");
    b.age(30);
});
```

<div class="mt-4 grid grid-cols-3 gap-2 text-xs">
  <div v-click="4" class="p-2 rounded bg-blue-400/10 border border-blue-300/25">
    <div class="text-blue-300 font-semibold mb-1">Record + Builder</div>
    <div class="opacity-85">Veri modeli immutable, kurulum esnek kalir.</div>
  </div>
  <div v-click="5" class="p-2 rounded bg-green-400/10 border border-green-300/25">
    <div class="text-green-300 font-semibold mb-1">Consumer ile Konfig</div>
    <div class="opacity-85">Konfigurasyonu fonksiyon olarak geciririz.</div>
  </div>
  <div v-click="6" class="p-2 rounded bg-yellow-400/10 border border-yellow-300/25">
    <div class="text-yellow-300 font-semibold mb-1">Daha Az Boilerplate</div>
    <div class="opacity-85">Tekrarlayan kod azalir, bakim kolaylasir.</div>
  </div>
</div>

---

# 🎨 Decorator Pattern

<div class="text-center mt-8">
  <div class="text-4xl font-bold bg-gradient-to-r from-orange-400 to-red-400 bg-clip-text text-transparent mb-4">
    Function Composition & andThen()
  </div>
  <div class="text-xl opacity-80 max-w-2xl mx-auto">
    Class hiyerarşisi yerine <span class="text-orange-400">fonksiyon kompozisyonu</span>.
    <code class="text-green-400">andThen()</code> zincirleriyle decorator'lar çok daha temiz bir forma kavuşuyor.
  </div>
</div>

---

layout: two-cols
layoutClass: gap-3
class: text-xs

---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Decorator</span>

<v-click>

```java {5-7,9-16}
public interface Coffee {
    String getDescription();
    double getCost();
}
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee c) { this.coffee = c; }
}
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee c) { super(c); }
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}
// + SugarDecorator, CreamDecorator...
```

</v-click>
<v-click>

```java {2-3}
// İç içe sarmalama
Coffee c = new SugarDecorator(
    new MilkDecorator(new SimpleCoffee()));
```

</v-click>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Decorator</span>

<v-click>

```java {1,2,6}
public record Coffee(String desc, double cost) {
    static UnaryOperator<Coffee> withMilk() {
        return c -> new Coffee(
            c.desc() + ", Milk", c.cost() + 1.5);
    }
    static UnaryOperator<Coffee> withSugar() {
        return c -> new Coffee(
            c.desc() + ", Sugar", c.cost() + 0.5);
    }
}
```

</v-click>
<v-click>

```java {3-5,10-12}
// andThen() ile fonksiyon kompozisyonu!
var base = new Coffee("Coffee", 5.0);
Coffee decorated = Coffee.withMilk()
    .andThen(Coffee.withSugar())
    .apply(base);
// → "Coffee, Milk, Sugar" — 7.0₺

// Dinamik decorator listesi
var extras = List.of(withMilk(), withSugar());
extras.stream()
    .reduce(identity(), (f, g) -> f.andThen(g))
    .apply(base);
```

</v-click>

---

# 📋 Template Method Pattern

<div class="text-center mt-8">
  <div class="text-4xl font-bold bg-gradient-to-r from-blue-400 to-cyan-400 bg-clip-text text-transparent mb-4">
    Higher-Order Functions
  </div>
  <div class="text-xl opacity-80 max-w-2xl mx-auto">
    Abstract class hiyerarşisinden sıyrılıp <span class="text-blue-400">higher-order function</span> yaklaşımıyla
    daha esnek bir mimariye evrilme. <span class="text-green-400">Composition over inheritance.</span>
  </div>
</div>

---

layout: two-cols
layoutClass: gap-3
class: text-xs

---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Template Method</span>

<v-click>

```java {1,2-5,7-9}
public abstract class DataProcessor {
    public final void process() { // sabit iskelet
        readData();
        transformData();
        saveData();
    }
    protected abstract void readData();
    protected abstract void transformData();
    protected abstract void saveData();
}
```

</v-click>
<v-click>

```java {2,10-11}
// Her varyasyon = yeni sınıf
public class CsvProcessor extends DataProcessor {
    protected void readData()
        { System.out.println("CSV okunuyor..."); }
    protected void transformData()
        { System.out.println("CSV dönüştürülüyor..."); }
    protected void saveData()
        { System.out.println("CSV kaydediliyor..."); }
}
DataProcessor p = new CsvProcessor();
p.process();
```

</v-click>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Template Method</span>

<v-click>

```java {2-4,12-14}
public class DataProcessor {
    private final Runnable read;
    private final Runnable transform;
    private final Runnable save;

    public DataProcessor(Runnable read,
            Runnable transform, Runnable save) {
        this.read = read;
        this.transform = transform;
        this.save = save;
    }
    public void process() {
        read.run(); transform.run(); save.run();
    }
}
```

</v-click>
<v-click>

```java {2-6}
// Lambda — sınıf yazmaya gerek yok!
var csv = new DataProcessor(
    () -> System.out.println("CSV okunuyor..."),
    () -> System.out.println("CSV dönüştürülüyor..."),
    () -> System.out.println("CSV kaydediliyor...")
);
csv.process();
```

</v-click>

---

## layout: section

# 👁️ Visitor Pattern

<div class="text-center mt-8">
  <div class="text-4xl font-bold bg-gradient-to-r from-green-400 to-emerald-400 bg-clip-text text-transparent mb-4">
    Sealed Classes & Pattern Matching
  </div>
  <div class="text-xl opacity-80 max-w-2xl mx-auto">
    Java 25'in <span class="text-green-400">sealed classes</span>, <span class="text-green-400">record patterns</span> ve
    gelişmiş <span class="text-green-400">pattern matching</span> özellikleri ile karmaşık visitor yapıları
    son derece sade bir hâle geliyor.
  </div>
</div>

---

layout: two-cols
layoutClass: gap-3
class: text-xs

---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Visitor</span>

<v-click>

```java {1-2,8-9,14-15}
public interface Shape {
    void accept(ShapeVisitor v);
}
public class Circle implements Shape {
    private final double radius;
    public Circle(double r) { this.radius = r; }
    public double getRadius() { return radius; }
    public void accept(ShapeVisitor v)
        { v.visitCircle(this); }
}
public class Rectangle implements Shape {
    private final double w, h;
    // constructor, getters...
    public void accept(ShapeVisitor v)
        { v.visitRectangle(this); }
}
```

</v-click>
<v-click>

```java {1-4,5}
public interface ShapeVisitor {
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
}
public class AreaCalc implements ShapeVisitor {
    public void visitCircle(Circle c) { /*...*/ }
    public void visitRectangle(Rectangle r) { /*...*/ }
}
```

</v-click>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Visitor</span>

<v-click>

```java {2-3,4-6}
// Sealed + Records — hepsi bu!
public sealed interface Shape
    permits Circle, Rectangle {}
public record Circle(double r) implements Shape {}
public record Rectangle(double w, double h)
    implements Shape {}
```

</v-click>
<v-click>

```java {3-6,11-15}
// Pattern matching — visitor'a gerek yok!
static double area(Shape shape) {
    return switch (shape) {
        case Circle c    -> Math.PI * c.r() * c.r();
        case Rectangle r -> r.w() * r.h();
    }; // exhaustive! Eksik case = derleme hatası
}

// Record patterns (Java 21+)
static String describe(Shape shape) {
    return switch (shape) {
        case Circle(var r) ->
            "Yarıçapı %s daire".formatted(r);
        case Rectangle(var w, var h) ->
            "%sx%s dikdörtgen".formatted(w, h);
    };
}
```

</v-click>

---

layout: default
class: text-sm

---

# Özet: Ne Öğrendik?

<div class="grid grid-cols-[1fr_1.5fr] gap-4 mt-4">

<div class="space-y-3">
  <div v-click="1" class="p-3 bg-gradient-to-r from-yellow-400/15 to-transparent rounded-lg border border-yellow-400/20">
    <div class="text-yellow-400 font-bold mb-1 text-sm">Strategy</div>
    <div class="text-xs opacity-70">Interface + class → Lambda ifadesi</div>
  </div>
  <div v-click="2" class="p-3 bg-gradient-to-r from-orange-400/15 to-transparent rounded-lg border border-orange-400/20">
    <div class="text-orange-400 font-bold mb-1 text-sm">Decorator</div>
    <div class="text-xs opacity-70">Class hiyerarşisi → andThen() kompozisyonu</div>
  </div>
  <div v-click="3" class="p-3 bg-gradient-to-r from-blue-400/15 to-transparent rounded-lg border border-blue-400/20">
    <div class="text-blue-400 font-bold mb-1 text-sm">Template Method</div>
    <div class="text-xs opacity-70">Abstract class → Higher-order functions</div>
  </div>
  <div v-click="4" class="p-3 bg-gradient-to-r from-purple-400/15 to-transparent rounded-lg border border-purple-400/20">
    <div class="text-purple-400 font-bold mb-1 text-sm">Builder</div>
    <div class="text-xs opacity-70">Verbose builder → Record + Consumer&lt;Builder&gt;</div>
  </div>
  <div v-click="5" class="p-3 bg-gradient-to-r from-green-400/15 to-transparent rounded-lg border border-green-400/20">
    <div class="text-green-400 font-bold mb-1 text-sm">Visitor</div>
    <div class="text-xs opacity-70">Double dispatch → Sealed classes + pattern matching</div>
  </div>
</div>

<div class="space-y-3">
  <div v-click="6" class="p-4 bg-green-400/10 rounded-lg border border-green-400/20">
    <div class="text-green-400 text-sm font-bold mb-2">Modern Java'nın Kazanımları</div>
    <ul class="text-xs opacity-80 space-y-1 list-none">
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> %60-80 daha az kod</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Daha yüksek okunabilirlik</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Daha kolay test edilebilirlik</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Yüksek composability</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Type-safety (exhaustive matching)</li>
    </ul>
  </div>

  <div v-click="7" class="p-4 bg-yellow-400/10 rounded-lg border border-yellow-400/20">
    <div class="text-yellow-400 text-sm font-bold mb-2">Kullanılan Java Özellikleri</div>
    <div class="grid grid-cols-2 gap-1 text-xs opacity-80">
      <div>• Lambda Expressions</div>
      <div>• Functional Interfaces</div>
      <div>• Stream API</div>
      <div>• Method References</div>
      <div>• Records</div>
      <div>• Sealed Classes</div>
      <div>• Pattern Matching</div>
      <div>• Record Patterns</div>
    </div>
  </div>
</div>

</div>

---

layout: default
class: text-sm

---

# Ne Zaman Hangi Yaklaşımı Tercih Etmeliyiz?

<div class="grid grid-cols-2 gap-4 mt-4">

<div class="p-4 bg-red-400/10 rounded-lg border border-red-400/20">
  <div class="text-red-400 text-lg font-bold mb-3">Klasik OOP Tercih Edilmeli</div>
  <div class="text-xs opacity-90 space-y-2">
    <ul class="list-none space-y-2">
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Karmaşık state yönetimi gerektiğinde</li>
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Çok sayıda field ve method içeren sınıflar</li>
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Inheritance hiyerarşisi kritik olduğunda</li>
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Legacy kod tabanı ile uyumluluk</li>
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Framework'ler class yapısı bekliyorsa</li>
      <li class="flex items-start gap-2"><span class="text-red-400">▸</span> Ekip FP deneyimi sınırlıysa</li>
    </ul>
  </div>
</div>

<div class="p-4 bg-green-400/10 rounded-lg border border-green-400/20">
  <div class="text-green-400 text-lg font-bold mb-3">Modern FP Tercih Edilmeli</div>
  <div class="text-xs opacity-90 space-y-2">
    <ul class="list-none space-y-2">
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Basit, tek sorumluluklu davranışlar</li>
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Yüksek composability gerektiğinde</li>
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Runtime'da dinamik davranış değişikliği</li>
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Stream processing ve data transformation</li>
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Event-driven mimariler</li>
      <li class="flex items-start gap-2"><span class="text-green-400">▸</span> Test edilebilirlik öncelikli olduğunda</li>
    </ul>
  </div>
</div>

</div>

<div class="mt-4 p-4 bg-blue-400/10 rounded-lg border border-blue-400/20">
  <div class="text-blue-400 text-lg font-bold mb-2">Hibrit Yaklaşım — Gerçek Dünyada En İyi Pratik</div>
  <div class="text-xs opacity-90">
    Her iki yaklaşımı birlikte kullanın. Karmaşık domain logic için <span class="text-red-400 font-bold">OOP</span>,
    data processing ve transformation için <span class="text-green-400 font-bold">FP</span>.
    Modern Java her ikisini de birinci sınıf destekler. Önemli olan <span class="text-yellow-400 font-bold">doğru aracı doğru yerde kullanmak</span>.
  </div>
</div>

---

layout: default
class: text-sm

---

# Best Practices & Öneriler

<div class="grid grid-cols-2 gap-3 mt-4">

<div v-click="1" class="p-3 bg-white/5 rounded-lg border border-white/10">
  <div class="text-yellow-400 font-bold mb-2 text-sm">Kod Organizasyonu</div>
  <ul class="text-xs opacity-80 space-y-1 list-none">
    <li class="flex gap-2"><span class="text-yellow-400">▸</span> Küçük, tek amaçlı fonksiyonlar yazın</li>
    <li class="flex gap-2"><span class="text-yellow-400">▸</span> Method references tercih edin</li>
    <li class="flex gap-2"><span class="text-yellow-400">▸</span> Records ile immutable data modelleri</li>
    <li class="flex gap-2"><span class="text-yellow-400">▸</span> Sealed classes ile kontrollü hiyerarşi</li>
  </ul>
</div>

<div v-click="2" class="p-3 bg-white/5 rounded-lg border border-white/10">
  <div class="text-blue-400 font-bold mb-2 text-sm">Performans Notları</div>
  <ul class="text-xs opacity-80 space-y-1 list-none">
    <li class="flex gap-2"><span class="text-blue-400">▸</span> Lambda'lar JVM tarafından optimize edilir (invokedynamic)</li>
    <li class="flex gap-2"><span class="text-blue-400">▸</span> Stream'ler lazy evaluation kullanır</li>
    <li class="flex gap-2"><span class="text-blue-400">▸</span> Method references bazen daha verimli</li>
    <li class="flex gap-2"><span class="text-blue-400">▸</span> Pattern matching switch, if-else zincirinden hızlı</li>
  </ul>
</div>

<div v-click="3" class="p-3 bg-white/5 rounded-lg border border-white/10">
  <div class="text-green-400 font-bold mb-2 text-sm">Okunabilirlik & Kod Review</div>
  <ul class="text-xs opacity-80 space-y-1 list-none">
    <li class="flex gap-2"><span class="text-green-400">▸</span> Karmaşık lambda'ları method'a çıkarın</li>
    <li class="flex gap-2"><span class="text-green-400">▸</span> Anlamlı değişken isimleri kullanın</li>
    <li class="flex gap-2"><span class="text-green-400">▸</span> Chain'leri makul uzunlukta tutun (3-4 seviye)</li>
    <li class="flex gap-2"><span class="text-green-400">▸</span> Ekip kararlarını style guide'a yansıtın</li>
  </ul>
</div>

<div v-click="4" class="p-3 bg-white/5 rounded-lg border border-white/10">
  <div class="text-purple-400 font-bold mb-2 text-sm">Legacy Kod Modernizasyonu</div>
  <ul class="text-xs opacity-80 space-y-1 list-none">
    <li class="flex gap-2"><span class="text-purple-400">▸</span> Adım adım geçiş yapın, big-bang değil</li>
    <li class="flex gap-2"><span class="text-purple-400">▸</span> Yeni kodda modern yaklaşım, eski koda dokunmayın</li>
    <li class="flex gap-2"><span class="text-purple-400">▸</span> Test coverage'ı artırarak modernize edin</li>
    <li class="flex gap-2"><span class="text-purple-400">▸</span> Ekibi kademeli olarak FP'ye alıştırın</li>
  </ul>
</div>

</div>

<div v-click="5" class="mt-3 p-3 bg-gradient-to-r from-yellow-400/10 via-orange-400/10 to-green-400/10 rounded-lg border border-yellow-400/15">
  <div class="text-center text-xs opacity-80">
    Design pattern'ler hâlâ güncel ve değerli. Önemli olan <span class="text-yellow-400 font-bold">modern Java'nın sunduğu araçları</span> 
    tanıyıp, <span class="text-green-400 font-bold">projenin ve ekibin ihtiyaçlarına göre</span> doğru yaklaşımı seçmektir.
  </div>
</div>

---

layout: center
class: text-center

---

<div class="flex flex-col items-center justify-center">
  <div class="text-5xl font-bold bg-gradient-to-r from-yellow-400 via-orange-400 to-red-400 bg-clip-text text-transparent mb-6">
    Teşekkürler!
  </div>

  <div class="text-2xl opacity-70 mb-8 max-w-xl">
    Modern Java ile Design Patterns'ın Fonksiyonel Evrimi
  </div>

  <div class="grid grid-cols-3 gap-4 mb-8">
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">GitHub</div>
      <div class="text-yellow-400 font-mono text-xs">github.com/umiitkose</div>
    </div>
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">YouTube</div>
      <div class="text-yellow-400 font-mono text-xs">Design Patterns Serisi</div>
    </div>
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">Örnek Kodlar</div>
      <div class="text-yellow-400 font-mono text-xs">functional-programming-and-streams</div>
    </div>
  </div>

  <div class="text-3xl opacity-80">
    Sorularınız?
  </div>
</div>
