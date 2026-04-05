---
theme: default
background: '#0d1117'
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

<!--
"Herkese Günaydın, Javaday İstanbulda bolca javayı konuştuğumuz bir günde sırada modern java ile design patternlerin fonksiyonel evrimi adında benim yapacağım sunuma hoşgeldiniz.
-->

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
    <div class="text-xs opacity-75 mt-1">Software Developer</div>
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
    <div class="p-3 rounded-xl bg-white/8 border border-white/15">
      <div class="text-xs uppercase tracking-wide opacity-60 mb-2">Repo QR</div>
      <div class="flex items-center gap-3">
        <img src="/images/github-repo-qr.png" alt="GitHub repository QR code" class="w-20 h-20 rounded bg-white p-1" />
        <div class="text-xs opacity-80 leading-relaxed">
          Sunumdaki tum kodlar:
          <div class="text-yellow-400 font-mono break-all">github.com/umiitkose/javadayistanbul-functional-evolution-of-design-patterns-with-modern-Java</div>
        </div>
      </div>
    </div>
  </div>
</div>

<!--
Ümit KÖSE, @Türksat. Senior Software Developer. Sosyal medya hesapları umiitkose. Sunumla ilgili herşeyin olduğu repoya QR'dan ulaşabilirsiniz.
-->

---

# Gündem

<div class="grid grid-cols-2 gap-4 mt-6">

<div class="space-y-3">
  <div v-click="1" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-yellow-400">
    <div class="text-yellow-400 font-bold text-lg w-8">01</div>
    <div>
      <div class="font-semibold">Java 8 - Java 26</div>
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
      <div class="font-semibold">4 Pattern</div>
      <div class="text-xs opacity-60">Klasik OOP ↔ modern Java (records, lambda, kompozisyon)</div>
    </div>
  </div>
</div>

<div class="space-y-3">
  <div v-click="3" class="p-3 bg-orange-400/10 rounded-lg border border-orange-400/20">
    <div class="text-orange-400 font-bold mb-2 text-xs">Pattern'ler</div>
    <div class="space-y-1 text-xs opacity-80">
      <div>🏗️ Builder → Immutability & Records</div>
      <div>🎯 Strategy → Lambda & Functional Interfaces</div>
      <div>🎨 Decorator → Function Composition</div>
      <div>📋 Template Method → Higher-Order Functions</div>
    </div>
  </div>

  <div v-click="4" class="flex items-center gap-3 p-3 bg-white/5 rounded-lg border-l-4 border-green-400">
    <div class="text-green-400 font-bold text-lg w-8">04</div>
    <div>
      <div class="font-semibold">Genel Değerlendirme</div>
      <div class="text-xs opacity-60">Ne zaman OOP, ne zaman FP?</div>
    </div>
  </div>
</div>

</div>

<div v-click="5" class="mt-4 text-center">
  <div class="inline-block px-4 py-2 bg-gradient-to-r from-yellow-400/20 to-green-400/20 rounded-full border border-yellow-400/20 text-xs opacity-80">
    ⏱️ 25 dakika • Java 8–26 odaklı
  </div>
</div>

<!--
sunumla iligli genel bilgiler, çok detaya girme.
-->

---
layout: default
class: '!pt-6 !pb-3 text-[10px] leading-tight'
---

<div class="max-w-[100%] mx-auto space-y-1">

<div class="flex flex-col sm:flex-row sm:items-end sm:justify-between gap-0.5 mb-0.5">
<div>
<div class="text-base sm:text-lg font-bold tracking-tight">Java 8 → Java 26</div>
<div class="text-[10px] text-white/55 font-medium">Fonksiyonel programlama yolculuğu — özet harita</div>
</div>
<div class="flex flex-wrap gap-x-2 gap-y-0.5 text-[8px] text-white/58">
<span class="inline-flex items-center gap-1"><span class="w-1.5 h-1.5 rounded-full bg-emerald-400 shrink-0"></span> FP altyapısı</span>
<span class="inline-flex items-center gap-1"><span class="w-1.5 h-1.5 rounded-full bg-sky-400 shrink-0"></span> Veri modelleme</span>
<span class="inline-flex items-center gap-1"><span class="w-1.5 h-1.5 rounded-full bg-violet-400 shrink-0"></span> Tip &amp; pattern matching</span>
<span class="inline-flex items-center gap-1"><span class="w-1.5 h-1.5 rounded-full bg-amber-400 shrink-0"></span> Son sürümler</span>
</div>
</div>

<div v-click="1" class="space-y-1">
<div class="flex items-center gap-2 my-1">
<div class="h-px flex-1 bg-gradient-to-r from-transparent to-white/20"></div>
<span class="text-[8px] font-bold uppercase tracking-widest text-emerald-300/90 whitespace-nowrap">2014 — Kırılma noktası</span>
<div class="h-px flex-1 bg-gradient-to-l from-transparent to-white/20"></div>
</div>
<div class="grid grid-cols-3 gap-1">
<div class="rounded-md border border-emerald-400/35 bg-emerald-950/40 p-1.5 min-h-0">
<div class="text-[8px] text-emerald-300/85 font-semibold mb-0.5">Java 8 · 2014</div>
<div class="text-[10px] font-bold text-emerald-100 leading-tight mb-0.5">Lambda + Functional Interfaces</div>
<p class="text-[9px] text-white/72 leading-tight">Davranış birinci sınıf; <code class="text-[8px] bg-white/10 px-0.5 rounded">Consumer</code>, <code class="text-[8px] bg-white/10 px-0.5 rounded">Function</code>, <code class="text-[8px] bg-white/10 px-0.5 rounded">Predicate</code>.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-emerald-500/25 text-emerald-200 border border-emerald-400/20">FP kapısı açıldı</span></div>
</div>
<div class="rounded-md border border-emerald-400/35 bg-emerald-950/40 p-1.5 min-h-0">
<div class="text-[8px] text-emerald-300/85 font-semibold mb-0.5">Java 8 · 2014</div>
<div class="text-[10px] font-bold text-emerald-100 leading-tight mb-0.5">Stream API</div>
<p class="text-[9px] text-white/72 leading-tight"><code class="text-[8px] bg-white/10 px-0.5 rounded">filter</code>→<code class="text-[8px] bg-white/10 px-0.5 rounded">map</code>→<code class="text-[8px] bg-white/10 px-0.5 rounded">reduce</code>; lazy boru hatları.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-emerald-500/25 text-emerald-200 border border-emerald-400/20">Iterator → Stream</span></div>
</div>
<div class="rounded-md border border-emerald-400/35 bg-emerald-950/40 p-1.5 min-h-0">
<div class="text-[8px] text-emerald-300/85 font-semibold mb-0.5">Java 8 · 2014</div>
<div class="text-[10px] font-bold text-emerald-100 leading-tight mb-0.5">Optional + Default Methods</div>
<p class="text-[9px] text-white/72 leading-tight">Null güvenliği; arayüzlere davranış — API’yi kırmadan evrim.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-emerald-500/25 text-emerald-200 border border-emerald-400/20">API evrimi</span></div>
</div>
</div>
</div>

