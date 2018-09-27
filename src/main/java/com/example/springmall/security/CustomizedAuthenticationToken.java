package com.example.springmall.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomizedAuthenticationToken extends AbstractAuthenticationToken {

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */

    private String principal;

    public CustomizedAuthenticationToken(String principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public String getCredentials() {
        return null;
    }

    @Override
    public String getPrincipal() {
        return this.principal;
    }
}
