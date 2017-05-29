package com.freeman.sofa_adm.model;

public class Tip extends NamedEntity {

    private Department department;
    private Language language;

    public Tip() {
    }

    public Tip(String name, Department department) {
        super(name);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
