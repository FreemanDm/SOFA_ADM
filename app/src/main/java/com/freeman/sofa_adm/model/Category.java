package com.freeman.sofa_adm.model;


import java.util.List;


public class Category extends BaseEntity {


    private List<CategoryTranslate> categoryTranslate;

    public Category() {
    }

    public List<CategoryTranslate> getCategoryTranslate() {
        return categoryTranslate;
    }

    public void setCategoryTranslate(List<CategoryTranslate> categoryTranslate) {
        this.categoryTranslate = categoryTranslate;
    }
}
