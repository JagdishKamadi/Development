package com.epam.quiz.config;

import com.epam.quiz.service.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfiguration {
    @Autowired
    private AppUserDetailsService userDetailsService;
    @Bean
    public AuthenticationManager getAuthenticationManager() {
        return new ProviderManager(List.of(getAuthenticationProvider()));
    }

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
                .authenticationManager(getAuthenticationManager())
                .formLogin()
                .and()
                .logout(logout -> logout.logoutUrl("/logout"))
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/authenticate");
    }


    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        // set the password
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }

//    @Bean
//    public GrantedAuthoritiesMapper getAuthoritiesMapper() {
//        SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
//        mapper.setConvertToUpperCase(true);
//        mapper.setDefaultAuthority("USER");
//        return mapper;
//    }
}
