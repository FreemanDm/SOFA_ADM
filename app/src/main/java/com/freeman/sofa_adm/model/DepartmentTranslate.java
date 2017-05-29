package com.freeman.sofa_adm.model;

public class DepartmentTranslate extends NamedEntity {

    private Category category;
    private Language language;
    private Department department;

    public DepartmentTranslate() {
    }

    public DepartmentTranslate(String name, Category category, Language language, Department department) {
        super(name);
        this.category = category;
        this.language = language;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
