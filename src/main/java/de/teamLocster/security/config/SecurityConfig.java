package de.teamLocster.security.config;

import de.teamLocster.security.auth.AuthProvider;
import de.teamLocster.security.web.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class is used for security configuration like access and authorization.
 *
 * @author  Jakob Gensel
 * @see     de.teamLocster.security.auth.AuthProvider
 * @see     de.teamLocster.user.LocsterUserDetailsService
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private static final int EXPIRATION_TIME_OF_COOKIE = 20; // TODO (2 weeks) 3600 * 24 * 7 * 2;

    @Autowired
    @Qualifier("locsterUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthProvider authProvider;

    @Autowired
    private LogoutHandler logoutHandler;

    // TODO probably not needed
    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/css/**",
                        "/icons/**",
                        "/images/**",
                        "/js/**",
                        "/signup"
                )
                .permitAll()
                .antMatchers("/**")
                    .fullyAuthenticated()
                    .anyRequest()
                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("emailAddress")
                    .passwordParameter("password")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/whoisonline")
                .permitAll()
                .and()
                .rememberMe()
                    .rememberMeParameter("remember-login")
                    .tokenValiditySeconds(EXPIRATION_TIME_OF_COOKIE)
                    .userDetailsService(userDetailsService)
                .and()
                .logout()
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .addLogoutHandler(logoutHandler)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .authenticationProvider(authProvider)
                .sessionManagement().maximumSessions(2);
    }
}