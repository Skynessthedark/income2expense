package com.finance.income2expense.model;

import com.finance.income2expense.model.base.ItemModel;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Authority")
public class AuthorityModel extends ItemModel {

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "authority_roles",
            joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<RoleModel> roles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
