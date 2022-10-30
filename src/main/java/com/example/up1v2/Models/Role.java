package com.example.up1v2.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, RolerOfRoles;

    @Override
    public String getAuthority() { return name(); }
}
