package com.epam.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyAppSecurity extends WebSecurityConfigurerAdapter {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    /* this is for authentication */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Madhur")
                .password(getBcryptPasswordEncoder().encode("Madhur@99")).roles(USER)
                .and()
                .withUser("Jagdish")
                .password(getBcryptPasswordEncoder().encode("Jagdish@99")).roles(ADMIN);

    }

    /* use password encoder*/
    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* now configure for authorization*/
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/admin").hasRole(ADMIN)
                .antMatchers("/user").hasAnyRole(USER, ADMIN)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }
}
