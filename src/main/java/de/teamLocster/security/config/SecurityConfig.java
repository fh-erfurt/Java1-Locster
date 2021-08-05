package de.teamLocster.security.config;

import de.teamLocster.security.auth.AuthProvider;
import de.teamLocster.user.LocsterUserDetailsService;
import de.teamLocster.security.web.LoggingAccessDeniedHandler;
import de.teamLocster.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private static final int EXPIRATION_TIME_OF_COOKIE = 20; //3600 * 24 * 7 * 2;

    @Qualifier("locsterUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthProvider authProvider;

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .authenticationProvider(authProvider);
    }
}