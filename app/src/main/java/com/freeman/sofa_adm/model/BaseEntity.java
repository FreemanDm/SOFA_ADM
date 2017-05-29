package com.freeman.sofa_adm.model;


public class BaseEntity {
    public static final int START_SEQ = 100000;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
