package ru.skblab.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity( jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("user").password(passwordEncoder().encode("password"))
                .roles("USER").build());
        userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("password"))
                .roles("ADMIN").build());
        userDetailsList.add(User.withUsername("support").password(passwordEncoder().encode("password"))
                .roles("SUPPORT").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }
}
