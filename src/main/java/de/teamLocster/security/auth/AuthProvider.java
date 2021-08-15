package de.teamLocster.security.auth;

import java.util.*;

import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * "AuthenticationProvider" implementation to authenticate requests and logins.
 *
 *
 * @author  Jakob Gensel
 * @see     de.teamLocster.security.config.SecurityConfig
 */

@Component
public class AuthProvider implements AuthenticationProvider
{
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String)authentication.getCredentials();
        try
        {
            // get user from DB, if exists (otherwise UserNotFoundException is thrown and converted)
            User user = userService.getUserByEmailAddress(email);
            // check if the passwords match and throw BadCredentialsException otherwise
            if(!passwordEncoder.matches(password, user.getPasswordHash())) {
                throw new BadCredentialsException("Passwords didn't match!");
            }

            // create authorities and add user role
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            // set user as logged in in database
            userService.login(email);

            // create and return the authentication
            return new UsernamePasswordAuthenticationToken(email, password, authorities);
        }
        catch (UserNotFoundException unfEx) {
            throw new UsernameNotFoundException(unfEx.getMessage(), unfEx);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}