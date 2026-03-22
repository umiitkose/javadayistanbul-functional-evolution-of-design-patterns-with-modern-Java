# Slidev Sunumu

Bu klasor, JavaDay Istanbul sunumu icin hazirlanan Slidev sunumunu icerir.

## Kurulum

```bash
cd slidev
npm install
```

## Kullanim

### Gelistirme Modu

```bash
npm run dev
```

Tarayicida `http://localhost:3030` adresinde sunum acilir.

### Build / Export

```bash
# Statik cikti
npm run build

# PDF export
npm run export
```

## Sunum Icerigi (Guncel)

Sunumda 5 ana pattern modern Java yaklasimlari ile karsilastirmali anlatilir:

- Strategy
- Template Method
- Decorator
- Builder
- Iterator/Stream

## Son Guncellemeler

- Kod slaytlari tek seferde kalabalik gostermek yerine adim adim (`v-click`) akisla ilerler.
- Pattern kodlarinda gorunen satir sayisi sadeleştirildi; ana fikir odakta tutuldu.
- Kapanis slaydinda iletisim/kaynak kartlari guncellendi.
- Son slaytta:
  - YouTube oynatma listesi icin QR karti yer alir.
  - Ornek Kodlar karti ile Repo QR birlestirilmistir.

## QR Varliklari

Sunumda kullanilan QR dosyalari:

- `public/images/github-repo-qr.png`
- `public/images/youtube-playlist-qr.png`

Not: QR gorselleri degistirilecekse ayni dosya adlari korunursa `slides.md` tarafinda ekstra guncelleme gerekmez.

## Klavye Kisayollari

- `Space` veya `Right Arrow`: Sonraki slayt / adim
- `Left Arrow`: Onceki slayt / adim
- `f`: Fullscreen
- `o`: Overview
- `g`: Belirli slayta git