<div v-click="2" class="space-y-1">
<div class="flex items-center gap-2 my-1">
<div class="h-px flex-1 bg-gradient-to-r from-transparent to-white/20"></div>
<span class="text-[8px] font-bold uppercase tracking-widest text-sky-300/90 whitespace-nowrap text-center">2018–2023 — Veri &amp; tip sistemi</span>
<div class="h-px flex-1 bg-gradient-to-l from-transparent to-white/20"></div>
</div>
<div class="grid grid-cols-3 gap-1">
<div class="rounded-md border border-sky-400/35 bg-sky-950/35 p-1.5 min-h-0">
<div class="text-[8px] text-sky-300/85 font-semibold mb-0.5">Records · 14→16</div>
<div class="text-[10px] font-bold text-sky-100 leading-tight mb-0.5">Records</div>
<p class="text-[9px] text-white/72 leading-tight">Değişmez taşıyıcılar; <code class="text-[8px] bg-white/10 px-0.5 rounded">equals/hashCode/toString</code>.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-sky-500/25 text-sky-200 border border-sky-400/20">Veri ≠ davranış</span></div>
</div>
<div class="rounded-md border border-violet-400/35 bg-violet-950/35 p-1.5 min-h-0">
<div class="text-[8px] text-violet-300/85 font-semibold mb-0.5">Sealed · 17 LTS</div>
<div class="text-[10px] font-bold text-violet-100 leading-tight mb-0.5">Sealed Classes</div>
<p class="text-[9px] text-white/72 leading-tight">Kontrollü hiyerarşi; derleyici tüm alt tipleri bilir.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-violet-500/25 text-violet-200 border border-violet-400/20">ADT</span></div>
</div>
<div class="rounded-md border border-violet-400/35 bg-violet-950/35 p-1.5 min-h-0">
<div class="text-[8px] text-violet-300/85 font-semibold mb-0.5">Java 21 LTS</div>
<div class="text-[10px] font-bold text-violet-100 leading-tight mb-0.5">Switch + record patterns</div>
<p class="text-[9px] text-white/72 leading-tight">Eksiksiz dallanma; okunabilir <code class="text-[8px] bg-white/10 px-0.5 rounded">switch</code>.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-violet-500/25 text-violet-200 border border-violet-400/20">Pattern matching</span></div>
</div>
</div>
</div>

<div v-click="3" class="space-y-1">
<div class="flex items-center gap-2 my-1">
<div class="h-px flex-1 bg-gradient-to-r from-transparent to-white/20"></div>
<span class="text-[8px] font-bold uppercase tracking-widest text-amber-300/90 whitespace-nowrap text-center">Java 24–26 · FP ile öne çıkanlar</span>
<div class="h-px flex-1 bg-gradient-to-l from-transparent to-white/20"></div>
</div>
<div class="grid grid-cols-2 gap-1.5 max-w-3xl mx-auto">
<div class="rounded-md border border-emerald-400/30 bg-emerald-950/25 p-1.5 min-h-0">
<div class="text-[8px] text-emerald-200/80 font-mono mb-0.5">JEP 485 · Java 24</div>
<div class="text-[10px] font-bold text-emerald-100 leading-tight">Stream Gatherers</div>
<p class="text-[9px] text-white/65 mt-0.5 leading-tight">Stream’e özelleştirilebilir ara <code class="text-[8px] bg-white/10 px-0.5 rounded">gather</code> adımları — <code class="text-[8px] bg-white/10 px-0.5 rounded">map/filter</code> ötesi FP tarzı boru hatları.</p>
<div class="mt-1"><span class="text-[7px] px-1 py-0.5 rounded bg-emerald-500/25 text-emerald-200 border border-emerald-400/20">Stream + kompozisyon</span></div>
</div>
<div class="rounded-md border border-amber-400/30 bg-amber-950/25 p-1.5 min-h-0">
<div class="text-[8px] text-amber-200/80 font-mono mb-0.5">JEP 500 · Java 26</div>
<div class="text-[10px] font-bold text-amber-100 leading-tight">Make final mean final</div>
<p class="text-[9px] text-white/65 mt-0.5 leading-tight">Final alanlar reflection’a karşı gerçekten değişmez.</p>
</div>
</div>
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
    <div v-click="5"><span class="text-purple-400 font-semibold">Behavioral:</span> Nesneler arası iletişim ve davranış akışını düzenler (Strategy, State...)</div>
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

# Sunumdaki Pattern'ler

<div class="grid grid-cols-4 gap-3 mt-8">

<div v-click="1" class="p-4 bg-gradient-to-b from-purple-400/15 to-transparent rounded-lg border border-purple-400/20 text-center">
  <div class="text-3xl mb-2">🏗️</div>
  <div class="text-purple-400 text-sm font-bold mb-1">Builder</div>
  <div class="text-xs opacity-60 leading-tight">Immutability<br/>Records</div>
