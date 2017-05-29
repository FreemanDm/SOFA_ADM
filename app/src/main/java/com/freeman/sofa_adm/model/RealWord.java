package com.freeman.sofa_adm.model;

public class RealWord extends NamedEntity {

    private Language language;

    public RealWord() {
    }

    public RealWord(String name, Language language) {
        super(name);
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
