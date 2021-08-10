package de.teamLocster.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * "UserDetails" implementation to handle user authorities and data.
 *
 * @author  Jakob Gensel
 * @see     de.teamLocster.user.LocsterUserDetailsService
 */

@Getter
public class LocsterUserDetails implements UserDetails
{
    private final User user;

    private final List<GrantedAuthority> authorities;

    public LocsterUserDetails(User user) {
        this.user = user;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword(){
        return this.user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return this.user.getEmailAddress();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        // TODO
        return true;
    }
}
