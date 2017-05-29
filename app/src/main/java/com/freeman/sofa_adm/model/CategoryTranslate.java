package com.freeman.sofa_adm.model;

public class CategoryTranslate extends NamedEntity {

    private Category category;
    private Language language;

    public CategoryTranslate() {
    }

    public CategoryTranslate(String name) {
        super(name);
    }

    public CategoryTranslate(String name, Category category, Language language) {
        super(name);
        this.category = category;
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