</div>

<div v-click="2" class="p-4 bg-gradient-to-b from-yellow-400/15 to-transparent rounded-lg border border-yellow-400/20 text-center">
  <div class="text-3xl mb-2">🎯</div>
  <div class="text-yellow-400 text-sm font-bold mb-1">Strategy</div>
  <div class="text-xs opacity-60 leading-tight">Lambda Expressions<br/>Functional Interfaces</div>
</div>

<div v-click="3" class="p-4 bg-gradient-to-b from-orange-400/15 to-transparent rounded-lg border border-orange-400/20 text-center">
  <div class="text-3xl mb-2">🎨</div>
  <div class="text-orange-400 text-sm font-bold mb-1">Decorator</div>
  <div class="text-xs opacity-60 leading-tight">Function Composition<br/>andThen()</div>
</div>

<div v-click="4" class="p-4 bg-gradient-to-b from-blue-400/15 to-transparent rounded-lg border border-blue-400/20 text-center">
  <div class="text-3xl mb-2">📋</div>
  <div class="text-blue-400 text-sm font-bold mb-1">Template Method</div>
  <div class="text-xs opacity-60 leading-tight">Higher-Order<br/>Functions</div>
</div>

</div>

<div v-click="5" class="mt-8 p-4 bg-gradient-to-r from-yellow-400/10 via-orange-400/10 to-green-400/10 rounded-lg border border-yellow-400/15">
  <div class="text-center text-sm opacity-90">
    Her pattern için <span class="text-red-400 font-bold">solda klasik OOP</span> ve
    <span class="text-green-400 font-bold">sağda modern FP</span> yaklaşımını yan yana göreceğiz
  </div>
</div>

<!--
Istege bagli: FP vurgulari (pure functions, immutability, okunabilirlik) ayri slayt.
-->

---
class: builder-pattern-slide-1
---

# 🏗️ Builder Pattern — <span class="text-red-300">klasik OOP</span>

<div class="text-base opacity-90 max-w-5xl leading-snug">
  <span class="text-purple-400 font-semibold">Tanım:</span> Karmaşık nesneyi <em>adım adım</em> kurup <code>build()</code> ile tek seferde doğrulayan creational pattern. Telescoping constructor yerine okunabilir fluent API.
</div>

<div class="mt-3 w-full max-w-5xl mx-auto px-2 sm:px-0">
  <div class="rounded-lg bg-red-400/10 border border-red-300/25 px-4 py-3 text-sm w-full">
    <div class="text-red-300 font-semibold mb-1">Telescoping</div>
    <pre class="text-sm leading-snug opacity-90 m-0 p-0 font-mono overflow-x-auto"><code>new Thing("a","b", null, null, BigDecimal.ZERO);</code></pre>
  </div>
</div>

<div v-click="1" class="mt-4 flex justify-center px-2">
  <object
    :data="`/images/builder_pattern_oop_vs_fp.svg?play=${$slidev.nav.currentPage}-${$slidev.nav.clicks}`"
    type="image/svg+xml"
    title="Builder Pattern OOP ve FP karsilastirma diyagrami"
    class="block h-[min(40vh,320px)] w-auto max-w-[min(90vw,720px)] rounded-lg border border-white/10 bg-transparent"
  ></object>
</div>

<div class="mt-4 grid grid-cols-3 gap-3 text-xs max-w-5xl">
  <div class="p-3 rounded-lg bg-red-400/10 border border-red-300/20">
    <div class="font-semibold text-red-300 mb-1">Mutable ara durum</div>
    <div class="opacity-90 leading-snug">Builder’da fluent setter’lar (<code>requestedQuantity</code> vb.) ara alanları değiştirir.</div>
  </div>
  <div class="p-3 rounded-lg bg-red-400/10 border border-red-300/20">
    <div class="font-semibold text-red-300 mb-1">İki katman</div>
    <div class="opacity-90 leading-snug">Ürün immutable olsa da <em>kurulum süreci</em> mutasyon içerir.</div>
  </div>
  <div class="p-3 rounded-lg bg-red-400/10 border border-red-300/20">
    <div class="font-semibold text-red-300 mb-1">Uzun build()</div>
    <div class="opacity-90 leading-snug">Çok alanda doğrulama tek metotta şişebilir.</div>
  </div>
</div>

<!--
Sonraki slaytta kod — bu slaytta sadece problem + diyagram + mesaj.
-->

---
layout: two-cols
layoutClass: gap-3 items-start
class: builder-pattern-code builder-pattern-two-cols
---

<style>
.builder-pattern-two-cols .slidev-code {
  font-size: 12px !important;
  line-height: 1.36 !important;
  padding: 0.4rem 0.5rem !important;
}
.builder-pattern-two-cols h2 {
  font-size: 0.95rem !important;
  line-height: 1.2 !important;
  margin: 0 0 0.35rem 0 !important;
}
</style>

## <span class="text-red-400">Klasik OOP</span> — `StockReservationClassic`

<v-click at="1">

```java
// classic/builder/StockReservationClassic.java — yapı özeti
public final class StockReservationClassic {

    // private final alanlar (~20)

    private StockReservationClassic(Builder builder) {
        // builder alanlarından atama
    }

    // getter'lar …
    @Override public String toString() { /* … */ }
    @Override public boolean equals(Object o) { /* reservationId */ }
    @Override public int hashCode() { return Objects.hash(reservationId); }

    public static class Builder {
        private final String reservationId;
        private final String warehouseId;
        private final String sku;
        private int requestedQuantity;
        // reservedQuantity, unitCost, discountPercent, vatPercent, currencyCode, aisleCode, binCode, priorityBand
        // grossWeightKg, netWeightKg, bestBeforeDate, batchNumber, lotSerial, hazmatCategory, originCountryCode, internalNotes

        public Builder(String reservationId, String warehouseId, String sku) {
            this.reservationId = reservationId;
            this.warehouseId = warehouseId;
            this.sku = sku;
        }

        public Builder requestedQuantity(int requestedQuantity) {
            this.requestedQuantity = requestedQuantity;
            return this;
        }
        // … fluent setter'lar

        public StockReservationClassic build() {
            // validasyonlar — çoğu kural bu metotta
            if (reservationId == null || reservationId.isBlank())
                throw new IllegalStateException("Rezervasyon ID zorunludur");
            // …
            return new StockReservationClassic(this);
        }
    }
}
```

