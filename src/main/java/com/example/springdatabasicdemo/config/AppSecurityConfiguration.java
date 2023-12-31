package com.example.springdatabasicdemo.config;

import com.example.springdatabasicdemo.constants.Role;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import com.example.springdatabasicdemo.services.impl.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class AppSecurityConfiguration {
    @Autowired
    private UsersRepository usersRepository;

    public AppSecurityConfiguration(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
        http
            .authorizeHttpRequests(
                authorizeHttpRequests ->
                    authorizeHttpRequests.
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                        .permitAll().
                        requestMatchers("/homepage", "/users/login", "/users/register", "/users/login-error")
                        .permitAll().
                        requestMatchers("/users/profile").authenticated().
                        requestMatchers("/users/add", "/users/user-delete/").hasRole(Role.ADMIN.name()).
                        anyRequest().authenticated()
            )
            .formLogin(
                (formLogin) ->
                    formLogin.
                        loginPage("/users/login").
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                        defaultSuccessUrl("/").
                        failureForwardUrl("/users/login-error")
            )
            .logout((logout) ->
                logout.logoutUrl("/users/logout").
                    logoutSuccessUrl("/").
                    invalidateHttpSession(true)
            ).securityContext(
                securityContext -> securityContext.
                    securityContextRepository(securityContextRepository)
            );

        return http.build();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
            new RequestAttributeSecurityContextRepository(),
            new HttpSessionSecurityContextRepository()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() { return new AppUserDetailsService(usersRepository); }
}

