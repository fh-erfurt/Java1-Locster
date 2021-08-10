package de.teamLocster.security.auth;

import java.util.*;

import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        User user = userRepository.findByEmailAddress(username).get(); // TODO USE SERVICE and TRY CATCH

        boolean authenticated = user != null && passwordEncoder.matches(password, user.getPasswordHash());
        // TODO try catch

        Collection<? extends org.springframework.security.core.GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        Authentication result = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);

        return authenticated ? result : null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}