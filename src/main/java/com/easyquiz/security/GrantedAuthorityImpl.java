package com.easyquiz.security;

/**
 * Created by felleuch on 25/01/2018.
 */
import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String role;

    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }
}