</v-click>

::right::

## <span class="text-green-400">Modern</span> — record kompozisyonu

<v-click at="2">

```java
// modern/builder/StockReservation.java — aggregate
public record StockReservation(
    ReservationIdentity identity,
    QuantityAllocation quantities,
    PricingTerms pricing,
    StorageSlot storageSlot,
    PhysicalWeights physicalWeights,
    LotTraceability traceability,
    ComplianceNotes compliance
) {}
```

</v-click>
<v-click at="3">

```java
// Alt tiplerde validasyon (compact constructor) — örnek: ReservationIdentity
public record ReservationIdentity(String reservationId, String warehouseId, String sku) {
    public ReservationIdentity {
        if (reservationId == null || reservationId.isBlank())
            throw new IllegalArgumentException("Rezervasyon ID zorunludur");
        // warehouseId, sku …
    }
}
```

</v-click>
<v-click at="4">

```java
// Kullanım: factory / defaults ile birleştirme
var res = new StockReservation(
    new ReservationIdentity("R-1", "WH-1", "SKU-A"),
    new QuantityAllocation(100, 80),
    new PricingTerms(new BigDecimal("10"), BigDecimal.ZERO, BigDecimal.ZERO, "TRY"),
    StorageSlot.defaults(),
    PhysicalWeights.none(),
    LotTraceability.empty(),
    ComplianceNotes.empty()
);
```

</v-click>

<div v-click="5" class="text-[10px] opacity-80 leading-tight mt-1">
  Özet: doğrulama <code>build()</code> yığınında değil; küçük record’ların ctor’unda. Aggregate yalnızca kompozisyon.
</div>

<div v-click="6" class="mt-2 p-1.5 rounded bg-green-400/10 border border-green-300/20 text-[10px]">
  <span class="text-green-300 font-semibold">Immutability:</span> alanlar sabit; eksik opsiyoneller <code>defaults()</code> / <code>empty()</code> ile doldurulur.
</div>

<div v-click="7" class="mt-1 p-1.5 rounded bg-sky-400/10 border border-sky-300/20 text-[10px]">
  <span class="text-sky-300 font-semibold">Parçalı kurallar:</span> fiyat, miktar, uyumluluk ayrı dosyalarda test edilebilir; tek dev <code>build()</code> bloğu şişmez.
</div>

<!--
Konusmaci akisi (7 tik):
1) Klasik: urun + ic Builder, validasyon build()'te toplanir.
2) Modern: ayni domain tek record ama 8 parca — "nesne" kompozisyon.
3) Ornek alt tip: compact ctor ile kural nerede yasiyor goster.
4) Tam kurulum: fabrikalarla opsiyonelleri kapat.
5) Tek cumle mesaj.
6-7) Iki vurgu: immutable + kurallarin dagilimi. "Record her yerde Builder degildir"i sozlu soyle.
-->

---

# 🎯 Strategy Pattern

<div class="mt-6 max-w-4xl">
  <div class="text-lg opacity-85 leading-relaxed">
    <span class="text-yellow-400 font-semibold">Tanım:</span>
    Strategy Pattern, bir algoritma ailesini ayrı sınıflar/fonksiyonlar olarak kapsüller
    ve çalışma anında uygun olanı seçmeyi sağlar.
  </div>
</div>

<div class="mt-4 flex justify-center">
  <object
    :data="`/images/strategy_pattern_oop_vs_fp.svg?play=${$slidev.nav.currentPage}-${$slidev.nav.clicks}`"
    type="image/svg+xml"
    alt="Strategy Pattern OOP ve FP karsilastirma diyagrami"
    class="h-[min(46vh,320px)] w-auto max-w-[92%] rounded-lg border border-white/10 bg-transparent"
  ></object>
</div>

<!--
Konusmaci Notu:
- Bu slaytta once "runtime'da degistirme" fikrini ver, sonra diyagrami soldan saga oku.
- Sol taraf: yeni odeme tipi -> yeni sinif, implementasyon ve deploy maliyeti.
- Sag taraf: ayni akis Consumer ve lambda ile sinif acmadan degisiyor.
- Mesaj: Pattern ayni, modern Java ile uygulama daha composable ve hizli evriliyor.
-->

---
layout: two-cols
layoutClass: gap-3
class: text-xs
---

## 🎯 <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Strategy</span>

<v-click at="1">

```java
// classic/strategy/PaymentStrategy.java
public interface PaymentStrategy {
    void pay(BigDecimal amount);
}
```

</v-click>
<v-click at="2">

```java
// classic/strategy/PaymentService.java
public class PaymentService {
    private PaymentStrategy strategy;
    public PaymentService(PaymentStrategy strategy) { this.strategy = strategy; }
    public void processPayment(BigDecimal amount) { strategy.pay(amount); }
}
```

</v-click>
<v-click at="3">

```java
// classic/strategy/CreditCardPayment.java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) { System.out.println("Kredi karti ile odeme: " + amount); }
}
```

</v-click>
<v-click at="4">

```java
// classic/strategy/StrategyDemo.java
BigDecimal amount = new BigDecimal("299.99");
PaymentService service = new PaymentService(new CreditCardPayment());
service.processPayment(amount);
```

</v-click>

<div v-click="9" class="mt-2 p-2 rounded bg-red-400/10 border border-red-300/25 text-[11px]">
  <div class="text-red-300 font-semibold mb-1">Not</div>
  <div class="opacity-90">
    Strategy'nin ana fikri davranisi nesneden ayirmaktir. Klasikte interface + class, modernde functional interface + lambda ile ayni hedefe ulasiriz.
  </div>
