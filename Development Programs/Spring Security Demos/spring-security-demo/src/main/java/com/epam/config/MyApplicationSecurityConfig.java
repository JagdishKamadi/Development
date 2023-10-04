package com.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
// below annotation must to used while role base accessing
@EnableGlobalMethodSecurity(prePostEnabled = true)   // for the method base authority role
public class MyApplicationSecurityConfig {

    // this will always execute first
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        // disable csrf for POST Method
        http.csrf()
                .disable()
                .authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
                                            .httpBasic(withDefaults());
        return http.build();
    }

    // for ignoring(skipping) some request
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer()
//    {
//        return (web) -> web
//                        .ignoring()
//                        .antMatchers("/public/**");
//
//
//        /*
//            // for multiple request in same class and customize request mode
//                      (web) -> web
//                        .ignoring()
//                        .antMatchers(HttpMethod.GET,,"/users/**");
//         */
//
//    }

    // for in memory database authentication
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        List<UserDetails> userDetailsList = new ArrayList<>();
//        userDetailsList.add(User.withDefaultPasswordEncoder().username("Jagdish").password("Jagdish@99").roles("USER").build());
//        userDetailsList.add(User.withDefaultPasswordEncoder().username("Admin").password("Admin@00").roles("ADMIN").build());
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    // below step using BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("Jagdish").password(passwordEncoder().encode("Jagdish@99")).roles("USER").build());
        userDetailsList.add(User.withUsername("Admin").password(passwordEncoder().encode("Admin@00")).roles("ADMIN").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }

}
