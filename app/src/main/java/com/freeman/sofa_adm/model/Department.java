package com.freeman.sofa_adm.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends BaseEntity {

    private List<Branch> branches = new ArrayList<>();

    public Department() {
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