</div>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Strategy</span>

<v-click at="5">

```java
// java.util.function paketinde
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

</v-click>
<v-click at="6">

```java
// modern/strategy/PaymentService.java
Consumer<BigDecimal> creditCard = amount ->
    System.out.println("Kredi karti ile odeme: " + amount + " TL");
```

</v-click>
<v-click at="7">

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

</v-click>
<v-click at="8">

```java
// StrategyDemo.modernApproach(...)
Consumer<BigDecimal> cc = PaymentService.creditCard("...0366", "Ahmet Yilmaz");
PaymentService.processPayment(cc, amount);
```

</v-click>
<v-click at="9">

```java
// runtime'da farkli strateji secimi
Consumer<BigDecimal> bank = PaymentService.bankTransfer("TR...1326", "Garanti");
PaymentService.processPayment(bank, amount);
```

</v-click>

<div class="mt-4 grid grid-cols-3 gap-2 text-xs">
  <div v-click="10" class="p-2 rounded bg-blue-400/10 border border-blue-300/25">
    <div class="text-blue-300 font-semibold mb-1">Functional Interface</div>
    <div class="opacity-85">Strategy davranisini sinif yerine fonksiyonel bir tip (ornegin
      <code class="inline-block break-all">Consumer&lt;<wbr>BigDecimal<wbr>&gt;</code>) ile temsil ediyoruz.</div>
  </div>
  <div v-click="11" class="p-2 rounded bg-green-400/10 border border-green-300/25">
    <div class="text-green-300 font-semibold mb-1">Lambda ve Tip Bagimliligi</div>
    <div class="opacity-85">Java'da lambda tek basina tip tasimaz; hedef tipi her zaman bir functional interface belirler.</div>
  </div>
  <div v-click="12" class="p-2 rounded bg-yellow-400/10 border border-yellow-300/25">
    <div class="text-yellow-300 font-semibold mb-1">Daha Az Boilerplate</div>
    <div class="opacity-85">Daha az sınıf, daha kısa kod, daha kolay bakım ve test.</div>
  </div>
</div>

<!--
Bu kısımda pure function olayını destekleyecek konuşmada yerler eklemeliyiz.
-->

---

# 🎨 Decorator Pattern

<div class="mt-6 max-w-4xl">
  <div class="text-lg opacity-85 leading-relaxed">
    <span class="text-orange-400 font-semibold">Tanım:</span>
    Decorator, bir nesnenin davranışını ana sınıfı değiştirmeden katman katman genişletmeyi sağlayan yapısal bir pattern'dir.
  </div>
</div>

<div class="mt-4 flex justify-center">
  <object
    :data="`/images/decorator_pattern_oop_vs_fp.svg?play=${$slidev.nav.currentPage}-${$slidev.nav.clicks}`"
    type="image/svg+xml"
    alt="Decorator Pattern OOP ve FP karsilastirma diyagrami"
    class="h-[min(46vh,320px)] w-auto max-w-[92%] rounded-lg border border-white/10 bg-transparent"
  ></object>
</div>

<!--
Konusmaci Notu:
- Sol tarafta nested wrapper yapisinin nasil buyudugunu anlat.
- Sag tarafta andThen zinciriyle ayni davranisin sinifsiz kuruldugunu vurgula.
- Vurgu cumlesi: Function Composition and andThen.

Kamera ve Lens örneği buraya çok iyi oturur.
-->

---
layout: two-cols
layoutClass: gap-3
class: text-xs
---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Decorator</span>

<v-click at="1">

```java
// classic/decorator/OrderService.java
public interface OrderService {
    Order process(Order order);
}
```

</v-click>
<v-click at="2">

```java
// classic/decorator/GiftWrapDecorator.java
public class GiftWrapDecorator implements OrderService {
    private final OrderService wrapped;
    public GiftWrapDecorator(OrderService wrapped) { this.wrapped = wrapped; }
    public Order process(Order order) {
        Order processed = wrapped.process(order);
        return processed.addFeature("Hediye Paketi", new BigDecimal("15"));
    }
}
// + InsuranceDecorator, ExpressShippingDecorator
```

</v-click>
<v-click at="3">

```java
// DecoratorDemo.classicApproach(...)
OrderService service = new ExpressShippingDecorator(
    new InsuranceDecorator(
        new GiftWrapDecorator(new BasicOrderService())
    )
);
var order = new Order("ORD-001", new BigDecimal("200"));
var result = service.process(order);
```

</v-click>

<div class="mt-3 grid grid-cols-3 gap-2 text-[11px]">
  <div v-click="7" class="p-2 rounded bg-orange-400/10 border border-orange-300/25">
    <div class="text-orange-300 font-semibold mb-1">Hap Bilgi 1</div>
    <div class="opacity-85">Classic yaklaşımda her yeni özellik için yeni bir wrapper sınıfı gerekir.</div>
  </div>
  <div v-click="8" class="p-2 rounded bg-blue-400/10 border border-blue-300/25">
    <div class="text-blue-300 font-semibold mb-1">Hap Bilgi 2</div>
    <div class="opacity-85">Modern tarafta <code>UnaryOperator</code> zinciriyle davranışlar composable hale gelir.</div>
  </div>
  <div v-click="9" class="p-2 rounded bg-green-400/10 border border-green-300/25">
    <div class="text-green-300 font-semibold mb-1">Hap Bilgi 3</div>
    <div class="opacity-85">Her iki tarafta da ana nesne bozulmadan özellik eklenir; Open/Closed korunur.</div>
  </div>
</div>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Decorator</span>

<v-click at="4">

```java
// modern/decorator/Order.java
public record Order(String id, BigDecimal basePrice, BigDecimal totalPrice, List<String> features) {
    public Order(String id, BigDecimal basePrice) {
        this(id, basePrice, basePrice, List.of());
    }
    public Order addFeature(String feature, BigDecimal extraCost) {
        var newFeatures = new ArrayList<>(features);
        newFeatures.add(feature);
        return new Order(id, basePrice, totalPrice.add(extraCost), newFeatures);
    }
}
```

</v-click>
<v-click at="5">

```java
// modern/decorator/OrderEnhancer.java
UnaryOperator<Order> standardFlow = OrderEnhancer.giftWrap()
    .andThen(OrderEnhancer.insurance())
    .andThen(OrderEnhancer.expressShipping());

