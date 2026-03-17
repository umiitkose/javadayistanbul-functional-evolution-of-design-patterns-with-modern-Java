#!/bin/bash
# Kod Istatistikleri - Klasik OOP vs Modern FP karsilastirmasi

echo "============================================================"
echo "  KOD ISTATISTIKLERI"
echo "  Klasik OOP vs Modern FP Karsilastirmasi"
echo "============================================================"
echo ""

BASE="src/main/java/com/javadayistanbul/patterns"

count_files() {
    local dir="$1"
    local count=0
    for f in "$dir"/*.java "$dir"/**/*.java; do
        [ -f "$f" ] && count=$((count + 1))
    done
    echo $count
}

count_lines() {
    local dir="$1"
    local total=0
    for f in "$dir"/*.java "$dir"/**/*.java; do
        if [ -f "$f" ]; then
            local lines
            lines=$(wc -l < "$f")
            total=$((total + lines))
        fi
    done
    echo $total
}

count_pattern() {
    local pattern="$1"
    local classic_dir="$BASE/classic/$pattern"
    local modern_dir="$BASE/modern/$pattern"

    local cf=0 cl=0 mf=0 ml=0

    if [ -d "$classic_dir" ]; then
        cf=$(count_files "$classic_dir")
        cl=$(count_lines "$classic_dir")
    fi

    if [ -d "$modern_dir" ]; then
        mf=$(count_files "$modern_dir")
        ml=$(count_lines "$modern_dir")
    fi

    printf "  %-25s %8s %8s %8s %8s\n" "$pattern" "$cf" "$mf" "$cl" "$ml"
}

CLASSIC_FILES=$(count_files "$BASE/classic")
MODERN_FILES=$(count_files "$BASE/modern")
DEMO_FILES=$(count_files "$BASE/demo")

CLASSIC_LINES=$(count_lines "$BASE/classic")
MODERN_LINES=$(count_lines "$BASE/modern")

echo "  DOSYA SAYISI"
echo "  ----------------------------------------"
echo "  Klasik OOP  : $CLASSIC_FILES dosya"
echo "  Modern FP   : $MODERN_FILES dosya"
echo "  Demo        : $DEMO_FILES dosya"
echo ""

echo "  SATIR SAYISI"
echo "  ----------------------------------------"
echo "  Klasik OOP  : $CLASSIC_LINES satir"
echo "  Modern FP   : $MODERN_LINES satir"

REDUCTION=0
if [ "$CLASSIC_LINES" -gt 0 ]; then
    REDUCTION=$(( (CLASSIC_LINES - MODERN_LINES) * 100 / CLASSIC_LINES ))
    echo ""
    echo "  AZALMA       : %$REDUCTION daha az kod!"
fi

echo ""
echo "  PATTERN BAZINDA DETAY"
echo "  ----------------------------------------"
printf "  %-25s %8s %8s %8s %8s\n" "Pattern" "K.Dosya" "M.Dosya" "K.Satir" "M.Satir"
echo "  ----------------------------------------"

for pattern in strategy builder templatemethod decorator visitor observer factory state chainofresponsibility command adapter; do
    count_pattern "$pattern"
done

echo ""
echo "============================================================"
echo "  Ayni islevsellik, %$REDUCTION daha az kod!"
echo "============================================================"
