package com.finance.income2expense.model;

import com.finance.income2expense.model.base.ItemModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Role")
public class RoleModel extends ItemModel {

    @Column(unique = true, nullable = false)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