var order = new Order("ORD-001", new BigDecimal("200"));
var standardResult = standardFlow.apply(order);
```

</v-click>
<v-click at="6">

```java
// kampanyaya gore dinamik composition
List<UnaryOperator<Order>> campaign = List.of(
    OrderEnhancer.giftWrap(),
    OrderEnhancer.expressShipping()
);
UnaryOperator<Order> campaignFlow = campaign.stream()
    .reduce(UnaryOperator.identity(), UnaryOperator::andThen);

var campaignResult = campaignFlow.apply(order);
```

</v-click>

<div v-click="10" class="mt-2 p-2 rounded bg-cyan-400/10 border border-cyan-300/25 text-[11px]">
  <div class="text-cyan-300 font-semibold mb-1">Function Composition Notu</div>
  <div class="opacity-85"><code>andThen()</code> soldan saga uygulanir; zincirdeki sira degistiginde toplam fiyat ve ozellik sirası da degisir.</div>
</div>

<!--
Geçiş: "Strategy behavioral'dı. Şimdi structural bir pattern — Decorator."
Ana mesaj: andThen() ile dinamik kombinasyon, runtime'da karar.
Vurgu: SVG'de sol taraf iç içe kutular, sağ taraf düz zincir. Görsel farkı söyle.
Beklenen soru: "reduce(identity, andThen) ne yapıyor?" → "List üzerinden pipeline oluşturuyor, sıra önemli."
-->

---

# 📋 Template Method Pattern

<div class="mt-6 max-w-4xl">
  <div class="text-lg opacity-85 leading-relaxed">
    <span class="text-blue-400 font-semibold">Tanım:</span>
    Template Method, bir algoritmanın iskeletini tanımlar; degisen adimlar alt siniflara
    ya da fonksiyon parametrelerine birakilir.
  </div>
</div>

<div class="mt-4 flex justify-center">
  <object
    :data="`/images/template_method_oop_vs_fp.svg?play=${$slidev.nav.currentPage}-${$slidev.nav.clicks}`"
    type="image/svg+xml"
    alt="Template Method OOP ve FP karsilastirma diyagrami"
    class="h-[min(46vh,320px)] w-auto max-w-[92%] rounded-lg border border-white/10 bg-transparent"
  ></object>
</div>

---
layout: two-cols
layoutClass: gap-3
class: text-xs
---

## <span class="text-red-400">Klasik OOP</span> <span class="opacity-40 text-xs">— Template Method</span>

<v-click at="1">

```java
// classic/templatemethod/AbstractOrderProcessor.java
public abstract class AbstractOrderProcessor {
    public final void process(Order order) {
        validateOrder(order);
        BigDecimal total = calculateTotal(order);
        applyDiscount(order, total);
        sendConfirmation(order);
    }
}
```

</v-click>
<v-click at="2">

```java
// degisen adimlar alt sinifa birakilir
protected abstract void validateOrder(Order order);
protected abstract BigDecimal calculateTotal(Order order);
protected abstract void applyDiscount(Order order, BigDecimal total);
protected abstract void sendConfirmation(Order order);
```

</v-click>
<v-click at="3">

```java
// TemplateMethodDemo.classicApproach(...)
var order = new Order("ORD-001", "Ahmet Yilmaz", items);
new StandardOrderProcessor().process(order);
new PremiumOrderProcessor().process(order);
```

</v-click>

::right::

## <span class="text-green-400">Modern FP</span> <span class="opacity-40 text-xs">— Template Method</span>

<v-click at="4">

```java
// modern/templatemethod/OrderProcessor.java
public record OrderProcessor(
    Consumer<Order> validator,
    Function<Order, BigDecimal> totalCalculator,
    BiConsumer<Order, BigDecimal> discountApplier,
    Consumer<Order> confirmationSender
) {}
```

</v-click>
<v-click at="5">

```java
public void process(Order order) {
    validator.accept(order);
    BigDecimal total = totalCalculator.apply(order);
    discountApplier.accept(order, total);
    confirmationSender.accept(order);
}
```

</v-click>
<v-click at="6">

```java
// TemplateMethodDemo.modernApproach(...)
OrderProcessor.standard().process(order);
OrderProcessor.premium().process(order);
```

</v-click>

<div v-click="7" class="mt-3 p-2 rounded bg-blue-400/10 border border-blue-300/25 text-[11px]">
  <div class="text-blue-300 font-semibold mb-1">Mesaj</div>
  <div class="opacity-85">Modern Java'da ayni iskelet, inheritance yerine composition ile kurulabilir.</div>
</div>

---

# Özet: Ne Öğrendik?

<div class="grid grid-cols-[1fr_1.5fr] gap-4 mt-4">

<div class="space-y-3">
  <div v-click="1" class="p-3 bg-gradient-to-r from-yellow-400/15 to-transparent rounded-lg border border-yellow-400/20">
    <div class="text-purple-400 font-bold mb-1 text-sm">Builder</div>
    <div class="text-xs opacity-70">Verbose builder → Immutability &amp; records</div>
  </div>
  <div v-click="2" class="p-3 bg-gradient-to-r from-blue-400/15 to-transparent rounded-lg border border-blue-400/20">
    <div class="text-yellow-400 font-bold mb-1 text-sm">Strategy</div>
    <div class="text-xs opacity-70">Interface + class → Lambda ifadesi</div>
  </div>
  <div v-click="3" class="p-3 bg-gradient-to-r from-purple-400/15 to-transparent rounded-lg border border-purple-400/20">
    <div class="text-blue-400 font-bold mb-1 text-sm">Decorator</div>
    <div class="text-xs opacity-70">Class hiyerarşisi → andThen() kompozisyonu</div>
  </div>
  <div v-click="4" class="p-3 bg-gradient-to-r from-cyan-400/15 to-transparent rounded-lg border border-cyan-400/20">
    <div class="text-cyan-400 font-bold mb-1 text-sm">Template Method</div>
    <div class="text-xs opacity-70">Abstract class → Higher-order functions</div>
  </div>
</div>

<div class="space-y-3">
  <div v-click="5" class="p-4 bg-green-400/10 rounded-lg border border-green-400/20">
    <div class="text-green-400 text-sm font-bold mb-2">Modern Java'nın Kazanımları</div>
    <ul class="text-xs opacity-80 space-y-1 list-none">
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> %60-80 daha az kod</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Daha yüksek okunabilirlik</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> Daha kolay test edilebilirlik</li>
      <li class="flex items-start gap-2"><span class="text-green-400">✓</span> <span>Yüksek composability — küçük davranış parçalarını (lambda, <code>andThen</code>, HOF) birleştirerek yeni akışlar kurmak</span></li>
    </ul>
  </div>

  <div v-click="6" class="p-4 bg-yellow-400/10 rounded-lg border border-yellow-400/20">
    <div class="text-yellow-400 text-sm font-bold mb-2">Kullanılan Java Özellikleri</div>
    <div class="grid grid-cols-2 gap-1 text-xs opacity-80">
      <div>• Lambda Expressions</div>
      <div>• Functional Interfaces</div>
      <div>• Stream API</div>
      <div>• Method References</div>
      <div>• Records</div>
      <div>• Sealed Classes</div>
      <div>• Pattern Matching</div>
    </div>
  </div>
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
layout: default
class: '!pt-10 !pb-6'
---

<div class="text-xl font-bold mb-2 tracking-tight">OOP vs FP — karar çerçevesi</div>

<div class="max-w-6xl mx-auto space-y-2">

<div class="grid lg:grid-cols-[minmax(0,1.15fr)_minmax(0,1fr)] gap-3 items-start">

<div class="rounded-xl border border-white/12 bg-gradient-to-b from-white/[0.05] to-transparent p-2 shadow-[0_0_24px_rgba(0,0,0,0.3)]">
<div class="text-[10px] uppercase tracking-wider text-white/45 font-semibold mb-1 text-center">Aynı domain — iki rol</div>
<img src="/images/chess_oop_fp_diagram.svg" alt="Satranç: OOP varlıklar, FP kurallar" class="w-full h-auto max-h-[min(30vh,268px)] object-contain object-top mx-auto rounded-md" />
<div class="mt-1.5 flex flex-wrap justify-center gap-1 text-[9px] leading-none">
<span class="px-1.5 py-0.5 rounded-full bg-violet-500/20 text-violet-200/95 border border-violet-400/20">OOP → kimlik · durum</span>
<span class="px-1.5 py-0.5 rounded-full bg-emerald-500/20 text-emerald-200/95 border border-emerald-400/20">FP → saf fonksiyon</span>
</div>
<div class="mt-2 rounded-lg border border-amber-400/35 bg-gradient-to-r from-amber-500/12 to-orange-500/8 px-2.5 py-2 text-center">
<div class="text-amber-100 font-semibold text-xs leading-tight">
OOP <span class="text-white/45 font-normal">“neyi”</span> · FP <span class="text-white/45 font-normal">“nasıl”</span>
</div>
<div class="text-[9px] text-white/55 mt-1 leading-snug">Doğru aracı doğru katmana vermek.</div>
</div>
</div>

<div class="space-y-2 text-[11px] leading-tight md:text-xs md:leading-snug [&_code]:text-[10px] [&_code]:px-1 [&_code]:py-0 [&_code]:rounded [&_code]:bg-white/12 [&_code]:text-white/90">

<div class="rounded-lg border border-violet-400/30 bg-violet-950/35 p-2.5">
<div class="flex items-center gap-1.5 mb-1">
<span class="text-base opacity-90" aria-hidden="true">♟</span>
<span class="font-bold text-violet-200/95 text-xs">OOP — kimlik ve durum</span>
</div>
<ul class="list-none space-y-1 text-white/78 pl-0.5">
<li class="flex gap-1.5"><span class="text-violet-400 shrink-0">▸</span><span>Taşlar <em>nesnedir</em>; konum, geçmiş, “rok oldu mu?” gibi <strong class="text-white/88">durum</strong> vardır.</span></li>
<li class="flex gap-1.5"><span class="text-violet-400 shrink-0">▸</span><span><code class="font-mono">King</code>, <code class="font-mono">Rook</code>, <code class="font-mono">Pawn</code>… <code class="font-mono">Piece</code> özelleşmesi — kalıtım burada doğal.</span></li>
<li class="flex gap-1.5"><span class="text-violet-400 shrink-0">▸</span><span>OOP: <strong class="text-white/88">kimlik ve durum</strong>.</span></li>
</ul>
</div>

<div class="rounded-lg border border-emerald-400/30 bg-emerald-950/30 p-2.5">
<div class="flex items-center gap-1.5 mb-1">
<span class="text-base font-mono text-emerald-300/90 leading-none" aria-hidden="true">λ</span>
<span class="font-bold text-emerald-200/95 text-xs">FP — kurallar ve dönüşüm</span>
</div>
<ul class="list-none space-y-1 text-white/78 pl-0.5">
<li class="flex gap-1.5"><span class="text-emerald-400 shrink-0">▸</span><span>Hamle, şah, mat: <strong class="text-white/88">evrensel</strong> kurallar (kişisel tercih değil).</span></li>
<li class="flex gap-1.5"><span class="text-emerald-400 shrink-0">▸</span><span class="min-w-0"><code class="font-mono">legalMoves(…)</code>, <code class="font-mono">isInCheck(…)</code> — aynı girdi, aynı sonuç; <strong class="text-white/88">saf, yan etkisiz</strong>.</span></li>
<li class="flex gap-1.5"><span class="text-emerald-400 shrink-0">▸</span><span>FP: <strong class="text-white/88">nasıl hesaplandığı</strong>.</span></li>
</ul>
</div>

<div class="rounded-lg border border-sky-400/25 bg-sky-950/25 p-2.5">
<div class="font-bold text-sky-200 text-xs mb-1">Birlikte</div>
<ul class="list-none space-y-1 text-white/78 pl-0.5">
<li class="flex gap-1.5"><span class="text-sky-400 shrink-0">▸</span><span><code class="font-mono">King</code> konumu bilir; şah kontrolü saf fonksiyonda.</span></li>
<li class="flex gap-1.5"><span class="text-sky-400 shrink-0">▸</span><span><code class="font-mono">applyMove</code> yeni tahta döndürür → minimax için durumlar <strong class="text-white/88">bağımsız</strong>.</span></li>
</ul>
</div>

</div>
</div>

</div>

<!--
Konusmaci Notu:
- Satranc metaforu (varliklar vs kurallar) slaytta yok; giris cumlesi olarak sen anlat.
- Buyuk resim: Yazilimdaki secimlerin amaci "kodda bir problem cozmek" degil; isin, kullanicinin veya orgutun
  dunyadaki (gercek) problemini cozmek. Karar agaci da OOP/FP de bu hedefe hizmet eden araclardir; stil savasi icin degil.
- Iki yaklasim da gerekir: Ayni urunde domain ve surdurulebilirlik icin OOP, veri akisi ve ifade gucu icin FP
  birlikte dusunulur; "sadece biri" degil, problem turune gore ikisinin dengesi.
- Bu slayt "Ne zaman hangi yaklasim?"nin ozetidir; satranç diyagrami karar cercevesini somutlastirir.
- Klasik OOP tercih:
  * Karmasik state yonetimi gerekiyorsa
  * Cok sayida field/method ve kalitim hiyerarsisi kritikse
  * Legacy kod ve framework class beklentisi varsa
  * Ekipte FP deneyimi sinirliysa
- Modern FP tercih:
  * Basit, tek sorumluluklu davranislar varsa
  * Composability yuksek oncelikse
  * Runtime'da dinamik davranis degisimi gerekiyorsa
  * Stream/data transformation agirlikli akis varsa
  * Test edilebilirlik oncelikliyse
- Hibrit mesaji:
  * Domain logic tarafinda OOP, data pipeline tarafinda FP genelde en iyi dengeyi verir.
  * Ana ilke: dogru araci dogru yerde kullanmak.
-->

---
layout: center
class: text-center
---

<div class="max-w-3xl mx-auto px-6 py-3 space-y-8">
  <div>
    <div class="text-left border-l-4 border-orange-400/50 pl-6 py-2 space-y-2 text-lg md:text-xl text-white/90 leading-relaxed">
      <p>Don't be a functional programmer.</p>
      <p>Don't be an object-oriented programmer.</p>
      <p class="text-yellow-300 font-semibold not-italic">Be a better programmer.</p>
    </div>
    <div class="mt-6 text-sm text-orange-300">Brian Goetz</div>
    <div class="text-xs opacity-60 mt-1">
      <cite>FP vs OO: Choose Two</cite>
    </div>
  </div>

  <div class="text-left border-l-4 border-yellow-400/45 pl-4 pt-1">
    <p class="text-sm md:text-base leading-relaxed text-white/88 italic">
      Any fool can write code that a computer can understand. Good programmers write
      code that humans can understand.
    </p>
    <div class="mt-2 text-xs text-yellow-400">Martin Fowler</div>
    <div class="text-[11px] opacity-55 mt-0.5">
      <cite>Refactoring: Improving the Design of Existing Code</cite>
    </div>
  </div>
</div>

---
layout: center
class: text-center
---

<div class="h-full w-full flex flex-col items-center justify-center text-center px-4 py-3">
  <div class="text-4xl font-bold bg-gradient-to-r from-yellow-400 via-orange-400 to-red-400 bg-clip-text text-transparent mb-2">
    Teşekkürler!
  </div>

  <div class="text-lg opacity-70 mb-2 max-w-xl">
    Modern Java ile Design Patterns'ın Fonksiyonel Evrimi
  </div>

  <div class="grid grid-cols-3 gap-3 mb-2 w-full max-w-6xl">
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">GitHub</div>
      <div class="text-yellow-400 font-mono text-xs mb-1">github.com/umiitkose</div>
      <div class="text-xs opacity-50 mb-1">GitHub QR</div>
      <img src="/images/github-repo-qr.png" alt="GitHub QR code" class="w-20 h-20 mx-auto rounded bg-white p-1" />
    </div>
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">YouTube</div>
      <div class="text-yellow-400 font-mono text-xs mb-1">Design Patterns Serisi</div>
      <div class="text-xs opacity-50 mb-1">YouTube QR</div>
      <img src="/images/youtube-playlist-qr.png" alt="YouTube design patterns playlist QR code" class="w-20 h-20 mx-auto rounded bg-white p-1" />
    </div>
    <div class="p-3 bg-white/5 rounded-lg border border-white/10 text-center">
      <div class="text-sm opacity-50 mb-1">Örnek Kodlar</div>
      <div class="text-yellow-400 font-mono text-[10px] leading-tight break-all">javadayistanbul-functional-evolution-of-design-patterns-with-modern-Java</div>
      <div class="text-xs opacity-50 mt-2 mb-1">Repo QR</div>
      <img src="/images/github-repo-qr.png" alt="GitHub repository QR code" class="w-20 h-20 mx-auto rounded bg-white p-1" />
    </div>
  </div>

  <div class="text-2xl opacity-85 mt-1">
    Sorularınız?
  </div>

</div>
