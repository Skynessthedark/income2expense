package com.finance.income2expense.model;

import com.finance.income2expense.model.base.ItemModel;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserModel extends ItemModel implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private boolean isEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private AuthorityModel authority;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthorityModel getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityModel authority) {
        this.authority = authority;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.authority == null || this.authority.getRoles() == null || this.authority.getRoles().isEmpty()) {
            return null;
        }
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(this.authority.getRoles().iterator().next().getCode());

        return Set.of(userAuthority);
    }
}
