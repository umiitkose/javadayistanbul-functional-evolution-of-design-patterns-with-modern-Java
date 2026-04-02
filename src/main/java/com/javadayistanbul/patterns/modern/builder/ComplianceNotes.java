package com.javadayistanbul.patterns.modern.builder;

/**
 * Tehlikeli madde, menşe ve ic notlar (uzunluk/kod kurallari).
 */
public record ComplianceNotes(String hazmatCategory, String originCountryCode, String internalNotes) {

    public static ComplianceNotes empty() {
        return new ComplianceNotes(null, null, null);
    }

    public ComplianceNotes {
        if (hazmatCategory != null && !hazmatCategory.isBlank() && hazmatCategory.length() > 16) {
            throw new IllegalArgumentException("Tehlikeli madde kodu en fazla 16 karakter olabilir");
        }
        if (originCountryCode != null && !originCountryCode.isBlank()
                && originCountryCode.length() != 2) {
            throw new IllegalArgumentException("Menşe ulke kodu tam 2 karakter olmalidir (ISO)");
        }
        if (internalNotes != null && internalNotes.length() > 500) {
            throw new IllegalArgumentException("Ic notlar en fazla 500 karakter olabilir");
        }
    }
}
