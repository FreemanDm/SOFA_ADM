package com.freeman.sofa_adm.model;

public class KeyWord extends NamedEntity {

    private RealWord realWord;
    private Language language;

    public KeyWord() {
    }

    public KeyWord(String name, RealWord realWord, Language language) {
        super(name);
        this.realWord = realWord;
        this.language = language;
    }

    public RealWord getRealWord() {
        return realWord;
    }

    public void setRealWord(RealWord realWord) {
        this.realWord = realWord;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
