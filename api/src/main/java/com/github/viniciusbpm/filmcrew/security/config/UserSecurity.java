package com.github.viniciusbpm.filmcrew.security.config;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class UserSecurity implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;

    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public UserSecurity(UserModel user) {

        this.id = user.getId();
        this.username = user.getEmail();
        this.password = user.getPassword();

        this.accountNonExpired = user.isActive();
        this.accountNonLocked = user.isActive();
        this.credentialsNonExpired = user.isActive();
        this.enabled = user.isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
